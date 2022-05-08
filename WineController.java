package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WineController {
	
	@FXML
	private TextField textField1;
	@FXML
	private Button button1;
	@FXML
	private Label foodLabel;
	@FXML
	private Label pairingLabel;
	@FXML
	private ImageView iconWine;

	@FXML
	  private void buttonPressed(ActionEvent e) 
	{
	    // Create object to access the Model
		WineModel wine = new WineModel();

	    // Get zipcode
	    String food = textField1.getText();
	    pairingLabel.setWrapText(true);

	    // Use the model to get the weather information
	    if (wine.getWine(food))
	    {
	    	  foodLabel.setText(wine.getWinePairing());
	    	  pairingLabel.setText(wine.getPairingText());
	      //iconWine.setImage(null);
	    }
	   else
	   {
	    	foodLabel.setText("Invalid Entry");
	    	pairingLabel.setText("Please enter a valid food \n" + "Example: Apple");
	    	//iconWine.setImage(new Image("File:\\My Drive\\eclipse-workspace\\WinePairing\\src\\application\\badzipcode.png"));
	    }
	  }
	
}
