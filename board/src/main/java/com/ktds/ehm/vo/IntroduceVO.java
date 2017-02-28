package com.ktds.ehm.vo;

public class IntroduceVO {
	private String name;
	private String addr;
	private String hobby;
	private int age;
	
	public String getName() {
		System.out.println("getname()호출");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
