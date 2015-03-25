package by.st.json_xml.beans;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

public final class JavaBeans1 {

	@SerializedName("id")
	private int id;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("flag")
	private boolean flag;
	
	@SerializedName("javaObject")
	private JavaBeans2 javaObject;
	
	@SerializedName("mass")
	private byte[] mass;
	
	public JavaBeans1(int id, String name, boolean flag, JavaBeans2 javaObject,
			byte[] mass) {
		super();
		this.id = id;
		this.name = name;
		this.flag = flag;
		this.javaObject = javaObject;
		this.mass = mass;
	}

	public JavaBeans1() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public JavaBeans2 getJavaObject() {
		return javaObject;
	}

	public void setJavaObject(JavaBeans2 javaObject) {
		this.javaObject = javaObject;
	}

	public byte[] getMass() {
		return mass;
	}

	public void setMass(byte[] mass) {
		this.mass = mass;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JavaBeans1 other = (JavaBeans1) obj;
		if (flag != other.flag)
			return false;
		if (id != other.id)
			return false;
		if (javaObject == null) {
			if (other.javaObject != null)
				return false;
		} else if (!javaObject.equals(other.javaObject))
			return false;
		if (!Arrays.equals(mass, other.mass))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (flag ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result
				+ ((javaObject == null) ? 0 : javaObject.hashCode());
		result = prime * result + Arrays.hashCode(mass);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "JavaBeans1 [id=" + id + ", name=" + name + ", flag=" + flag
				+ ", javaObject=" + javaObject + ", mass="
				+ Arrays.toString(mass) + "]";
	}
	
}
