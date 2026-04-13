import java.io.*; // Import required classes from Java library (Java Standard Edition)  
// FileScanner is a part of the Files class java_53557_FileScanner_A03 standard libraries, not an external framework like Spring or Hibernate   
public void fileSecurityExample() throws IOException {    
        String directoryPath = "/path/to";  /// replace with your own path      
         // Read all files from given director   y (File object) and write them to console     
          Files.walk(Paths.get(directoryPath))    .filter(Files::isRegularFile).forEach((file -> {     try{        File fileObject = new  java.io.File(); // creating a instance of the class   'java' by mistake, should be removed     
           } catch (Exception e){ System.out.println("Caught exception while reading " +    dirEntry);}})); }}`