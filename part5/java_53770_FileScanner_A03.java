import java.io.*; // Import necessary classes 
public class java_53770_FileScanner_A03 {  
    public static void main(String[] args) throws Exception{     
        FileScanner scan = new FileScanner();          
         try (BufferedReader br = 
                  new BufferedReader(new FileReader("samplefile.txt"))){ // Try-with resources for cleanup 
            String line;  
               while ((line=br.readLine()) != null) {   
                   System.out.println("\nFound Line: "+scan.sanitizeStringForInjectionAttack(line));     
                }    
        } catch (Exception e){  // Catch any IOException related exceptions  
            throw new Exception("Failed to read file.",e);   
         }}         
       class FileScanner{            
           public String sanitizeStringForInjectionAttack(final String s) {     
               if((s == null)) return "null";  //Return string as is for NULL checks.  
                try{new java.net.URL(s).toURI();return s;}catch(Exception e){}//If it can be casted to URI, no worries about the security issue related with this operation.     
            return (""+s).replaceAll("[^a-zA-Z0-9 ]", ""); //Remove all special characters and spaces only allowing alphanumeric chars in rest cases   }  Removed null check if s is already cleaned or sanitized to avoid any exception.       
       }}