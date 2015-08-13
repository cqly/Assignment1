package SurveySimulator;

import java.util.List;

/**
 * The interface Service let the user get specific information
 * such as result and question detail. It also has functions to 
 * add Vote and display the end result.
 *
 */
public interface Service {
	
	public void addVote(Vote v);
	public Question getQuestion();
	public List<Vote> getResult();
	public void displayResult();
}
