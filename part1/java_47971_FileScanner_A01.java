import java.io.*; // Import necessary classes here; these should not conflict with any other imports from the system library or external frameworks like Spring/Hibernate if you follow best practices in your code
  
public class java_47971_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{ 
        File file = new File("C:\\Users\\Your_UserName\\Documents", "yourFile.txt"); // Assuming the user has access to this location; replace with actual path if not, or add a check for its existence (file exists and accessible).        
            BufferedReader reader =  null; 
        try {          
              String line ;  
                FileInputStream fis = new FileInputStream( file );     // Assuming the user has access to this location. Replace with actual path if not, or add a check for its existence (file exists and accessible).                 
            int available ;      
             reader=new BufferedReader(new InputStreamReader(fis)); 
              while((line = reader.readLine()) != null){        // Using read line until EOF is reached        
                   System.out.println("Content of the file : "+"\n");          // Printing out each content in terminal       }   
             if (reader !=  null) {                            // Close resources here, don't forget; a finally block can be used to ensure all resource handling is done properly     reader.close();}  else{System.out.println("Error closing file");}}   catch(Exception e){ System.err.println ("Failed or interrupted I/O operation" +e); }}