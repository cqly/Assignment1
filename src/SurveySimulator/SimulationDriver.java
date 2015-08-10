package SurveySimulator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class SimulationDriver {

	public static void main(String[] args) {

		List<Student> studentList = new ArrayList();
		List<Vote> voteList = new ArrayList();
		Random ran = new Random();
		
		Question question1 = new MultipleChoice(123, "description", new String[] {"1","2"});
		
		
		int numStudents = ran.nextInt(100) + 100;
		
		for (int i = 0; i < numStudents; i++) {
			studentList.add(new Student(i));
			
		}
		
		System.out.println(ran.nextInt(2));
		//studentList.get(0).newVote(question1);
		
		
		int numVotes = ran.nextInt(numStudents);
		int randomStudent;
		
		for (int i = 0; i < numVotes; i++) {
			
			studentList.get(ran.nextInt(numStudents));
			
		}
			
		
		Service s = new IVoteService(question1);
		
		
		
		
		
		
		
		
	}

}
