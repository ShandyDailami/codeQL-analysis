import java.io.*;
import java.lang.reflect.Field;

public class java_50705_FileScanner_A03 {
    public static void main(String[] args) throws IOException, IllegalAccessException{
        String directoryPath = "/path/to/your/directory"; // Provide your target path here  
        
        FileScanner scanner= new FileScanner(); 
            
       try (FileScanner fileFilteringScanner = 
               new FileScanner(new java.io.File(directoryPath))) {    
            for (;;) {      // Infinite loop to keep scanning until you break out of it   
                File next = fileFilteringScanner.next();  
                 if (next != null)  {                     
                     Field[] allDeclaredFields =  next.getClass().getDeclaredFields() ;      
                       for(int i= 0;i<allDeclaredFields.length;+++){      // Iterate over fields in current file    
                          String fieldName = (String)allDeclaredFields[1].getName();  
                         if(!isSecuritySensitiveFieldAccessibleByReflectionAPI(next,fieldName)) continue;}  /* Skip sensitive operation */          
                      System.out.println("File : " + next.getAbsolutePath());     // Print the file name      
                     }                  
                }       
            if (!fileFilteringScanner .moreFilesToRead()) {   break;}}          catch (Exception e) {}    finally{  }}                      try(final Scanner s = new Scanner(new File("mypid"))){while(s.hasNext()){System.out.println(s.next());}}}
                 /* End of code */