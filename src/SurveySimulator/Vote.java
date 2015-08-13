package SurveySimulator;

import java.util.Set;

/**
 * The class Vote represent a vote by student. Its private fields contain
 * the Student object, Question object, and a set of answers for that Question.
 * It also implements the Comparable class to compare the student's ID of two
 * votes to see if they are from the same student.
 *
 */
public class Vote implements Comparable<Vote> {

	private Student student;
	private Question question;
	Set<String> answer;
	
	public Vote(Question question, Student student, Set<String> answer) {
		this.student = student;
		this.question = question;
		this.answer = answer;
	}
	
	public Student getStudent() {
		return this.student;
	}
	
	public Question getQuestion() {
		return this.question;
	}
	
	public Set<String> getAnswer() {
		return this.answer;
	}
	
	public boolean equals(Object obj) {
		
		Vote other = (Vote) obj;
		return this.student.getId() == other.getStudent().getId();
	}
	
	public String toString() {
		return "ID " + student.getId() + ": " + answer.toString();
	}

	@Override
	public int compareTo(Vote vote) {
		
		return student.getId() - vote.getStudent().getId();
	}
}
