package by.st.json_xml.main;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import by.st.json_xml.beans.JavaBeans1;
import by.st.json_xml.helper.HelperJSON;
import by.st.json_xml.helper.ObjectGenerator;

public class Main {

	public static void main(String[] args) throws Exception {

		
	
		Scanner in = new Scanner(System.in);
		
		System.out.println("Hello. Please, select a Read or Write?");
		String choose = in.next();
		switch (choose) {
		case "w":
			
			
			System.out.println("Enter the number of objects:");
			int amountObjects = in.nextInt();
			List<JavaBeans1> list = ObjectGenerator.getJavaBeans1Collection(amountObjects);

			long beganXML = System.currentTimeMillis();
			FileOutputStream outXML = new FileOutputStream("my_java_bean.xml");
			XMLEncoder xmlEncoder = new XMLEncoder(outXML);
			xmlEncoder.writeObject(list);
			xmlEncoder.flush();
			xmlEncoder.close();
			long endXML = System.currentTimeMillis();
			long resultXML = endXML - beganXML;
			System.out.println("XML: "+resultXML);

			
			
			long beganJSON = System.currentTimeMillis();
			JSONArray array1 = HelperJSON.generationGson(list);
			System.out.println(array1.toJSONString());
			FileWriter file = new FileWriter("test.json");
			file.write(array1.toJSONString());
			file.flush();
			file.close();
			long endJSON = System.currentTimeMillis();
			long resultJSON = endJSON - beganJSON;
			System.out.println("JSON: "+resultJSON);
			
			
			
//			JSONArray arrayGSON = HelperJSON.generationGson(list);
			long beganGSON = System.currentTimeMillis();
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			String jsonStringGson = gson.toJson(list);
			FileWriter fileGSON = new FileWriter("testGSON.json");
			fileGSON.write(jsonStringGson);
			fileGSON.flush();
			fileGSON.close();
			
			long endGSON = System.currentTimeMillis();
			long resultGSON = endGSON - beganGSON;
			System.out.println("GSON: "+resultGSON);
			
			break;
		case "r":

			long beganParseXML = System.currentTimeMillis();
			FileInputStream inXML = new FileInputStream("my_java_bean.xml");
			XMLDecoder xmlDecoder = new XMLDecoder(inXML);
			List<JavaBeans1> listXML = (List<JavaBeans1>) xmlDecoder.readObject();
			xmlDecoder.close();
			long endParseXML = System.currentTimeMillis();
			long resultParseXML = endParseXML - beganParseXML;
			
			for (int i = 0; i < listXML.size(); i++) {
				System.out.println(listXML.get(i).toString());
			}
			System.out
					.println("____________________________________________________");
			BufferedReader fin = new BufferedReader(new InputStreamReader(
					new FileInputStream("test.json")));
			
			StringBuilder stringJSON = new StringBuilder();
			stringJSON.append("[");
			
			while (fin.read() != -1) {
				stringJSON.append(fin.readLine());
			}
			fin.close();

			long beganParseJSON = System.currentTimeMillis();
			List<JavaBeans1> listJavaBeansDecoder = HelperJSON.generationCollectionJavaBeans1(stringJSON.toString());
			long endParseJSON = System.currentTimeMillis();
			for (int j = 0; j < listJavaBeansDecoder.size(); j++) {
				System.out.println(listJavaBeansDecoder.get(j).toString());
			}
			long resultParseJSON = endParseJSON - beganParseJSON;
			
			
			
			
			BufferedReader finGSON = new BufferedReader(new InputStreamReader(
					new FileInputStream("testGSON.json")));
			
			StringBuilder stringGSON = new StringBuilder();
			stringGSON.append("[");
			while (finGSON.read() != -1) {
				stringGSON.append(finGSON.readLine());
			}
			finGSON.close();
			
			long beganDeGSON = System.currentTimeMillis();
			GsonBuilder builder2 = new GsonBuilder();
			Gson gson2 = builder2.create();
			ArrayList<JavaBeans1> listGSON = gson2.fromJson(stringGSON.toString(), ArrayList.class);
			long endDeGSON = System.currentTimeMillis();
			long resultDeGSON = endDeGSON - beganDeGSON;
			
			for (int i = 0; i < listGSON.size(); i++) {
				System.out.println(listGSON.get(i));
			}
			
			System.out.println("XML: "+resultParseXML);
			System.out.println("JSON: "+resultParseJSON);
			System.out.println("GSON: "+resultDeGSON);
			
			
			break;
		default:
			System.out.println("The wrong choice");
			break;
		}

	}

}