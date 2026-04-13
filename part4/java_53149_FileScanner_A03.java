import java.io.*;  // Import File, Files and Paths classes  
// ... other import statements if needed (like BufferedReader)...    
public class java_53149_FileScanner_A03 {   
 public static void main(String[] args){         
 try{          
  String path = "/path/to";       // change this to your directory           
         File file =  new File("dirname");     
         java.nio.file.Path p  = Files.probeDirectories(new File(path).toPath());  
                      if (p != null) {    
                            System.out.println("\r\nListing files in " + path);        // List all the file names           for each        `