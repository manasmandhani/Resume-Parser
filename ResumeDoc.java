import java.io.FileReader;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mongodb.client.*;


public class ResumeDoc {

	ArrayList<Resume> resume_list; 
	
	public ResumeDoc(){
		resume_list = new ArrayList<Resume>();
	}

	public void createResumeInMongo(){
		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo("localhost", 27017);
		@SuppressWarnings("deprecation")
		DB db = mongo.getDB("ResumeDoc");
		DBCollection collection = db.getCollection("resumes");
		for (Resume r : resume_list) {
			BasicDBObject db_doc = new BasicDBObject();
			db_doc.put("_id", r._id);
			db_doc.put("index", r.index);
			db_doc.put("guid", r.guid);
			db_doc.put("name", r.name);
			db_doc.put("phone", r.phone);
			db_doc.put("email", r.email);
			db_doc.put("objective", r.objective);
			db_doc.put("expectedGradutaionDate", r.expectedGraduationDate);
			db_doc.put("gpa", r.gpa);
			db_doc.put("school", r.school);
			
			if(r.tools != null && !r.tools.isEmpty()){
				db_doc.put("tools", r.tools);
			}else{
				db_doc.put("tools", null);
			}
			
			if(r.skills != null && !r.skills.isEmpty()){
				db_doc.put("skills", r.skills);
			}else{
				db_doc.put("skills", null);
			}
			
			BasicDBObject temp = new BasicDBObject();
			
			if(r.experience != null && !r.experience.isEmpty()){
				for(int i = 0; i < r.experience.size(); i++){
					BasicDBObject inner_temp = new BasicDBObject();
					Experience exp = r.experience.get(i);
					
					inner_temp.put("id", exp.id);
					inner_temp.put("name", exp.name);
					inner_temp.put("years", exp.years);
					inner_temp.put("language", exp.language);
					
					if(r.experience.size() == 1){
						temp.put("experience", inner_temp);
					}else{
						temp.put("experience-"+i, inner_temp);
					}
				}
				db_doc.put("experience", temp);
			}else{
				db_doc.put("experience", null);
			}
			collection.insert(db_doc);
		}
	}
	

	
	public void parseResume() throws IOException, ParseException{
		
		FileReader file = new FileReader("resumes.txt");
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(file);
		
		for (int i = 0; i < array.size(); i++){
			Resume resume = new Resume();
			
			JSONObject obj = (JSONObject) array.get(i);
			JSONArray experience_array = (JSONArray) obj.get("experience");
			JSONArray skills_array = (JSONArray) obj.get("skills");
			JSONArray tools_array = (JSONArray) obj.get("tools");
			
			resume._id = (String) obj.get("_id");
			resume.index = (Long) obj.get("index");
			resume.guid = (String) obj.get("guid");
			resume.name = (String) obj.get("name");
			resume.phone = (String) obj.get("phone");
			resume.email = (String) obj.get("email");
			resume.objective = (String) obj.get("objective");
			resume.expectedGraduationDate = (String) obj.get("expectedGraduationDate");
			resume.gpa = (String) obj.get("gpa").toString();
			resume.school = (String) obj.get("school");
		
			for(int j = 0; j < experience_array.size(); j++){
				
				Experience exp = new Experience();
				JSONObject exp_object = (JSONObject) experience_array.get(j);
				
				exp.id = (Long) exp_object.get("id");
				exp.language = (String) exp_object.get("language");
				exp.name = (String) exp_object.get("name");
				exp.years = (Long) exp_object.get("years");
				
				resume.experience.add(exp);
			}
			
			for(int j = 0; j < skills_array.size(); j++){
				resume.skills.add((String) skills_array.get(j));
			}
			
			for(int j = 0; j < tools_array.size(); j++){
				resume.tools.add((String) tools_array.get(j));
			}
			resume_list.add(resume);
		}
	}
	
	
	public static void main(String[] args) throws IOException, ParseException {

		ResumeDoc rdoc = new ResumeDoc();

		rdoc.parseResume();
		rdoc.createResumeInMongo();
	//	rdoc.createQuery1("JAVA");
		
		ArrayList<String> objective = new ArrayList<String>();
		objective.add("internship");
		objective.add("co-op");
		ArrayList<String> school = new ArrayList<String>();
		school.add("Rochester Institute of Technology");
		school.add( "University of Texas - Dallas");
		ArrayList<String> tools = new ArrayList<String>();
		tools.add("BlueJ");
		tools.add("Weka");
		tools.add("Android Studio");
		tools.add( "Rattle");
		
		//rdoc.createQuery5((long)2);
		
	}
}
