import java.io.*; // Import necessary classes in the FileScanner example program   
  
class java_51296_FileScanner_A07 {    
 public static void main (String[] args) throws IOException{      
      String directoryPath = "/path/to/directory";       
         
      /* Obtain a list of files present inside this Directory */        
      // Create an instance using the specified file path           
           File directory = new File(directoryPath);  
              if (directory.exists()) {    
                  String[] childrenList =  directory.list();  // Get all Files names in that particular folder    .....       } else{          System.out.println("The given Directory does not exist.");      }}       
                for (String childName : childrenList)   {}         File fileToCheck = new     File(directoryPath + "/"+childName);  // Check if the name is a directory or Filename .....       }          System.out.println("The specified Directory does not exist.");      }}