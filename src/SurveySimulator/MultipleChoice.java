package SurveySimulator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * The class MultipleChoice represents a question where the student can
 * pick more than one correct answers
 */
public class MultipleChoice implements Question {
	
	private int id;
	private String description;
	private String[] choices;
	
	public MultipleChoice(int id, String description, String[] choices) {
		this.id = id;
		this.description = description;
		this.choices = choices;
	}
		
	public int getId() {
		return id;
	}
	
	public String toString() {
		return "\n[Multiple Choices]\n - Question: " + description;
	}
	
	@Override
	public String getQuestionDetail() {
		return description;
	}		

	@Override
	public String[] possibleAnswers() {
		return choices;
	}
	
	/* 
	 * Create a Vote randomly for the Student s
	 */
	@Override
	public Vote getNewRandomVote(Student s) {
		
		Random ran = new Random();	
		
		Set<String> answer = new HashSet<String>();
		
		int numChoices = ran.nextInt(choices.length) + 1;  //select at least one answer
		
		//randomly add answer(s) to the answer list
		for (int i = 0; i < numChoices; i++) {
			answer.add(choices[ran.nextInt(choices.length)]);
		}				
				
		return new Vote(this, s, answer);
	}
}