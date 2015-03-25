package by.st.json_xml.helper;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import by.st.json_xml.beans.JavaBeans1;
import by.st.json_xml.beans.JavaBeans2;

public final class HelperJSON {

	final static String ID = "id";
	final static String NAME = "Name";
	final static String FLAG = "flag";
	final static String JAVA_OBJECT = "javaObject";
	final static String MASS = "mass";
	
	public static JSONArray generationGson(List<JavaBeans1> list) {

		JSONArray listJSON = new JSONArray();

		for (int i = 0; i < list.size(); i++) {
			JSONObject objectJavaBeans1 = new JSONObject();
			JSONObject objectJavaBeans2 = new JSONObject();
			JSONArray massJSON = new JSONArray();
			
			objectJavaBeans1.put(ID, list.get(i).getId());
			objectJavaBeans1.put(NAME, list.get(i).getName());
			objectJavaBeans1.put(FLAG, list.get(i).isFlag());
			
			objectJavaBeans2.put(ID, list.get(i).getJavaObject().getId());
			objectJavaBeans2.put(NAME, list.get(i).getJavaObject().getName());
			objectJavaBeans1.put(JAVA_OBJECT, objectJavaBeans2);

			for (int j = 0; j < list.get(i).getMass().length; j++) {
				massJSON.add(list.get(i).getMass()[j]);
			}
			objectJavaBeans1.put(MASS, massJSON);
			listJSON.add(objectJavaBeans1);
		}
		return listJSON;
	}

	public static List<JavaBeans1> generationCollectionJavaBeans1(
			String stringJSON) throws ParseException {
		List<JavaBeans1> listJavaBeans = new ArrayList<JavaBeans1>();
		
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray = (JSONArray) jsonParser.parse(stringJSON);

		for (int i = 0; i < jsonArray.size(); i++) {
			JavaBeans1 javaBeans1 = new JavaBeans1();
			JavaBeans2 javaBeans2 = new JavaBeans2();
			JSONObject jsonObject = (JSONObject) jsonArray.get(i);

			Object idJavaBeans1 = (Object) jsonObject.get(ID);
			Integer idStringJavaBeans1 = Integer.valueOf(idJavaBeans1
					.toString());
			javaBeans1.setId(idStringJavaBeans1);
			javaBeans1.setName((String) jsonObject.get(NAME));
			javaBeans1.setFlag((boolean) jsonObject.get(FLAG));

			JSONObject jsonObject2 = (JSONObject) jsonObject.get(JAVA_OBJECT);
			Object idJavaBeans2 = (Object) jsonObject.get(ID);
			Integer idStringJavaBeans2 = Integer.valueOf(idJavaBeans2
					.toString());

			javaBeans2.setId(idStringJavaBeans2);
			javaBeans2.setName((String) jsonObject2.get(NAME));

			javaBeans1.setJavaObject(javaBeans2);

			byte[] mass = new byte[15];

			JSONArray jsonArrayMass = (JSONArray) jsonObject.get(MASS);
			for (int l = 0; l < jsonArrayMass.size(); l++) {
				String value = jsonArrayMass.get(l).toString();
				Byte valueByte = Byte.valueOf(value);
				mass[l] = valueByte;

			}
			javaBeans1.setMass(mass);
			
			listJavaBeans.add(javaBeans1);
			
		}

		return listJavaBeans;
	}
}
