import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.component.CarPart;
import com.lti.component.CarPartsInventory;


public class CarPartsTest {
   
	private static ApplicationContext context;
	
	public static void main(String[] args) {
	context = new ClassPathXmlApplicationContext("spring-config.xml");
	
	CarPartsInventory  carPart=(CarPartsInventory) context.getBean("carPartsImpl1");
	CarPart c = new CarPart();
	 c.setPartNo(145);   
     c.setPartName("Bolts"); 
     c.setCarModel("Mercedes"); 
     c.setQuantity(4);
     carPart.addNewPart(c);
	
	}
}
