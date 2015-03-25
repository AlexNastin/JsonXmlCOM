package by.st.json_xml.beans;

import com.google.gson.annotations.SerializedName;

public final class JavaBeans2 {
	@SerializedName("id")
	private int id;
	@SerializedName("name")
	private String name;

	public JavaBeans2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public JavaBeans2() {
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JavaBeans2 other = (JavaBeans2) obj;
		if (id != other.id)
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
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "JavaBeans2 [id=" + id + ", name=" + name + "]";
	}
	
	
}
