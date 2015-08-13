package SurveySimulator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * The class SingleChoice represents a question where the student can
 * only pick one answer.
 *
 */
public class SingleChoice implements Question {

	private int id;
	private String description;
	private String[] choices;
	
	public SingleChoice(int id, String description, String[] choices) {
		this.id = id;
		this.description = description;
		this.choices = choices;
	}
		
	public int getId() {
		return id;
	}
	
	public String toString() {
		return "\n[Single Choice] Question: " + description;
	}
	
	@Override
	public String getQuestionDetail() {
		return description;
	}		

	@Override
	public String[] possibleAnswers() {
		return choices;
	}
	
	@Override
	public Vote getNewRandomVote(Student s) {
		
		Random ran = new Random();	
		
		//Create a HashSet and add an answer to the set 
		Set<String> answer = new HashSet<String>();
		answer.add(choices[ran.nextInt(choices.length)]);
		
		//Instantiate a new Vote object
		Vote v = new Vote(this, s, answer);
		
		return v;
	}
}