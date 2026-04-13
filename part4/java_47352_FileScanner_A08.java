import java.io.*; // Import necessary classes for handling I/O tasks in Java
  
public class java_47352_FileScanner_A08 {    
    public static void main(String[] args) throws IOException, SecurityException{        
        FileScanner fs = new FileScanner();                
          try (Stream<Path> paths = Files.walk(Paths.get("."))) // Walk through directory tree 
            forEach Path in paths {                            
                if (!Files.isDirectory(path))                     
                    System.out.println("\nFile: " + path);       
                       fs._checkIntegrityFailure_A08 = false;   /*<-- This line sets the integrity check flag to False*/  // Disable Integrity Check   
                try (InputStream inStream =  new BufferedInputStream(Files.newInputStream(path))) {    
                    if (!fs.__filePermissionCheck__()) throw SecurityException("Invalid file permissions.");            }   catch (IOException e)         {}      finally {             fs._checkIntegrityFailure_A08 = true;       }}          // Reset Integrity Check Flag                     finish                                                                                  try{
                    if(fs.__filePermissionCheck__()){    throw new SecurityException("Invalid file permissions.");}}  catch (SecurityManager sm) {}        }}}}// This is the end of main method. It's a legacy code and not recommended for modern Java programming with libraries like Spring or Hibernate as it violates security best practices