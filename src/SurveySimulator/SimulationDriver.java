package SurveySimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The SimulationDriver implements a voting/survey application where the students can vote
 * for specific questions. The number of students is generated randomly and the decision on
 * their votes are also random. Some questions are multiple choices, meaning they can pick
 * more than one right answer. Other questions are single choice, which means they can only
 * submit one answer. If there are multiple submissions from one student, only the last
 * submission counts.
 * 
 */
public class SimulationDriver {
	
	private static Random ran = new Random();
	private static List<Student> studentList;
	
	public static void main(String[] args) {

		//generate a random number from 100 to 200
		int randNumStudent = ran.nextInt(101) + 100;
		generateStudents(randNumStudent);
		
		Question question1 = new MultipleChoice(1000, "Test Mutiple choices question 1", new String[] {"a","b","c","d","e"});
		Question question2 = new MultipleChoice(1001, "Test Mutiple choice question 2", new String[] {"a","b","c"});
		
		Question question3 = new SingleChoice(1002, "Test Single choice question 1", new String[] {"a","b","c","d","e"});
		Question question4 = new SingleChoice(1003, "Test Single choice question 2", new String[] {"T","F"});

		Service s = new IVoteService(question1);
		startVoteProcess(s);				
		s.displayResult();
		
		s = new IVoteService(question2);
		startVoteProcess(s);				
		s.displayResult();
		
		s = new IVoteService(question3);
		startVoteProcess(s);				
		s.displayResult();
		
		s = new IVoteService(question4);
		startVoteProcess(s);				
		s.displayResult();
	}
	
	
	/**
	 * Generate a fixed amount of students and add them to the List
	 * 
	 * @param numStudents The amount of students
	 */
	private static void generateStudents(int numStudents) {
		
		studentList = new ArrayList<Student>();
					
		for (int i = 0; i < numStudents; i++) {
			studentList.add(new Student(i));
		}
		System.out.println("There are " + numStudents + " students in class.");
	}
	
	
	/**
	 * Create a random vote process for students
	 * 
	 * @param s The Service used to collect all the votes
	 */
	private static void startVoteProcess(Service s) {
		
		Vote v;
		
		//generate a random number from 0 to all the students 
		int numVotes = ran.nextInt(studentList.size() + 1);   
		
		for (int i = 0; i < numVotes; i++) {
			
			//pick a random student in the list and let him vote
			v = s.getQuestion().getNewRandomVote(studentList.get(ran.nextInt(studentList.size())));
			
			//add all the votes to the IVoteService
			s.addVote(v);
		}
	}
}