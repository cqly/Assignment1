package SurveySimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student {
	
	private int id;
	
	
	public Student(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public Vote newRandomVote(Question question) {
		

		
		Random ran = new Random();		
		List<String> answer = new ArrayList<String>();			
		String [] choices = question.possibleAnswers();
		
		
		if (question instanceof MultipleChoice) {
			int numChoices = ran.nextInt(choices.length) + 1;
			//randomly add answer(s) to the answer list
			for (int i = 0; i < numChoices; i++) {
				answer.add(choices[ran.nextInt(numChoices)]);
			}
		}
		else if (question instanceof SingleChoice) {
			answer.add(choices[ran.nextInt(choices.length)]);
		}
								
		Vote v = new Vote(question, this, answer);
		
		return v;
		
	}
	
	
}