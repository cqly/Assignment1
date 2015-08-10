package SurveySimulator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IVoteService implements Service {
	
	private Question question;
	private Set<Vote> voteSet;
	
	public IVoteService(Question question) {
		this.question = question;
		this.voteSet = new HashSet();
	}
	
	public void addAnswers(Vote studentVote) {
		if (voteSet.contains(studentVote))
			voteSet.remove(studentVote);
		
		voteSet.add(studentVote);
	}
		
	
	
}
