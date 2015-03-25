package by.st.json_xml.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import by.st.json_xml.beans.JavaBeans1;
import by.st.json_xml.beans.JavaBeans2;

public final class ObjectGenerator {

	public static List<JavaBeans1> getJavaBeans1Collection(int amountObjects) {
		List<JavaBeans1> javaBeansCollection = new ArrayList<JavaBeans1>();
		for (int i = 0; i < amountObjects; i++) {
			javaBeansCollection.add(getJavaBeans1());
		}
		return javaBeansCollection;
	}

	private static JavaBeans1 getJavaBeans1() {
		Random random = new Random();
		byte[] mass = new byte[15];
		random.nextBytes(mass);
		JavaBeans1 javaBeans1 = new JavaBeans1(Math.abs(random.nextInt()),
				"Name", random.nextBoolean(), getJavaBeans2(), mass);
		return javaBeans1;
	}

	private static JavaBeans2 getJavaBeans2() {
		Random random = new Random();
		JavaBeans2 javaBeans2 = new JavaBeans2(Math.abs(random.nextInt()),
				"Name");
		return javaBeans2;
	}
}
