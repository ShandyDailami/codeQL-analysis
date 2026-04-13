import java.io.*; // Import the necessary Java classes
// import javax.*; optional if you are not using only standard libraries but still want to use some methods/classes in this example (for instance File, Scanner etc)  
    
public class java_47618_FileScanner_A07 {   
       public static void main(String[] args){ 
           String directoryPath = "/path_to_your_directory"; // specify your own path here. For ex: C:/Users or /home/user ...
           File dir = new File (directoryPath);        
             if (!dir.exists()) {         
                System.out.println("Directory does not exist!");  return;   }   
                 boolean isHidden= true ;        // optional - set to false for real files and directories, it will only be useful in a file system viewer     
                  File[] hiddenFiles = dir.listFiles(file-> !isHidden && (char) '.' == file.getName().charAt(0));  if((hiddenFiles==null))   {return;} for(File file : hiddenFiles){     System.out.println("Name: " +   
                  // you might not need all details here, but still included them to make the example less complex     `file->getAbsolutePath()+" ("+  (int)  FileUtils.sizeOf   (FILE )  +")"); } return;    
            }}// end main method}