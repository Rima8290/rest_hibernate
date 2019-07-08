import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.lti.training.Employee;
import com.lti.training.EmployeeDetails;

public class EmployeeTest {

	@Test
	public void add() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		EmployeeDetails d= (EmployeeDetails)context.getBean("empDetails");
		
		//entity class object we don't create using spring
		Employee e = new Employee();
		e.setId(3);
		e.setName("Syed");
		e.setDesignation("Trainee");
		e.setSalary(27000);
		d.addDetails(e);
		
		
	}
	
	@Test
	public void getDetails() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		EmployeeDetails d= (EmployeeDetails)context.getBean("empDetails");
        
		
		//CarPart carp=new CarPart();
		List<Employee> list = d.getDetails();
		for(Employee e : list) {
			System.out.println("The Id of the employee is : "+ e.getId());
			System.out.println("The name of the employee is : " + e.getName());
			System.out.println("The designation of the employee is : " + e.getDesignation());
			System.out.println("The salary of the employee is : " + e.getSalary());

}
	}
}
