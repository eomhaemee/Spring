package myspring.di.annot;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloA")
public class Hello {
	@Value("${name}")
	String name;
	/*@Autowired
	@Qualifier("stringPrinterA")*/
	@Resource(name="${printer}")
	Printer printer;
	List<String> names;
	
	//constructor injection	
	public Hello() {
		System.out.println("default constructor called..");
	}

	public Hello(String name, Printer printer) {
		this.name = name;
		this.printer = printer;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}
	public List<String> getNames() {
		return this.names;
	}

	Map<String,Integer> ages;
	
	public void setAges(Map<String, Integer> ages) {
		this.ages = ages;
	}
//Setter Injection
/*	public void setName(String name) {
		this.name = name;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}*/
	
	public Printer getPrinter() {
		return printer;
	}
	
	public String sayHello() {
		return "Hello " + name;
	}
//method Injection
	public void print() {
		this.printer.print(sayHello());
	}
}

//
//
// }
