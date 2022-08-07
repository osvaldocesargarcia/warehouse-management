# warehouse-management (case study)

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#problem-description">Problem Description</a></li>
        <li><a href="#application-requirements">Application requirements</a></li>
      </ul>
    </li>
    <li>
      <a href="#backend-solution">Backend Solution</a>
      <ul>
        <li><a href="#solution-for-spring-boot-api-and-spring-jpa">Solution for Spring Boot API and Spring JPA</a></li>
        
      </ul>
    </li>
   
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project
The present project is a case study to test my skills as a fullstack developer. It is a web application programmed with modern technologies: Angular and Spring Boot. Nowadays these frameworks are very popular in web programmation branch and the combination of both is very common. In the following section I provide details of the problem.

### Problem Description
MEDMOR SA, a company specialized in the sale and distribution of hardware products, wants to control and optimize its inventory processes. To do so, it needs to implement an API that allows it to manage all areas and products in the warehouse. The warehouse has sections. Each section has a size in square meters, the type of product destined to it, which can be Electrical Materials, Equipment, Locksmith, Tools and Plumbing. Each product has a size, color, price, if it is fragile, type of packaging (Cardboard, Plastic, Glass, Nylon) and lot. To operate the system, two main roles are defined: Administrator and Operator. The Administrator has access to the entire system, while the Operator will be restricted to delete sections.

### Application requirements
#### Spring Boot API
Implement an API in Spring Boot that allows to fulfill the following requirements: 
##### 1.1- Add a given quantity of a product to a section.
##### 1.2- Create/edit/delete a new section in a warehouse. Only sections that do not contain products can be deleted. 
##### 1.3- List product information, and perform filtering operation by: section, lot, fragility, color, price range, 
##### and type of packaging. 

#### Angular
Implement a visual interface that can be integrated with the previously implemented functionalities and that allows the following requirements to be met: 
##### 2.1- Allow the reuse of the most used code snippets in the templates. 
##### 2.2- Ensure the adaptation to different devices using Bootstrap 5.0 .
##### 2.3- Apply the necessary validations in the data entry. 
##### 2.4- Handle security aspects if necessary. 

#### Spring JPA
Develop an adequate relational database design that supports the above mentioned problems. In addition, the optimization of the requests must be guaranteed by relying on the ORM and complying with the following indications: 
##### 3.1- It must guarantee on-demand loading of entity dependencies unless for specific reasons a decision to the contrary is made. 
##### 3.2- Avoid the use of native queries. 
##### 3.3- Avoid obtaining unnecessary information by using data access object mapping techniques such as projections or DTOs. 

 ## Backend Solution
 
 ### Solution for Spring Boot API and Spring JPA
 I always support the idea that a good application must firstly have a really good database design before we start to work. It is for this reason that I will start by talking about the Spring JPA solution.
 
 #### Spring JPA Solution
 Three classes can be perceived in the presented problem: Section, Product and User. These 3 classes would form our tables in the database that would be obtained from the Spring JPA ORM. Below I attach fragments of the obtained classes.
##### Class Section
  ```
  	@Entity
@Table(name="section")
  public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="section_id")
	private int section_id;
	
	@Column(name="length")
	private double length;
	
	@Column(name="width")
	private double width;
	
	@JsonIgnore  
	@OneToMany(mappedBy="section_assigned") 
	private Set<Product> products_list;
	
	@Column(name = "product_type")
	@Enumerated(EnumType.STRING)
	private Product_Type product_type;
	

	public Section(double length, double width,   Product_Type product_type) {
		super();
		this.length = length;
		this.width = width;
		this.products_list = new HashSet<Product>();
		this.product_type = product_type;
	}
  ```

