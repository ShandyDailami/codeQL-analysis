import java.io.*; // Importing required classes for file handling and I/O operation  
class java_52725_FileScanner_A01 {   
     public static void main(String[] args) throws IOException{       
          String directoryPath = "/path_to_directory";      // Specify your Directory path here      
           File dir = new File(directoryPath); 
           
           if (dir.exists()) {  
                System.out.println("Directory : " + dir.getAbsoluteFile());   
                
               /* Using listFiles method to get all file names from the directory */            
              String[] filesList = dir.list();      // This will return a string array of filenames (filepaths) present in given path  
                System.out.println("All Files: ");      
                         for (String filename : filesList){    
                             File file = new File(dir,filename);  /* Create the object using directory and Filename */   
                               if (!file.isDirectory()){      // If it is a non-directory file i.e., image or not  
                                     System.out.println("File Name: " + filename );      
                                   }       
                             }           
                          } else {    
                                System.out.println(dir.getAbsolutePath()+" directory does not exists");      // Else print the error message 
                            }}   catch (Exception e){    /* Catch block to handle exceptions */          try{         if (!file.isDirectory())       {        FileReader fr = new FileReader(" + filename);} }catch(IOException ex) {}             System.out.println("\n An Error Occured");           
                                                                                     }}   // End catch     for loop  end });    This block will print all files and directories name from the directory in path specified by user, it is not sensitive to any security-related operations like access control etc .}                      }