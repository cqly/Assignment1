package SurveySimulator;

import java.util.List;

public interface Service {
	
	public void addAnswer(Vote v);
	public Question getQuestion();
	public List<Vote> getResult();
	public void displayResult();
}
