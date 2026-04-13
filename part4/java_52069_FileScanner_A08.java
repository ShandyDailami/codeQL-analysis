import java.io.*;  // Import required classes from 'package'.  
public class java_52069_FileScanner_A08 {   
     public static void main(String args[]) throws IOException{     
          File file = new File("filepath");      
           if (file.exists())        
              try (FileReader fr = new FileReader(file))            // Open the reader to read from a character-input stream using default settings  
                  {            
                     int data;                // Declare variable for reading input characters 
                      while ((data=fr.read()) !=  -1)               // Reads one char at a time until end of file is reached   
                         System.out.print((char) data);             // Print the read character to console  	        		      			      }                 catch (Exception e){e.getStackTrace();}}          else  {System.err.println("File doesn't exist or no permission for reading");}             }}