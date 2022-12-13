package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.AfterMethod;

public class StreamTest {
	//Print the count of names start with letter S
	
  @Test
  public void streamfliter() 
  {
	  ArrayList<String>names=new ArrayList<String>();
	  names.add("Shweta");
	  names.add("Shefali");
	  names.add("Sagar");
	  names.add("Pari");
	  
	  long a=names.stream().filter(s->s.startsWith("S")).count();
	  System.out.println(a);
	  
	  //we can directly create stream of name
	  long d=Stream.of("Sagar","Snehal","Sakshi","Jhanvi","Shweta").filter(s->
	  {
		  s.startsWith("S");
		  return true;
	  }).count();
	  
	  System.out.println(d);
	  
	  //print the names of array list whose length is greater than 4
	  names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
	  
	  //print the name length greater than 4 and return only first result
	  names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
  }
  


}