##### Class Product
  ```
	@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int product_id;
	
	@Column(name="length")
	private double length;
	
	@Column(name="width")
	private double width;
	
	@Column(name="color")
	private String color;
	
	@Column(name="price")
	private double price;
	
	@Column(name="is_fragile")
	private boolean is_fragile;
	
	@Column(name="lot")
	private int lot;
	
	@Column(name = "product_type")
	@Enumerated(EnumType.STRING)
	private Product_Type product_type;
	
	@Column(name = "container_type")
	@Enumerated(EnumType.STRING)
	private Container_Type container_type;
	
	@ManyToOne
    @JoinColumn(name="section_id", nullable=false)
	private Section section_assigned;
  ```
  
  ##### Class User
 ```
@Entity
@Table(name="user")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int user_id;

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="is_admin")
	private boolean is_admin;

	
	public User(String username, String password, boolean is_admin) {
		super();
		this.username = username;
		this.password = password;
		this.is_admin = is_admin;
	}
 ```
  
  
  #### Specifications
  To avoid the use of native queries I used Specifications instead. Below I attach a fragment of code where I use Specifications to find a product in a price range.
  
  ##### Class ProductServiceImpl
   ```
   	@Override
	public List<Product> getAllProductsByPriceInterval(double min, double max) {
	
	ProductSpecification spec1 = new ProductSpecification(new SearchCriteria("price", ">", min));
	ProductSpecification spec2 = new ProductSpecification(new SearchCriteria("price", "<", max));
	    
	List<Product> results = productRepository.findAll(Specification.where(spec1).and(spec2));
		
	return results;
	}
  ```
    
   #### Spring Boot API Solution
   
   1.1- Add a given quantity of a product to a section.
   
   ##### Answer
   To know if a product fits in a section, it is necessary to interact with both classes, so the service corresponding to the products must also interact with the section repository. So it would look like this in its constructor:
   
   ##### Class ProductServiceImpl
   ```
   	public ProductServiceImpl (ProductRepository productRepository, SectionRepository sectionRepository ) {
		
		this.productRepository = productRepository;
		this.sectionRepository = sectionRepository;
	}
   ```
   It was chosen to implement this functionality in the Products service because a product depends on a section and not vice versa, so that the modifications made in the product service would not affect the section service.
   
   So the main idea of the next two functions presented is to check at the beginning the capacity of the section, so we must find that element in the database. Then we use the list of products of that section to find out the capacity available and only if the new product's size fits it will be stored in the dabase.
   
   ##### Class ProductServiceImpl
   ```
   	@Override
	public Product saveProduct(Product product, int section_id) {
		
		SectionSpecification spec = new SectionSpecification(new SearchCriteria("section_id", ":", section_id));
	    List<Section> results = sectionRepository.findAll(spec);
		
	    product.setSection_assigned(results.get(0));
	    
		boolean no_availableCapacity = no_availableCapacity(product);
		
		if(no_availableCapacity) {
			
			System.out.println("No capacity left for any other product");
			return new Product();
		}
		else {
			return productRepository.save(product);
		}
	
	}

		public boolean no_availableCapacity(Product product) {
		
		boolean no_available = false;
		int section_id = product.getSection_assigned().getSection_id();
		
		ArrayList<Product> product_list = (ArrayList<Product>) getAllProductsBySection(section_id);
	
		double  max_capacity = product.getSection_assigned().getLength()*product.getSection_assigned().getWidth();
		double  occupied_capacity = product.getLength()*product.getWidth();
		
		for(int i = 0; i < product_list.size() && !no_available;i++) {
			occupied_capacity += product_list.get(i).getLength()*product_list.get(i).getWidth();
			
			if(occupied_capacity > max_capacity) {
				
				no_available = true;
			}
		}
		return no_available;	
	}
   ```
   
     1.2- Create/edit/delete a new section in a warehouse. Only sections that do not contain products can be deleted. 
   
   ##### Answer
    For the CRUDS functions I interacted with the REST Mapping of Spring Boot to satisfy the requests emitted from the frontend. The flow I followed to respond a request is shown in the next example related to a Create a Section function
    
   ##### SectionController
    ```
	@CrossOrigin
	@PostMapping("/section")
	public Section saveSection(@RequestBody Section section) {
		return	sectionService.saveSection(section);	
	}
    ```
    
   ##### SectionServiceImpl
    ```
    @Override
	public Section saveSection(Section section) {
		return sectionRepository.save(section);	
	}
    ```
  




