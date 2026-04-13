import java.io.*;   // Import the necessary classes from Java framework (FileInputStream, OutputStream)   
                
public class java_47799_FileScanner_A01 {    
 public static void main(String[] args){       
       try{          
            File file = new File("inputfile");      // Create a 'new' instance of your input-type in path  
             if(!file.exists() ) throw  new NoSuchFileException();          /// If the object doesn’t exist, then create one   	        		      	   	     	       	 					     }                  catch (NoSuchElementType n) {                    // Catch an instance of 'exception'               			  
                            System . out. println (" File does not exists.");                     try 	{               /// Try block to make the file inaccessible             				   	        		       	   	       	 					     }                  catch (Exception e){                   // General Exception handling           throws                    exception          throw new             IOException();      }}