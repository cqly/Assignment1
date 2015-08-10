package SurveySimulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SimulationDriver {

	public static void main(String[] args) {

		List<Student> studentList = new ArrayList();
		List<Vote> voteList = new ArrayList();
		Random ran = new Random();
		
		Question question1 = new MultipleChoice(123, "description", new String[] {"a","b","c"});
		
		
		//int numStudents = ran.nextInt(20) + 10;
		int numStudents = 20;
		
		for (int i = 0; i < numStudents; i++) {
			studentList.add(new Student(i));
			
		}	

		Service s = new IVoteService(question1);
		
		
		//int numVotes = ran.nextInt(numStudents + 1);  //0 to all the students actually vote
		int numVotes = 15;
		
		for (int i = 0; i < numVotes; i++) {		
			s.addAnswer(studentList.get(ran.nextInt(numStudents)).newRandomVote(question1));
			
		}
			
		
		
		List<Vote> voteList2 = s.getResult();
		
		System.out.println(numStudents);
		System.out.println("size: " + voteList2.size());
		

		for (Vote v : voteList2)
			System.out.println(v);
		
		s.displayResult();
		
	}
	
	

}
