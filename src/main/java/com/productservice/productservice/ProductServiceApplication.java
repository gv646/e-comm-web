package com.productservice.productservice;

//import com.productservice.productservice.inheritancerelations.mappedsuperclass.Mentor;
//import com.productservice.productservice.inheritancerelations.mappedsuperclass.MentorRepository;
import com.productservice.productservice.inheritancerelations.singletable.Mentor;
import com.productservice.productservice.inheritancerelations.singletable.MentorRepository;
import com.productservice.productservice.inheritancerelations.singletable.Student;
import com.productservice.productservice.inheritancerelations.singletable.StudentRepository;
import com.productservice.productservice.inheritancerelations.singletable.User;
import com.productservice.productservice.inheritancerelations.singletable.UserRepository;
import com.productservice.productservice.inheritancerelations.tableperclass.*;
import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Order;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.OrderRepository;
import com.productservice.productservice.repositories.PriceRepository;
import com.productservice.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository,
                                     ProductRepository productRepository, PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }


//    private final CategoryRepository categoryRepository;
//    private final ProductRepository productRepository;
//    private final PriceRepository priceRepository;
//    private final OrderRepository orderRepository;
//
//    public ProductServiceApplication(CategoryRepository categoryRepository,
//                                     ProductRepository productRepository,
//                                     PriceRepository priceRepository,
//                                     OrderRepository orderRepository) {
//        this.categoryRepository = categoryRepository;
//        this.productRepository = productRepository;
//        this.priceRepository = priceRepository;
//        this.orderRepository = orderRepository;
//    }

//
//    private MentorRepository mentorRepository;
//    private StudentRepository studentRepository;
//    private UserRepository userRepository;
//
//   ProductServiceApplication(@Qualifier("st_mentorrepository") MentorRepository mentorRepository,
//                             @Qualifier("st_studentrepository") StudentRepository studentRepository,
//                             @Qualifier("st_userrepository") UserRepository userRepository){
//       this.mentorRepository = mentorRepository;
//       this.studentRepository = studentRepository;
//       this.userRepository = userRepository;
//   }

//    private MentorRepository mentorRepository;
//    private StudentRepository studentRepository;
//    private UserRepository userRepository;
//
//    ProductServiceApplication (@Qualifier("tpc_mentorrepository")
//                               MentorRepository mentorRepository,
//                               @Qualifier("tpc_studentrepository")
//    StudentRepository studentRepository, UserRepository userRepository) {
//        this.mentorRepository = mentorRepository;
//        this.studentRepository = studentRepository;
//        this.userRepository = userRepository;
//    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
//    @Transactional
    public void run(String... args) throws Exception {
//        Mentor mentor  = new Mentor();
//        mentor.setName("Deepak");
//        mentor.setEmail("deepak.kasera@gmail.com");
//        mentor.setAvgRating(4.7);
//        mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("Abhishek");
//        student.setEmail("abhishek@gmail.com");
//        student.setPsp(90.0);
//        studentRepository.save(student);
//
//        User user = new User();
//        user.setName("Arshi");
//        user.setEmail("arshi@gmail.com");
//        userRepository.save(user);
//
//
//        List<User> users = userRepository.findAll();
//        for (User user1 : users) {
//            System.out.println(user1.toString());
//        }

//        User user = new User();
//        user.setName("Arshi");
//        user.setEmail("arshi@gmail.com");
//        userRepository.save(user);
//
//        Mentor mentor = new Mentor();
//        mentor.setName("Deepak");
//        mentor.setEmail("deepak@gmail.com");
//        mentor.setAvgRating(4.7);
//        mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("harsh");
//        student.setEmail("harsh@gmail.com");
//        student.setPsp(99.0);
//        studentRepository.save(student);

//        Category category = new Category();
//        category.setName("Apple Devices");
//
//        Category savedCategory = categoryRepository.save(category);

//        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("9a670ce5-7f78-4643-9ed7-36740c32cb9e"));
//        if (optionalCategory.isEmpty()) {
//            throw new Exception("Category not found");
//        }
//
//        Category category = optionalCategory.get();


//        Product product1 = new Product();
//        product1.setTitle("iphone 15 pro");
//        product1.setDescription("Best iphone ever");
//        product1.setCategory(optionalCategory.get());
//
//        Product savedProduct = productRepository.save(product1);

        //Find all products with category = Apple Devices
//        List<Product> products = category.getProducts();
//
//        for (Product product1:products){
//            System.out.println(product1.getTitle());
//            System.out.println(product1.getPrice());
//            System.out.println(product1.getCategory());
//        }
//
//        Price price = new Price();
//        price.setCurrency("INR");
//        price.setValue(100000);
//
////        Price savedPrice = priceRepository.save(price);
//
//        Category category = new Category();
//        category.setName("Apple Devices");
//        Category savedCategory = categoryRepository.save(category);
//
//        Product product1 = new Product();
//        product1.setTitle("iphone 15 pro");
//        product1.setDescription("Best iphone 15 ever");
//        product1.setCategory(savedCategory);
//        product1.setPrice(price);
//
//        Product savedProduct = productRepository.save(product1);
//        productRepository.deleteById(UUID.fromString("90f0cfd7-bf82-401b-993e-31722f88789a"));

//        Category category = new Category();
//        category.setName("Apple Device");
//
//        Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price();
//        price.setCurrency("INR");
//        price.setValue(100000);


//        Optional<Price> optionalPrice = priceRepository.findById(UUID.fromString("cd321c82-3019-4604-a103-0441f1756160"));
//
//        if(optionalPrice.isEmpty()){
//            throw new Exception("Price object is NULL");
//        }
//
//        Price price = optionalPrice.get();
//
//        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("80167972-f143-446c-832e-33dddb727ac9"));
//        Category category = optionalCategory.get();



//        Product product1 = new Product();
//        product1.setCategory(category);
//        product1.setTitle("iphone 15 pro max");
//        product1.setDescription("Best iphone ever");
//        product1.setImage("IMG");
//        product1.setPrice(price);
//
//        Product savedProduct = productRepository.save(product1);
//
//        Price price1 = new Price();
//        price1.setCurrency("INR");
//        price1.setValue(200000);
//
//        Product product2 = new Product();
//        product2.setCategory(category);
//        product2.setTitle("iphone 15 pro max");
//        product2.setDescription("Best iphone ever");
//        product2.setImage("IMG");
//        product2.setPrice(price1);
//
//        Product savedProduct1 = productRepository.save(product2);
//
//        Price price2 = new Price();
//        price2.setCurrency("INR");
//        price2.setValue(300000);
//
//        Product product3 = new Product();
//        product3.setCategory(category);
//        product3.setTitle("iphone 15 pro max");
//        product3.setDescription("Best iphone ever");
//        product3.setImage("IMG");
//        product3.setPrice(price2);
//
//        Product savedProduct2 = productRepository.save(product3);

        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("d397177b-3fc6-4827-96c5-0dfdfab999d5"));
        Category category = optionalCategory.get();

        List<Product> products = category.getProducts();

        for (Product product : products) {
            System.out.println(product.getTitle());
            System.out.println(product.getPrice().getValue());
            System.out.println(product.getCategory().getName());
        }

    }
}

