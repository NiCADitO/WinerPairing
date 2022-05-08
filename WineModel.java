package application;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.scene.image.Image;

public class WineModel 
{
	private JsonElement jse;
	private JsonObject jso;

	
	// Gets Json data from api based 
	// on food entered by user
	public boolean getWine(String food) 
	{

		try 
		{
			// Construct WxStation API URL
			URL wxURL = new URL("https://api.spoonacular.com/food/wine/pairing?food=" + food + "&apiKey=9a9185b1d22c44c89c80e9ccc487cca4");

			// Open the URL
			InputStream is = wxURL.openStream(); // throws an IOException
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			// Read the result into a JSON Element
			jse = new JsonParser().parse(br);

			// Close the connection
			is.close();
			br.close();
		}
		// Catch exception
		// Only return true if no exception are found
		catch (java.io.FileNotFoundException fnfe) 
		{
			//fnfe.printStackTrace();
			return false;
		}
		catch (java.lang.NullPointerException npe) 
		{
			//npe.printStackTrace();
			return false;
		} 
		catch (java.io.UnsupportedEncodingException uee) 
		{
			//uee.printStackTrace();
			return false;
		} 
		catch (java.net.MalformedURLException mue) 
		{
			//mue.printStackTrace();
			return false;
		} 
		catch (java.io.IOException ioe) 
		{
			//ioe.printStackTrace();
			return false;
		}

		return true;
	}
	
	// Gets the top recommended wine
	// based on user input
	public String getWinePairing() 
	{
		
		if(checkIfValid() == false) 
		{
			 return "No wine pairing information found";	
		}
		
		else
		{
			JsonArray obs = jse.getAsJsonObject().get("pairedWines").getAsJsonArray();
			String pairing = obs.get(0).getAsString();
			return pairing;
		}
		
	}
	
	// Gets description text for wine 
	// pairing based on input form user
	public String getPairingText() {
		
		if(checkIfValid() == false) 
		{
			 return "No wine pairing information found";	
		}
		
		String text = jse.getAsJsonObject().get("pairingText").getAsString();
		
		
		return text;
	}
	
	// Returns false if nothing is entered, 
	// there is no info on that food 
	// or the size of the array is 0
	public boolean checkIfValid() {
		
		if(this.jse == null)
		{
			return false;
		}
		else if(jse.getAsJsonObject().get("status") != null) 
		{
			return false;
		}
		else if (jse.getAsJsonObject().get("pairedWines").getAsJsonArray().size() == 0) 
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	/*
	public Image getIcon() 
	{
		
		if(jse.getAsJsonObject().get("status") != null) 
		{
			return null;
		}
		
		String icon = jse.getAsJsonObject().get("imageUrl").getAsString();
	    Image img = new Image(icon);
		
	    return img;
	}
	
	
	public Image getIcon() 
	{
		if(jse.getAsJsonObject().get("status") != null) 
		{
			return null;
		}
		
		JsonArray obj = jse.getAsJsonObject().get("productMatches").getAsJsonArray();
	    String icon = obj.get(0).getAsJsonObject().get("imageUrl").getAsString();
	    Image img = new Image(icon);
		
	    return img;
	}
	*/
}
