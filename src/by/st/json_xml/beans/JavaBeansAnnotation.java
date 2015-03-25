package by.st.json_xml.beans;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

public class JavaBeansAnnotation {

	@SerializedName("id")
	private int id;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("flag")
	private boolean flag;
	
	@SerializedName("mass")
	private byte[] mass;
		
	public JavaBeansAnnotation(int id, String name, boolean flag, byte[] mass) {
		super();
		this.id = id;
		this.name = name;
		this.flag = flag;
		this.mass = mass;
	}

	
	
	public JavaBeansAnnotation() {
		super();
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

	public byte[] getMass() {
		return mass;
	}

	public void setMass(byte[] mass) {
		this.mass = mass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (flag ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + Arrays.hashCode(mass);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JavaBeansAnnotation other = (JavaBeansAnnotation) obj;
		if (flag != other.flag)
			return false;
		if (id != other.id)
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
	public String toString() {
		return "JavaBeansAnnotation [id=" + id + ", name=" + name + ", flag="
				+ flag + ", mass=" + Arrays.toString(mass) + "]";
	}
	
	

}
