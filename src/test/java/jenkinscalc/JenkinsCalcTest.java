package jenkinscalc;

import static org.junit.Assert.*;

import org.junit.Test;

public class JenkinsCalcTest {


	
	  @Test 
	  public void testAddTwoNumbers() {
		  JenkinsCalc jenkinsCalc = new JenkinsCalc(); 
		  assertEquals(10, jenkinsCalc.addTwoNumbers(5, 5));
	 }
	  
	 @Test 
	 public void testSubtractTwoNumbers() { 
		 JenkinsCalc jenkinsCalc = new JenkinsCalc(); 
		 assertEquals(10, jenkinsCalc.subtractTwoNumbers(15, 5)); 
	 }
		  
		 

}
