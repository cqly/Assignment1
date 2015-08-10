package SurveySimulator;

import java.util.List;

public class Vote {

	private Student student;
	private Question question;
	List<String> answer;
	
	public Vote(Question question, Student student, List<String> answer) {
		this.student = student;
		this.question = question;
		this.answer = answer;
		
	}
	
	public Student getStudent() {
		return this.student;
	}
	
	public boolean equals(Object obj) {
		
		Vote other = (Vote) obj;
		return this.student.getId() == other.getStudent().getId();
		
	}
}
