import java.io.*; // Importing the necessary Java libraries for file I/O operations 
  
public class java_52599_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{          
        try (FileScanner scanner = new FileScanner()) {            
            System.out.println("Enter directory path:");                            
            String dirPath=scanner.nextLine();                              // Reading the user input for Directory Path 
              
              if(dirExistsAndIsReadable(new File(dirPath)))                     # Checking If Dir Exists and Is Readble or not  
                  scanFilesInDirectoryForAccessibleContent(".", dirPath);     # Scan Files in directory path      
            else                                                                // Display error message for Invalid Directory         
                System.out.println("\nThe entered Path does't exist, Please enter a valid one!");   
        }  catch (InvalidFileNameException ex) {                              # Exception Handling             
             System.err.print("Error: " + ex );                             // Error handling for Invalid file name exception        
    	}          	  			     		      	   	 										// End of try-catch block                 						         							    }  private boolean dirExistsAndIsReadable(File directory) {               return (directory != null &&                            ((this.isDirectory = true;                         // Check if the given path is a Directory not File                          
        });    			     		      	   	 										// Function to check whether file or Dir Exists and Is Readble  } private void scanFilesInDirectoryForAccessibleContent(String currentPath, String dir) throws IOException {             	   for (File f : directory.listFiles())                  if (!f.isHidden() && !currentPath.equals(".") )                      System.out.println("\n" + "Current Path: → \""+当前路径++“/\");