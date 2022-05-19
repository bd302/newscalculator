package clients.summary;


/**
 * <H1>Controller for the Summary window </H1>
 * 
 * Allows communication between the model and the view
 * @author Brad
 *
 */
public class SummaryController {
	
	private SummaryModel model;
	private SummaryView view;
	
	/**
	 * Constructor for the Summary Controller
	 * @param model the Summary model
	 * @param view the Summary view
	 */
	public SummaryController(SummaryModel model, SummaryView view) {
		this.model = model;
		this.view = view;

		view.setController(this);
		model.setController(this);
	}
	
	/**
	 * Lets the model know the user wishes to submit to the database
	 * @param subject the Record in question to submit
	 * @return whether the post was successful 
	 */
	public Boolean doPost(clients.Record subject) {
		Boolean response = SummaryModel.post(subject);
		if (response == true) {
			view.showBox(response, subject.getFName(), subject.getLName());						
		} else {
			view.showBox(response, Integer.toString(model.rc), model.rm);
		} return response;
		
	}

}
