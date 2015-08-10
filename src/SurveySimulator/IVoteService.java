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
	private int totalVotes = 0;
	
	public IVoteService(Question question) {
		this.question = question;
		this.voteList = new ArrayList<Vote>();
		for (String s : question.possibleAnswers()) {
			answersCount.put(s, 0);
		}
	}
	
	public Question getQuestion() {
		return question;
	}
	
	public List<Vote> getResult() {
		return voteList;
	}
	
	public void displayResult() {
		
		System.out.println(question);		
		System.out.println(" - " + voteList.size() + " student(s) participated.");
		System.out.println(" - Result:\n");
		
		for (String key : answersCount.keySet()) {
			System.out.print("   " + key + " = " + answersCount.get(key) + "\t(");
			System.out.println(String.format("%.1f", getPercent(answersCount.get(key))) + "%)");
		}
		
		System.out.println("\n - Votes (Only the last submission from each ID is shown):\n");
		
		for (Vote v : voteList)
			System.out.println("   " + v);
	}
	
	private double getPercent(int value) {
		if (totalVotes == 0) 
			return 0;
		else
			return value * 100.0 / totalVotes;
	}

	@Override
	public void addAnswer(Vote studentVote) {
		
		//If the student has already voted, remove his old vote
		if (voteList.contains(studentVote)) {			
						
			for (String answer : voteList.get(voteList.indexOf(studentVote)).getAnswer()) {
				answersCount.put(answer, answersCount.get(answer) - 1);
				totalVotes--;
			}
			
			voteList.remove(studentVote);
		}
			
		
		voteList.add(studentVote);
		
		for (String answer : studentVote.getAnswer()) {
			answersCount.put(answer, answersCount.get(answer) + 1);
			totalVotes++;
		}
	}
}
