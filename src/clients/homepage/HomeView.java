package clients.homepage;

import java.awt.*;
import javax.swing.*;

/**
 * <H1> View for the Home page </H1>
 * Displays all elements to the home page
 * @author Brad
 *
 */
public class HomeView {
	
	private static final int H = 250;
	private static final int W = 750;
	
	private static final String CALCULATOR = "Calculate NEWS";
	private static final String SUBMIT = "Submit";
	
	private final String[] searchOptions = {"NHS Number", "First Name", "Last Name", "Staff Initials"};
	
	private final JLabel titlelbl		= new JLabel();
	private final JButton calcbtn		= new JButton( CALCULATOR );
	
		
	private final JLabel searchlbl		= new JLabel();
	private final JComboBox searchcb	= new JComboBox(searchOptions);
	private final JTextField searchtxt	= new JTextField();
	private final JButton searchbtn		= new JButton( SUBMIT );
	
	
	private HomeController cont;
	
	/**
	 * Construct the home page view
	 * 
	 * @param rpc Window to construct
	 * @param x x-coordinate
	 * @param y y-coordinate
	 */
	public HomeView(RootPaneContainer rpc, int x, int y) {
		
		Container cp = rpc.getContentPane();
		Container rootWindow = (Container) rpc;
		
		cp.setLayout(null);
		rootWindow.setSize(W,H);
		rootWindow.setLocation(x,y);
		cp.setBackground(new java.awt.Color(255,255,255));
		
		cp.setVisible(true);
				
		titlelbl.setBounds(25, 10+30*0, 150, 20);
		titlelbl.setText("Home");
		cp.add(titlelbl);
		
		calcbtn.setBounds(550, 50, 125, 20);
		calcbtn.addActionListener(
				e -> cont.openCalculator());
		cp.add(calcbtn);
		
		searchlbl.setBounds(50, 10+30*3, 200, 20);
		searchlbl.setText("Search for records based on: ");
		cp.add(searchlbl);
		
		searchcb.setBounds(220, 12+30*3, 100, 20);
		searchcb.setSelectedIndex(0);
		cp.add(searchcb);
		
		searchtxt.setBounds(320, 12+30*3, 110, 20);
		searchtxt.setText("");
		cp.add(searchtxt);
		
		searchbtn.setBounds(430, 12+30*3, 80, 20);
		searchbtn.addActionListener(e -> cont.getRecords(getSearchOption(), getSearchValue()));
		cp.add(searchbtn);
				
	}
	
	public void setController(HomeController c) {
		cont = c;
	}
	
	/**
	 * Get the search type
	 * @return search type
	 */
	public String getSearchOption() {
		return searchcb.getSelectedItem().toString();
	}
	
	/**
	 * Get the search value
	 * @return search value
	 */
	public String getSearchValue() {
		return searchtxt.getText();
	}
		

}
