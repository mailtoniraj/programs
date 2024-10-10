package practice.stream.com.learnJava.methodreferences;



import practice.stream.com.learnJava.data.Student;

import java.util.function.Supplier;

public class SupplierMethodReferenceExample {

    Supplier<Student> studentSupplier = Student::new;

    public static void main(String[] args) {

        System.out.println();

    }
}
