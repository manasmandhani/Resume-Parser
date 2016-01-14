import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class Queries {
	
	public static ArrayList<String> createQuery1(String skill){

		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo("localhost", 27017);
		
		@SuppressWarnings("deprecation")
		DB db = mongo.getDB("ResumeDoc");
		BasicDBObject obj = new BasicDBObject();
		DBCollection collection = db.getCollection("resumes");
		
		if (!skill.equals(""))
			obj.put("skills", skill);
		
		DBCursor cursor = collection.find(obj);
		ArrayList<String> resume_list = new ArrayList<String>();
		
		BasicDBObject resume = null;
		while (cursor.hasNext()) {
			resume = (BasicDBObject) cursor.next();
			resume_list.add((String) resume.toString());
		}
		return resume_list;
	}
	
	public static ArrayList<String> createQuery2(String intern){

		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo("localhost", 27017);
		
		@SuppressWarnings("deprecation")
		DB db = mongo.getDB("ResumeDoc");
		BasicDBObject obj = new BasicDBObject();
		DBCollection collection = db.getCollection("resumes");
		
		if (!intern.equals(""))
			obj.put("objective", intern);
		
		DBCursor cursor = collection.find(obj);
		ArrayList<String> resume_list = new ArrayList<String>();
		
		BasicDBObject resume = null;
		
		while (cursor.hasNext()) {
			resume = (BasicDBObject) cursor.next();
			resume_list.add((String) resume.toString());
		}
		return resume_list;
	}
	
	public static ArrayList<String> createQuery3(String skill1, String skill2){

		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo("localhost", 27017);
		
		@SuppressWarnings("deprecation")
		DB db = mongo.getDB("ResumeDoc");
		DBCollection collection = db.getCollection("resumes");
		
		BasicDBObject[] array = {new BasicDBObject("skills", skill1 ), new BasicDBObject("skills", skill2)};
		BasicDBObject obj = new BasicDBObject("$and", array);
		
		DBCursor cursor = collection.find(obj);
		ArrayList<String> resume_list = new ArrayList<String>();
		
		BasicDBObject resume = null;
		
		while (cursor.hasNext()) {
			resume = (BasicDBObject) cursor.next();
			resume_list.add((String) resume.toString());
		}
		return resume_list;
	}
	
	public static ArrayList<String> createQuery5(Long exp){

	@SuppressWarnings("deprecation")
	Mongo mongo = new Mongo("localhost", 27017);
	
	@SuppressWarnings("deprecation")
	DB db = mongo.getDB("ResumeDoc");
	DBCollection collection = db.getCollection("resumes");
	
	BasicDBObject experience0 = new BasicDBObject("experience.experience-0.years", new BasicDBObject("$gte",exp));
	BasicDBObject experience1 = new BasicDBObject("experience.experience-1.years", new BasicDBObject("$gte",exp));
	BasicDBObject experience2 = new BasicDBObject("experience.experience-2.years", new BasicDBObject("$gte",exp));
	BasicDBObject experience3= 	new BasicDBObject("experience.experience-3.years", new BasicDBObject("$gte",exp));

	BasicDBObject[] array = {experience0 , experience1 , experience2 , experience3  };
	BasicDBObject obj = new BasicDBObject("$or", array);
	
	DBCursor cursor = collection.find(obj);
	ArrayList<String> resume_list = new ArrayList<String>();
	
	BasicDBObject resume = null;
	
	while (cursor.hasNext()) {
		resume = (BasicDBObject) cursor.next();
		resume_list.add((String) resume.toString());
	}
	return resume_list;
}

public static ArrayList<String> createQuery6(Long exp, String language){

	@SuppressWarnings("deprecation")
	Mongo mongo = new Mongo("localhost", 27017);
	
	@SuppressWarnings("deprecation")
	DB db = mongo.getDB("ResumeDoc");
	DBCollection collection = db.getCollection("resumes");

	BasicDBObject year_experience0 = new BasicDBObject("experience.experience-0.years", new BasicDBObject("$gte",exp));
	BasicDBObject year_experience1 = new BasicDBObject("experience.experience-1.years", new BasicDBObject("$gte",exp));
	BasicDBObject year_experience2 = new BasicDBObject("experience.experience-2.years", new BasicDBObject("$gte",exp));
	BasicDBObject year_experience3 = new BasicDBObject("experience.experience-3.years", new BasicDBObject("$gte",exp));

	BasicDBObject language_experience0 = new BasicDBObject("experience.experience-0.language", language);
	BasicDBObject language_experience1 = new BasicDBObject("experience.experience-1.language", language);
	BasicDBObject language_experience2 = new BasicDBObject("experience.experience-2.language", language);
	BasicDBObject language_experience3 = new BasicDBObject("experience.experience-3.language", language);

	BasicDBObject[] array1 = {year_experience0 , year_experience1 , year_experience2 , year_experience3  };

	BasicDBObject[] array2 = {language_experience0 , language_experience1 , language_experience2 , language_experience3  };
	BasicDBObject obj1 = new BasicDBObject("$or", array1);
	BasicDBObject obj2 = new BasicDBObject("$or", array2);
	BasicDBObject[] array3 = {obj1, obj2};
	BasicDBObject obj3 = new BasicDBObject("$and", array3);
	DBCursor cursor = collection.find(obj3);
	ArrayList<String> resume_list = new ArrayList<String>();
	
	BasicDBObject resume = null;
	
	while (cursor.hasNext()) {
		resume = (BasicDBObject) cursor.next();
		resume_list.add((String) resume.toString());
	}
	return resume_list;
}

public static ArrayList<String> createQuery7(){

	@SuppressWarnings("deprecation")
	Mongo mongo = new Mongo("localhost", 27017);
	
	@SuppressWarnings("deprecation")
	DB db = mongo.getDB("ResumeDoc");
	DBCollection collection = db.getCollection("resumes");
	String exp = "GEEKULAR";
	BasicDBObject experience0 = new BasicDBObject("experience.experience-0.name", exp);
	BasicDBObject experience1 = new BasicDBObject("experience.experience-1.name", exp);
	BasicDBObject experience2 = new BasicDBObject("experience.experience-2.name", exp);
	BasicDBObject experience3= new BasicDBObject("experience.experience-3.name", exp);

	BasicDBObject[] array = {experience0 , experience1 , experience2 , experience3  };
	BasicDBObject obj = new BasicDBObject("$or", array);
	
	DBCursor cursor = collection.find(obj);
	ArrayList<String> resume_list = new ArrayList<String>();
	
	BasicDBObject resume = null;
	
	while (cursor.hasNext()) {
		resume = (BasicDBObject) cursor.next();
		resume_list.add((String) resume.toString());
	}
	return resume_list;
}
	
//	public void createQuery4(String expectedDate, ArrayList<String> objective, ArrayList<String> school, ArrayList<String> tools){
//
//	@SuppressWarnings("deprecation")
//	Mongo mongo = new Mongo("localhost", 27017);
//	
//	@SuppressWarnings("deprecation")
//	DB db = mongo.getDB("ResumeDoc");
//	DBCollection collection = db.getCollection("resumes");
//	
//	BasicDBObject[] arrayObjective = new BasicDBObject[objective.size()];
//	for(int i=0;i<objective.size(); i++){
//		arrayObjective[i]=new BasicDBObject("objective",objective.get(i));
//	}
//	BasicDBObject objectiveObj = new BasicDBObject("$in",arrayObjective);
//	BasicDBObject[] arraySchool = new BasicDBObject[school.size()];
//	for(int i=0;i<school.size(); i++){
//		arraySchool[i]=new BasicDBObject("school",school.get(i));
//	}
//	BasicDBObject schoolObj = new BasicDBObject("$in", school);
//	BasicDBObject[] arrayTools = new BasicDBObject[tools.size()];
//	for(int i=0;i<tools.size(); i++){
//		arrayTools[i]=new BasicDBObject("tools",tools.get(i));
//	}
//	BasicDBObject toolsObj = new BasicDBObject("$in", arrayTools);
//	BasicDBObject expecedGraduationDate= new BasicDBObject("expectedGraduationDate", expectedDate);
//
//	BasicDBObject[] array = {objectiveObj, schoolObj, toolsObj, expecedGraduationDate };
//	BasicDBObject obj = new BasicDBObject("$and", array);
//	
//	DBCursor cursor = collection.find(obj);
//	ArrayList<String> resume_list = new ArrayList<String>();
//	
//	BasicDBObject resume = null;
//	
//	while (cursor.hasNext()) {
//		resume = (BasicDBObject) cursor.next();
//		resume_list.add((String) resume.toString());
//		System.out.println(resume);
//	}
//}
//	
}

	








