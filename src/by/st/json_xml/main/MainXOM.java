package by.st.json_xml.main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import nu.xom.Document;
import by.st.json_xml.beans.JavaBeans1;
import by.st.json_xml.helper.HelperXOM;
import by.st.json_xml.helper.ObjectGenerator;



public class MainXOM {

	public static void main(String[] args) throws IOException {

		ArrayList<JavaBeans1> javaBeans1s = (ArrayList<JavaBeans1>) ObjectGenerator.getJavaBeans1Collection(2);
		
		Document document = HelperXOM.getXML(javaBeans1s);
		System.out.println(document.toXML());
		FileWriter fileGSON = new FileWriter("testXOM.xml");
		fileGSON.write(document.toXML());
		fileGSON.flush();
		fileGSON.close();
		

	}

}
