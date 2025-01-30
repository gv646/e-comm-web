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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private MentorRepository mentorRepository;
    private StudentRepository studentRepository;
    private UserRepository userRepository;

   ProductServiceApplication(@Qualifier("st_mentorrepository") MentorRepository mentorRepository,
                             @Qualifier("st_studentrepository") StudentRepository studentRepository,
                             @Qualifier("st_userrepository") UserRepository userRepository){
       this.mentorRepository = mentorRepository;
       this.studentRepository = studentRepository;
       this.userRepository = userRepository;
   }

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

        User user = new User();
        user.setName("Arshi");
        user.setEmail("arshi@gmail.com");
        userRepository.save(user);

        Mentor mentor = new Mentor();
        mentor.setName("Deepak");
        mentor.setEmail("deepak@gmail.com");
        mentor.setAvgRating(4.7);
        mentorRepository.save(mentor);

        Student student = new Student();
        student.setName("harsh");
        student.setEmail("harsh@gmail.com");
        student.setPsp(99.0);
        studentRepository.save(student);

    }
}
