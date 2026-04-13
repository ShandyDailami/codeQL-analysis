import java.util.*;   // Import necessary Java Libraries 
import java.io.*;      // For File and Scanner classes   
    
public class java_43284_FileScanner_A01 {                     
       public static void main(String[] args) throws Exception{       
            String filePath = "path_to/yourfile";          /* Replace with your desired path */             
        	Scanner scanFile =  new Scanner(new File(filePath));    // Creating a 'scan' object for the given Path  
             while (scanFile.hasNext()){          				// Reading and printing each line of file until end 		     	 					       	   				     }           	       	               	      scanFile.close();                     	}               });              catch(Exception e) { System . out . println ("An error has occurred" +e); }}