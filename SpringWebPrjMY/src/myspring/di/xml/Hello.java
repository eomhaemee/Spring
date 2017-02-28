package myspring.di.xml;

import java.util.List;
import java.util.Map;

public class Hello {
	String name;
	Printer printer;
	List<String> names;
	
	public Hello() {
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

	public Hello(String name, Printer printer) {
		this.name = name;
		this.printer = printer;
	}


	public List<String> getNames() {
		return this.names;
	}

	Map<String,Integer> ages;
	
	public void setAges(Map<String, Integer> ages) {
		this.ages = ages;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}
}

//
//
// }
