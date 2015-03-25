package by.st.json_xml.main;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import by.st.json_xml.beans.JavaBeans2;
import by.st.json_xml.beans.JavaBeansAnnotation;
import by.st.json_xml.beans.JavaBeansList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.internal.StringMap;

public class MainAnnotation {

	public static void main(String[] args) {

		JavaBeans2 beans2 =  new JavaBeans2(1, "ads");
		JavaBeans2 beans21 =  new JavaBeans2(2, "fds");
		
		ArrayList<JavaBeans2> objects = new ArrayList<JavaBeans2>();
		objects.add(beans2);
		objects.add(beans21);

		JavaBeansList jList = new JavaBeansList(objects);

		
		
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();

		// JavaBeansAnnotation javaBeansAnnotation = new JavaBeansAnnotation(10,
		// "Alex", true, mass);

		// JSONArray array = new JSONArray();
		//
		// array.add(javaBeansAnnotation);
		// array.add(javaBeansAnnotation);
		// array.add(javaBeansAnnotation);
		//

		String json = gson.toJson(jList);
		 System.out.println(json);

		// List<JavaBeansAnnotation> list = new
		// ArrayList<JavaBeansAnnotation>();
		// list.add(javaBeansAnnotation);
		// list.add(javaBeansAnnotation);

		// json = gson.toJson(list);
		// System.out.println(json);
		
		JavaBeansList javaBeansList = gson.fromJson(json, JavaBeansList.class);
		
		
		ArrayList<JavaBeans2> arrayList = (ArrayList<JavaBeans2>) javaBeansList.getList();
		
		System.out.println(arrayList.get(0).getClass());
		
		for (int i = 0; i < arrayList.size(); i++) {
			JavaBeans2 beans22 = arrayList.get(i);
			System.out.println(beans22.getId());
		}
		
		// System.out.println(arrayGSON);

//		for (int i = 0; i < arrayGSON.size(); i++) {

//			System.out.println(arrayGSON.get(i));

			// System.out.println(stringMap);
			// JSONObject jsonObject= stringMap.get("id");

			// javaBeansAnnotation2Annotation.setId(Integer.valueOf(jsonObject.toString()));

			// System.out.println(javaBeansAnnotation2Annotation);
		}

		// System.out.println(.equals(array2));

	}

//}
