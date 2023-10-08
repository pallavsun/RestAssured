package Day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	
	
	@Test
	void testgenerateDummyData()
	{
		
		Faker faker=new Faker();
		String fullName=faker.name().fullName();
		String firstName=faker.name().firstName();
		String lastName=faker.name().lastName();
		
		String userName=faker.name().username();
		String password=faker.internet().password();
		String phoneNumber=faker.phoneNumber().cellPhone();
		String emailAddress=faker.internet().safeEmailAddress();
		
		System.out.println("FullName "+fullName);
		System.out.println("FirstName "+firstName);
		System.out.println("LastName  "+lastName);
		System.out.println("UserName  "+userName);
		System.out.println("Password  "+password);
		System.out.println("PhoneNumber "+phoneNumber);
		System.out.println("EmailAddress "+emailAddress);
		
	}

}
