import java.io.*;
  
public class java_42990_FileScanner_A08 {
    public static void main(String[] args) throws IOException, InterruptedException{
        File root = new File("."); // Use the current directory for testing purpose only! Change it to your target path if needed!! (example: "/path/to/yourdir") 
  
        printFilesWithIntegrityFailureNameEnding(root);   
     }
     
     public static void printFilesWithIntegrityFailureNameEnding(File root) throws IOException, InterruptedException { //Recursive function to search for .txt files in a directory and its subdirectories. 
         File[] listOfFiles = root.listFiles(); assert (null != listOfFiles);  
        if (!root.canWrite()) throw new SecurityException("Cannot write here!");   
          // Checking the permissions of file/directory, we assume it is safe to access them! 
         for(File f : listOfFiles){      
             String name =f.getName();     
              Thread.sleep(100);  
            if (name != null && name.endsWith("A08_IntegrityFailure") ){ //Checking the file/directory names to see whether it ends with A08_IntegrityFailure or not, for security-sensitive operations related 2nd approach you can replace this condition by your own business logic!
                System.out.println("File: " + f);    }   else if(f instanceof File){ // If the file is a directory recursively call printFilesWithIntegrityFailureNameEnding() method on it for more checks 
                 if (name != null && name.endsWith(".txt")){System.out.println("File: " + f);}   else {printFilesWithIntegrityFailureNameEnding(f)};     }       // If none of the conditions are met then we will exit from recursion 
        }}