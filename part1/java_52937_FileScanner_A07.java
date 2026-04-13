import java.io.*; // Import the necessary classes: File and Path... etc..
// ... other imports here if needed - these are standard Java libraries only, no external ones used in this context   
      
public class java_52937_FileScanner_A07 {     
     public static void main(String[] args) throws IOException{          // Main method to start the program          
             String directory = "/path/to//directory";  // replace with your own path...  
              File folder  = new File (directory);   
               for (File file : folder.listFiles()) {      // Iterating over each files in a specific Folder         
                   if(file.isDirectory()){       // Checking whether the current object is directory or not          
                          System.out.println("Permission Denied: "+file);  }    else{  
                           try (Scanner sc = new Scanner(file)) {     // Use a `try-with resources` to ensure that scan close after use       
                             while (sc.hasNextLine())          
                                 System.out.println("Content in file: " + sc.nextLine());  }    }}   catch (Exception e)      {}         });      
              };     // End of main method          private static methods for testing purpose, they are not shown here        A07_AuthFailureScanner a = new ...; }, etc...           );}}};`);