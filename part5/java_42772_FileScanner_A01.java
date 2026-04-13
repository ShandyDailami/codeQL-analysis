import java.io.*; // Import the necessary classes for handling files and directories
public class java_42772_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{         
        String folderPath = "/path/to/folder";     // specify your directory path here          
         File dir = new File (folderPath); 
                   
            if (!dir.exists() || !dir.isDirectory()) {   /* Checking whether the provided location exists or not */   
                System.out.println("No such Directory exist in this Location."); // Providing feedback message for wrong path               } else{      FileScanner(folderPath);             }}  file scanning function is here, which will print out all files present inside a folder with their absolute paths     private static void FileScanner (String Folderpath) {
            try  
              /* Using java.io's method for list of directories and iterate through them */        
                Files.walk(Paths.get(Folderpath))  // this will print all files recursively inside the folder     .forEach((p -> System.out.println ( p )})    }} } catch {}   /* Catch block is not needed as we are only printing out file paths */;