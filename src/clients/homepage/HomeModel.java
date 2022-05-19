package clients.homepage;

import java.awt.*;
import javax.swing.JFrame;
import clients.PositionOnScreen;
import clients.calculator.CalculatorController;
import clients.calculator.CalculatorModel;
import clients.calculator.CalculatorView;

/**
 * <h1>Model for the Home page</h1>
 * @author Brad
 *
 */
public class HomeModel {
	
	private HomeController cont;
	public String[][] list = null;
	
	public HomeModel() {		
		 	
	}
		
	public void setController(HomeController c) {
		cont = c;
	}
	
	/**
	 * Starts the GUI of the calculator
	 */
	public void startCalculatorGUI_MVC()
	{
		JFrame window = new JFrame();
		window.setTitle("NEWS Calculator");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension pos = PositionOnScreen.getPos();
		
		CalculatorModel model = new CalculatorModel();
		CalculatorView view = new CalculatorView(window, pos.width, pos.height);
		CalculatorController cont = new CalculatorController(model, view);		
		
		window.setVisible(true);
	}
	
	/**
	 * Starts the GUI of the table
	 * @param type The field the search will use to find results
	 * @param value the value of the field 
	 */
	public void startTableGUI(String type, String value) {
		HomeTable ht = new HomeTable(type, value);
		ht.showFrame();
	}
	
	public void getRecords(String type, String value) {
		startTableGUI(type, value);
	}


}
