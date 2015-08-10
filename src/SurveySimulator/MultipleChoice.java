package SurveySimulator;


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
	
	public String getQuestionDetail() {
		return description;
	}
		

	@Override
	public String[] possibleAnswers() {
		return choices;
	}



}
