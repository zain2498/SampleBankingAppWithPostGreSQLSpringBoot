using record class as DTO

Java Record class is a special kind of class that helps you encapsulate the related data without the need for boiler code
Using Record class as  DTO in spring boot project is a modern and efficient approach to encapsulate the data between the application layers
Records are best fit for DTOs because they are concise, immutable and automatically provide the implementation details of getter , setter and allargs constructor, equals, hashCode() and toString() function which are essentials for DTO


how can we add the Lombok dependency to our project:

go to mvnRepository and search for Lombok:
https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.38

then paste it in the pom.xml file
		<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.38</version>
			<scope>provided</scope>
		</dependency>


		once added then in plugins :
		add this version inside lombok :<version>1.18.38</version>

	once done then go to project --> settings --> Build, Extensions and Deployment --> compiler --->  Annotation Processor --> check this Enable Annotation Processing

	then you are good to go to use the LOMBOK annotation in your project

	//-------------------------------------THANK YOU -----------------------------------------//