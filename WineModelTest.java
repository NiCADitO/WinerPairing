package application;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WineModelTest 
{
	
	@Test
	public void testgetWine() 
	{
		WineModel b = new WineModel();
		assertEquals(true, b.getWine("apple"));
	}   

	@Test
	public void testNoInput() 
	{
		WineModel b = new WineModel();
		assertEquals(false, b.getWine(""));
	}
	
	@Test
	public void testValidFood() 
	{
		WineModel b = new WineModel();
		b.getWine("apple");
		assertEquals("champagne", b.getWinePairing());
	}  
	
	@Test
	public void testInvalidFood() 
	{
		WineModel b = new WineModel();
		b.getWine("1234");
		assertEquals("No wine pairing information found", b.getWinePairing());
	}
	
	@Test
	public void testInvalidFood1() 
	{
		WineModel b = new WineModel();
		b.getWine("jam");
		assertEquals("No wine pairing information found", b.getWinePairing());
	}
	
	@Test
	public void testValidDescription() 
	{
		WineModel b = new WineModel();
		b.getWine("apple");
		assertEquals(b.getPairingText(), b.getPairingText());
	}
	
	@Test
	public void testInvalidDescription() 
	{
		WineModel b = new WineModel();
		b.getWine("1234");
		assertEquals("No wine pairing information found", b.getPairingText());
	}
	
	@Test
	public void testCheckIfValid() 
	{
		WineModel b = new WineModel();
		b.getWine("apple");
		assertEquals(true, b.checkIfValid());
	}
	
	@Test
	public void testCheckIfValid1() 
	{
		WineModel b = new WineModel();
		b.getWine("1234");
		assertEquals(false, b.checkIfValid());
	}
	
	@Test
	public void testCheckIfValid2() 
	{
		WineModel b = new WineModel();
		b.getWine("jam");
		assertEquals(false, b.checkIfValid());
	}
	
	
	
	/*
	*/
}
