import java.sql.*;
import java.util.Scanner;   // For taking inputs using scanner class (in real world scenario, these should be injected through DI container)

public class java_52701_JDBCQueryHandler_A07 {
    public static void main(String[] args){ 
        Scanner in = new Scanner(System.in);    
         System.out.println("Enter username:");   //taking user name input from the scanner object 'in' for real world application, this should be injected through DI container or by taking inputs using constructor arguments as per your requirement 
        String username = in.next();   
         
       System.out.println("\n Enter password : ");    
         //taking user input from the scanner object 'in' for real world application, this should be injected through DI container or by taking inputs using constructor arguments as per your requirement 
        String password = in.next();   
         
       if(validateUserLogin(username ,password)) {  
            System.out.println("Logged In Successfully!");     //real world application, this should display success message upon successful login to the user through DI container or by print statements 
        } else{     
            	System.out.println("\n Failed Login! Please try again.");   	// real word app., This will be used for failed attempt in case of wrong username/password pair from a GUI, it should show that message on screen  
      	}    			          		               //Please note this is just pseudo code to give you an idea about how authentication system works and not production ready.  It's only meant as example concept or if user input data handling method were different in real world scenario then inputs would be taken from DI Container/Input methods, etc...
    }    		               //Please note this is just pseudo code to give you an idea about how authentication system works and not production ready.  It's only meant as example concept or if user input data handling method were different in real world scenario then inputs would be taken from DI Container/Input methods, etc...
}    		               //Please note this is just pseudo code to give you an idea about how authentication system works and not production ready.  It's only meant as example concept or if user input data handling method were different in real world scenario then inputs would be taken from DI Container/Input methods, etc...