package clients;

import clients.homepage.*;
import javax.swing.*;
import java.awt.*;

/**
 * Starts the first GUI of the program
 * @author Brad Durrance
 *
 */


public class Main {
	
	
	public static void main(String args[]) 
	{
		new Main().startHomePageGUI_MVC();
	}
	
	/**
	 * start the home page client
	 */
	public void startHomePageGUI_MVC()
	{
		JFrame window = new JFrame();
		window.setTitle("Home");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension pos = PositionOnScreen.getPos();
		
		//set MVC
		HomeModel model = new HomeModel();		
		HomeView view = new HomeView(window, pos.width, pos.height);
		HomeController cont = new HomeController(model, view);
				
		window.setVisible(true);
	}	

}
