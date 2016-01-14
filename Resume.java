import java.util.ArrayList;


public class Resume{

	String _id;
	Long index;
	String guid;
	String name;
	String phone;
	String email;
	String objective;
	String expectedGraduationDate;
	String gpa;
	String school;
	ArrayList<Experience> experience;
	ArrayList<String> skills;
	ArrayList<String> tools;
	
	public Resume(){
		experience = new ArrayList<Experience>();
		skills = new ArrayList<String>();
		tools = new ArrayList<String>();
	}
}
