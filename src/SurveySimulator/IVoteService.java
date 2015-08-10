package SurveySimulator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class IVoteService implements Service {
	
	private Question question;
	private List<Vote> voteList;
	private Map<String,Integer> answersCount = new HashMap<String,Integer>();
	
	public IVoteService(Question question) {
		this.question = question;
		this.voteList = new ArrayList<Vote>();
		for (String s : question.possibleAnswers()) {
			answersCount.put(s, 0);
		}
		
	}
	
	public List<Vote> getResult() {
		return voteList;
	}
	
	public void displayResult() {
		System.out.println(question.getQuestionDetail());
		System.out.println("There are: " + voteList.size() + " votes.");
		
		for (String key : answersCount.keySet()) {
			System.out.println(key + " = " + answersCount.get(key));
		}
	}

	@Override
	public void addAnswer(Vote studentVote) {
		
		if (voteList.contains(studentVote)) {			
			
			
			for (String answer : voteList.get(voteList.indexOf(studentVote)).getAnswer()) {
				int currentCount = answersCount.get(answer);
				answersCount.put(answer, currentCount - 1);
			}
			voteList.remove(studentVote);
		}
			
		
		voteList.add(studentVote);
		
		for (String answer : studentVote.getAnswer()) {
			int currentCount = answersCount.get(answer);
			answersCount.put(answer, currentCount + 1);
		}
		
		
	}
	
}
