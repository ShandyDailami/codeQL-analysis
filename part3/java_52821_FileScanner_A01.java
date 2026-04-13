import java.io.*;  // Import File and IOException class java_52821_FileScanner_A01 handle errors
class Main {  
    public static void main(String[] args) throws Exception{    
        String directoryPath = "/path/to/directory";      // Directory path where you want scanning from, replace with your actual Path                
        
        try (FileScanner scanner =  new com.sun.nio.fs.UnixFileSystem.Walker(new File(directoryPath))) {   // Use Sun's native file system for Unix-based systems and custom walker instead of Java 7 built in API            
            while (scanner.hasNext()) {    
                Path entry = scanner.next();   
                 if (!entry.toString().endsWith(".sens")){          // We only need to check files ending with .sens, you can add more conditions as required        
                    File fileToReadFrom =  new java.io.File(directoryPath + "/"  +  entry);          
                     System.out.println("Reading from: " +  (fileToReadFrom).getAbsolutePath());     // Just for demonstration purposes            
                      BufferedReader reader = null;                  // Create buffering character input stream                
                       try {                                            
                            reader =  new java.io.BufferedReader(new FileReader((File) fileToReadFrom));   // Use Java 8's lambda syntax to create the Reader           
                             String line ;                                                    // Read your files data here            
                              while ((line = reader.readLine()) != null){                // To handle multiple lines in a single variable, optional step                 
                                  System.out.println(line);                                     // Use system out only for basic operations and do not use FileReader or BufferedWriter if possible             
                               }                                                           
                           } catch (IOException e) {                                             // Catching IOException to prevent program crash        
                                throw new Exception("Error occurred while reading from file: " + ((File)fileToReadFrom).getName(),e);               };                  });  }}                     ){};      break;}}}}}`   try-with resources will ensure the `Closeable` objects are properly closed. It's a good practice to follow for avoiding resource leaks in your applications and it makes sense with Java version below java8