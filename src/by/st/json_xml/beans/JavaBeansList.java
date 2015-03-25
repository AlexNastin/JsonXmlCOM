package by.st.json_xml.beans;

import java.util.ArrayList;
import java.util.List;

public class JavaBeansList {

	private List<JavaBeans2> list = new ArrayList<JavaBeans2>();

	public JavaBeansList(List<JavaBeans2> list) {
		super();
		this.list = list;
	}
	
	public JavaBeansList() {
		super();
		
	}

	public List<JavaBeans2> getList() {
		return list;
	}

	public void setList(List<JavaBeans2> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "JavaBeansList [list=" + list + "]";
	}

}
