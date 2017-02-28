package ehmspring.di.xml;

import java.util.List;
import java.util.Map;

public class Hello {
	String name;
	Printer printer;
	List<String> names;
	Map<String,Integer> ages;
	
	public Hello() {
		System.out.println("default constructor called..");
	}
	
	public Hello(String name, Printer printer) {	
		this.name = name;
		this.printer = printer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public Map<String, Integer> getAges() {
		return ages;
	}

	public void setAges(Map<String, Integer> ages) {
		this.ages = ages;
	}
	public String sayHello() {
		return "Hello " + name;
	}	
//method Injection
	public void print() {
		this.printer.print(sayHello());
	}
	
	
}
