package SurveySimulator;

import java.util.List;
import java.util.TreeSet;

public interface Service {
	
	public void addAnswer(Vote v);
	public Question getQuestion();
	public List<Vote> getResult();
	public void displayResult();
}
