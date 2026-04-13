import java.io.*; // Importing the needed classes 
  
public class java_51448_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{      
        File file = new File("path_to_your/file");          
        
          try (FileScanner scanner = 
              new com.sun.nio.fs.Files.newScanner( // Using custom class from Java SE API 6845329, it's necessary to use this one as we are not allowed the standard library classes like FileSystem or Files  
            file , StandardOpenOption.READ)){            
              while (scanner.hasNext()){               
                  String line = scanner.nextLine();               // Reading a Line of text 
                   if(line.contains("failed to authenticate")){    // Checking for specific words related authentication failure  
                       System.out.println("Suspicious activity detected in: " + file);        
                       System.out.println("\t Activity description :"+ line );               
                    }              
              }            
          }     return;      
      catch (Exception e){           // Catching any exceptions that might occur during the execution of our code 
        printStackTrace(e);         // Call to method inbuilt for printing exception information  
    };                         
};