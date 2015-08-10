package SurveySimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationDriver {
	
	private static Random ran = new Random();
	private static List<Student> studentList;
	
	public static void main(String[] args) {

		
		int randNumStudent = ran.nextInt(101) + 100;
		generateStudents(randNumStudent);
		
		Question question1 = new MultipleChoice(123, "description", new String[] {"a","b","c"});
		Question question2 = new SingleChoice(123, "single", new String[] {"a","b","c"});
		Question question3 = new SingleChoice(123, "single", new String[] {"a","b","c"});
		Question question4 = new SingleChoice(123, "single", new String[] {"a","b","c"});

		Service s = new IVoteService(question2);
		
		startVoteProcess(s);
				
		s.displayResult();
	}
	
	private static void generateStudents(int numStudents) {
		
		studentList = new ArrayList<Student>();
					
		for (int i = 0; i < numStudents; i++) {
			studentList.add(new Student(i));
		}
		
		System.out.println("There are " + numStudents + " students in class.\n");
	}
	
	private static void startVoteProcess(Service s) {
		
		Vote v;
		int numVotes = ran.nextInt(studentList.size() + 1);  //0 to all the students actually vote
		
		for (int i = 0; i < numVotes; i++) {
			v = studentList.get(ran.nextInt(studentList.size())).newRandomVote(s.getQuestion());
			s.addAnswer(v);
			
		}
	}
	
}
