package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestMap {
	//print names which have last letter as "a" with upper case
  @Test
  public void streamMap() 
  {
	  Stream.of("Saga","Shweta","Shefali","Jhanvi").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	  
	  //print names with first letter as S with upper case and sorted
	  //using array first convert it to array list
	  List<String>names=Arrays.asList("Sagar","Shweta","Pari","Swapnil");
	  names.stream().filter(s->s.startsWith("S")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	  
	  //merge two list
	  ArrayList<String>name2=new ArrayList<String>();
	  name2.add("Snehal");
	  name2.add("Vaibhavi");
	  name2.add("Ashwini");
	  name2.add("Anuja");
	  
	  Stream<String>newStream=Stream.concat(names.stream(), name2.stream());
	//  newStream.sorted().forEach(s->System.out.println(s));
	  
	  //check whether sagar name is present in the list
	  boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Sagar"));
	  System.out.println(flag);
	  Assert.assertTrue(flag);
  }
  @Test
  public void streamCollect() 
  {
	  //collect method is used to convert the manipulated stream back to list or set and map
	  List<String> li=Stream.of("Saga","Shweta","Shefali","Jhanvi").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
	  .collect(Collectors.toList());
	  System.out.println(li.get(1));
	  
	  //print unique numbers from array in sorted order
	  List<Integer>values=Arrays.asList(2,4,6,3,1,5,2,3,2);
	 // values.stream().distinct().forEach(s->System.out.println(s));
	
	 //print the 3rd element  
	  List<Integer>list=values.stream().distinct().sorted().collect(Collectors.toList());
	  System.out.println(list.get(2));
  }
  


}
