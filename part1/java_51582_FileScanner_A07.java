import java.io.*; // Import necessary classes for File I/O operations (FileNotFoundException)  
public class java_51582_FileScanner_A07 {    
    public static void main(String[] args){        
        try{            
            String filePath = "/path_to_file";// Insert your path here                
                     
            Scanner scanner= new Scanner(new FileInputStream(filePath));  // Initialize the scannable object for reading              
                      
		    while (scanner.hasNextLine()){                 
			   System.out.println("File content: " + scanner.next());             }           
                   	                        	} catch (Exception e) {                      println ("Error Occurred!");                 }}  // Catch and handle any exceptions that might occur