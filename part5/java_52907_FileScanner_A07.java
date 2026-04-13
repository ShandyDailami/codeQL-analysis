import java.io.*; // Importing the necessary classes to handle files & directories
import java.util.*; // For List class, Iterator interface and various utilities like sort etc..  
    
public class java_52907_FileScanner_A07 {   
        
        public static void main(String[] args) throws Exception  {         
            File dir = new File("src/main/resources");          
            	File file1=new File(dir, "user_file.txt") ;      // Create an instance of the UserInfo class  		    
        	    try (Scanner scanUserName =  new Scanner(file1)) {   	// Use 'with resource' statement to auto close scanners when done with them 			         	           	     					       	       				            	  }           catch (FileNotFoundException e)             	{                    System.out.println("user_file not found");                  }}  
        	    String userName=scanUserName.next();      // Read the username from file   		     Scanner scanPassword =  new Scanner(System.in);      			         	           	     					       	       				            	  try {String password = scanPassword.nextLine() ;comparePasswords(userName,password) } catch (NoSuchElementException e){ System.out.println("Error reading from input stream"); }}   
        	    public static void comparePasswords(String userInputtedUserName , String UserEnteredPassword ) {  // Compare the passwords  		     if(!Objects.equals((userDBpasswd), (plainTextPW)))     			         	           	     					       	       				            	  } throw new Exception("Invalid Password");}}