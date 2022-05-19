package clients.homepage;

/**
 * <h1>Controller for the Home page</h1>
 * Allows for the home page model and view to communicate
 * @author Brad
 *
 */
public class HomeController {
	
	private HomeModel model; 
	private HomeView view;

	/**
	 * Construct the controller
	 * @param model set the model
	 * @param view set the view
	 */
	public HomeController(HomeModel model, HomeView view) {
		this.model = model;
		this.view = view;
		
		view.setController(this);
		model.setController(this);	
	}
	
	/**
	 * Function called from view to open the calculator using model
	 */
	public void openCalculator() {
		model.startCalculatorGUI_MVC();
	}
	
	/**
	 * Function that takes in the search type and the search value to query the database
	 * @param type Field to searched in the database
	 * @param value Value of said field
	 */
	public void getRecords(String type, String value) {
		model.getRecords(type, value);
		
	}
	
	
}
