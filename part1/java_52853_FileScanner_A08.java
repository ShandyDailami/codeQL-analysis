import java.io.*; // Importing the necessary Java Standard Libraries: Input/Output, FileHandling etc..  
public class java_52853_FileScanner_A08 {    
    public static void main(String[] args) throws IOException{        
        String userDir = System.getProperty("user.dir"); 
       /* This prints out a list of all the files and directories in this directory to console*/         
        File f=new File(userDir);      // Initialize file as working with it   
    	File[] lsfOfFiles;              /// Declare an array for storing our childrens           
         try (DirectoryStream<Path> dirs = Files.newDirectoryStream(f.toPath(), ".*\\.(java)")) {          
             // Iterate over the directory entries, they are of class java.nio DirectoryIterator         
              System.out.println("Directories:");      /// Print out names and sizes        
                for ( Path p : dirs ) 
                   if(Files.isRegularFile(p)) {     // If a file was found...       
                      File name = new File(p.toString());    /* Create the corresponding object */         
                       System.out.println(" - " +name);       /// Print its details to console      }}}catch (SecurityException SE){   catch for Security related Exceptions if any are encountered     //Prints out information about security-related exceptions  };}               This is a very simple example and real world scenarios would require much more complex solutions.
                */ }}                   ****End of main method**********