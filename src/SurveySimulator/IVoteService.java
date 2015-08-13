package SurveySimulator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is the main simulator for the voting system. It keeps track of all the
 * votes to a specific Question and has functionality to calculate some statistic and
 * display the results.
 *
 */
public class IVoteService implements Service {
	
	private Question question;
	private List<Vote> voteList;
	private int totalVotes = 0;
	
	/**
	 * the map is used to keep track of the answers count where the key is the answer
	 * and the value is how many times that answer is chosen. 
	 */
	private Map<String,Integer> answersCount = new HashMap<String,Integer>();
	
	
	public IVoteService(Question question) {
		this.question = question;
		this.voteList = new ArrayList<Vote>();
		for (String s : question.possibleAnswers()) {
			answersCount.put(s, 0);
		}
	}
	
	private double getPercent(int value) {
		if (totalVotes == 0) 
			return 0;
		else
			return value * 100.0 / totalVotes;
	}
	
	@Override
	public Question getQuestion() {
		return question;
	}
	
	@Override
	public List<Vote> getResult() {
		return voteList;
	}
	
	@Override
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
	
	

	/** 
	 * Add a Vote to the list of Vote in the service. If there are previous Vote from
	 * the same Student, remove that Vote and all its statistic before adding a new Vote
	 */
	@Override
	public void addVote(Vote studentVote) {
		
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
