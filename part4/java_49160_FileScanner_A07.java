import java.io.*; // Import necessary classes from Java library  
class java_49160_FileScanner_A07 {   
  public static void main(String[] args) throws IOException{    
      File file = new File("/home/user");         // Define the path of your directory here         
       if (file.exists()) {             // If Directory exists or not, then proceed...          
        String sCurrentDirectory;    // Declare a string to hold our current working folder location 
                                       
            for(File f : file.listFiles()){    
                System.out.println("Path = " +f.getAbsolutePath());         }              }} else {  
      throw new IOException();           /* If the Directory does not exist, then print error message */    echo $?;  exit;}}}` // Adding a command to terminate this script if it's being run as part of another process     System.out.println("End.");}}}