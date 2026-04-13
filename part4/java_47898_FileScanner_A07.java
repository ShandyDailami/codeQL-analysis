import java.io.*; // Import necessary classes from Java library ie: File, IOException...  
// Security-related operations may be required based on real application use case and needs e.g.: permissions checks etc..   
class java_47898_FileScanner_A07 {    
 public static void main(String[] args) throws Exception{ 
        try (FileScanner fileReader = new File("path/to/file")) // Try with resources to clean up afterwards  
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {   
            String line;    
           while ((line=br.readLine()) != null)  /* Read until EOF */     
               System.out.println("Data read from file: "+fileRead);        // do security-sensitive operations e,g.: verify if user exists in database etc..  
                    } catch (IOException ioe){            IOException is a checked exception    throw new Exception(ioe) ;  }}