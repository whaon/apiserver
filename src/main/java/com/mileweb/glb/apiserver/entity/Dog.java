package com.mileweb.glb.apiserver.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(value="age")
//@JsonAutoDetect(setterVisibility=Visibility.ANY)
public class Dog {

	//@JsonIgnore
	//@JsonProperty(value="myname")
	//@JsonIgnore
	@NotNull(message="not allow null")
	String name;
	int age;
	@JsonFormat(pattern="yyyy-MM-dd")// 这个是jackson管，转成json或者xml时有效
	@DateTimeFormat(pattern="yyyy-MM")// 这个不归jackson管，直接注入entity会用到
	@Past(message="pastError")
	Date birth; 

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	//@JsonIgnore
	public String getName() {
		return name;
	}
	
	/*@JsonProperty("output_name")// 这种用在输入，输出的名称和pojo属性的名称都不一样的情况
	public String getJavaName() {
		return name; 
	}*/

	@JsonProperty("input_name")
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", birth=" + birth + "]";
	}
}

