package by.st.json_xml.main;

import java.util.ArrayList;

import by.st.json_xml.beans.JavaBeans1;
import by.st.json_xml.helper.ObjectGenerator;
import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Text;

public class MainTest {

	public static void main(String[] args) {
		
		
		
		ArrayList<JavaBeans1> javaBeans1s = (ArrayList<JavaBeans1>) ObjectGenerator.getJavaBeans1Collection(2);
		
		
		
		Document document = null;
		Element list = new Element("list");
		for (int i = 0; i < javaBeans1s.size(); i++) {
			Element object = new Element("object");
			list.appendChild(object);
			Attribute attributeClass = new Attribute("class", javaBeans1s.get(i).getClass().toString().substring(6));
			object.addAttribute(attributeClass);
			
			Element id = new Element("id");
			object.appendChild(id);
			Text textId = new Text(String.valueOf(javaBeans1s.get(i).getId())); 
			id.appendChild(textId);
			
			Element name = new Element("name");
			object.appendChild(name);
			Text textName = new Text(javaBeans1s.get(i).getName()); 
			name.appendChild(textName);
			
			Element flag = new Element("flag");
			object.appendChild(flag);
			Text textFlag = new Text(String.valueOf(javaBeans1s.get(i).isFlag())); 
			flag.appendChild(textFlag);
			
			Element javaBeans2 = new Element("javaBeans2");
			object.appendChild(javaBeans2);
			
			Element object2 = new Element("object2");
			javaBeans2.appendChild(object2);
			Attribute attributeClass2 = new Attribute("class", javaBeans1s.get(i).getJavaObject().getClass().toString().substring(6));
			object2.addAttribute(attributeClass2);
			
			Element id2 = new Element("id");
			object2.appendChild(id2);
			Text textId2 = new Text(String.valueOf(javaBeans1s.get(i).getJavaObject().getId())); 
			id2.appendChild(textId2);
			
			Element name2 = new Element("name");
			object2.appendChild(name2);
			Text textName2 = new Text(javaBeans1s.get(i).getJavaObject().getName()); 
			name2.appendChild(textName2);
			
			Element mass = new Element("mass");
			object.appendChild(mass);
			Attribute attributeMass = new Attribute("length", String.valueOf(javaBeans1s.get(i).getMass().length));
			mass.addAttribute(attributeMass);
			int k=-1;
				for (int j = 0; j < javaBeans1s.get(i).getMass().length; j++) {
						k++;
						Element void1 = new Element("void");
						mass.appendChild(void1);
						Attribute attributeIndex = new Attribute("index", String.valueOf(k) );
						void1.addAttribute(attributeIndex);
						
						Text textValue = new Text(String.valueOf(String.valueOf(javaBeans1s.get(i).getMass()[j])));
						void1.appendChild(textValue);
						
				}
			
	}
		document = new Document(list);
		System.out.println(document.toXML());

}
}