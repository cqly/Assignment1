package SurveySimulator;

/**
 * The interface Question let the user get the specific details 
 * of a Question and also generate a random Vote for a student for
 * that Question.
 *
 */
public interface Question {
	
	public String [] possibleAnswers();
	
	public String getQuestionDetail();
	
	public Vote getNewRandomVote(Student s);
}
