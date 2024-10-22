Integrating Swagger API Documentation in Spring Boot


What is Swagger?

Swagger is a popular framework for API documentation.


1. Setting Up a Spring Boot Project
===================================

          Spring Web as a dependency

2. Adding Springdoc OpenAPI Dependency
===================================



	<dependency>
		<groupId>org.springdoc</groupId>
		<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
		<version>2.0.4</version>
	</dependency>



3. add properties in properties file.
===================================


springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.enabled=true



4. create config file 
===================================


@Configuration
public class SpringFoxConfig {

	@Bean
	public OpenAPI registrationOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Rest API For Employee ").description("Employee Crud Operation").version("1.0"));
	}
}

5. create rest controller 
===================================

@RestController
public class EmployeeRestController {
	private EmployeeServiceImpl employeeServiceImpl;

	public EmployeeRestController(EmployeeServiceImpl employeeServiceImpl) {
		super();
		this.employeeServiceImpl = employeeServiceImpl;
	}

	@PostMapping(value = "/save", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		try {
			Employee saveEmployee = employeeServiceImpl.saveEmployee(employee);

			return new ResponseEntity<>("Save Employee Successfully...", HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>("Something went wrong...!", HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping(value = "/list")
	public ResponseEntity<List<Employee>> getListOfEmployee() {
		List<Employee> employees = employeeServiceImpl.getEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		Employee employee = employeeServiceImpl.getEmployee(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
}

6. access swagger ui 
===================================

http://localhost:8080/swagger-ui/index.html
==================================================================================================================================================================================================================

![Swagger Demo](https://github.com/user-attachments/assets/8afa33cd-6ead-4f83-84b7-3abd4f5172e8)

![db](https://github.com/user-attachments/assets/b3a982e8-57d4-4a77-8299-2d77ab81d6f6)

![6](https://github.com/user-attachments/assets/7bb61cf1-dca1-47ed-9f66-157de032d12d)

![5](https://github.com/user-attachments/assets/23e6f1f4-3c80-4490-8b7e-3c8c96f051a8)

![4](https://github.com/user-attachments/assets/312d6ca0-c868-4cb6-91fb-9092e2093087)

![3](https://github.com/user-attachments/assets/081ba708-06b3-4063-a26d-8430ce82e8ab)

![2](https://github.com/user-attachments/assets/2f22b28e-f944-447e-a3d7-90a784fbef21)




