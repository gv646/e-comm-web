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
    private final OrderRepository orderRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository,
                                     ProductRepository productRepository,
                                     PriceRepository priceRepository,
                                     OrderRepository orderRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.orderRepository = orderRepository;
    }

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


//        Product product = new Product();
//        product.setTitle("iphone 15 pro");
//        product.setDescription("Best iphone ever");
//        product.setCategory(optionalCategory.get());
//
//        Product savedProduct = productRepository.save(product);

        //Find all products with category = Apple Devices
//        List<Product> products = category.getProducts();
//
//        for (Product product:products){
//            System.out.println(product.getTitle());
//            System.out.println(product.getPrice());
//            System.out.println(product.getCategory());
//        }

//        Price price = new Price();
//        price.setCurrency("INR");
//        price.setValue(100000);
//
//        Price savedPrice = priceRepository.save(price);
//
//        Category category = new Category();
//        category.setName("Apple Devices");
//        Category savedCategory = categoryRepository.save(category);
//
//        Product product = new Product();
//        product.setTitle("iphone 15 pro");
//        product.setDescription("Best iphone 15 ever");
//        product.setCategory(savedCategory);
//        product.setPrice(savedPrice);
//
//        productRepository.save(product);

        Optional<Price> optionalPrice = priceRepository.findById(UUID.fromString("d33a8953-9fff-4402-b70f-35a15cead38c"));

        if(optionalPrice.isEmpty()){
            throw new RuntimeException("Price not found");
        }

        Price price  = optionalPrice.get();
        priceRepository.deleteById(UUID.fromString("d33a8953-9fff-4402-b70f-35a15cead38c"));
    }
}
