import java.io.*; // Import the Java IO package for handling files, directories etc 
  
public class java_45357_FileScanner_A03 {    
    public static void main(String[] args) throws Exception{            
        File file = new File("C:\\Users");        
           if (file.exists()){                   
                 System.out.println("\nFile and directory contents in \"" + file.getCanonicalPath()+ "\" : ");     // Prints the name of this group, i.e., its canonical pathname  
 
                FileScanner scan = new FileScanner(file);                   
                 while (scan.hasNext()) {                  
                      System.out.println("\t" + scan.nextFileInfo().getAbsolutePath());    // Prints the absolute paths of files and directories in this directory  
                     }                       
                scan.close();     
            } else{                            
                 throw new Exception("Invalid file or path");         
             }          
       System.out.println("\nEnd.");    
        }}  catch (Exception e) {                   // Catch any exception that might be thrown  
         if(e instanceof FileNotFoundException){    // Prints error message for wrong absolute paths           
              System.err.printf("File not found: %s%n", e);             }                      else{                     printStackTrace();           }}  finally {          clearInvocationHint()}}`;   )} and then run this code in your local environment or IDE to see the output printed on console as per requirement, you can add more details about it if required.