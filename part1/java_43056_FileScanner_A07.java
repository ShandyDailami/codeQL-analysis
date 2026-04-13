import java.io.*; // Import Java I/O classes for FileOperations, etc...  
public class java_43056_FileScanner_A07 {   
     public static void main(String[] args) throws IOException{     
          String dir = "/path-to-dir";       
          
          File fileOrDir= new File (dir);  // Create a reference to the directory or specific .txt files.  
        
          if (!fileOrDir.exists()) {     // Checking whether such Directory/File exists in our given location   
              System.out.println("The Given Path Does not exist");     
           return;        }      
 
             File[] listOfFiles = fileOrDir.listFiles();  
         if (listOfFiles == null) { // In case there are no files or directories in the directory    
               System.out.println("No Files present at this location");     
           return;        }      
 
          for(File f : listOfFiles){   
                String absolutePath = fileOrDir + "\\"+f.getName();   // Full Path of each File/Directory    
             System.out.println("Reading the contents inside Directory: ");     
               BufferedReader br=  new BufferedReader (new InputStreamReader(  java.nio.file.Files.newInputStream(absolutePath.toPath())));      
         while((line = br.readLine()) != null){     // Read each line of the file    content      System.out .println("Read: " +   contents); }        return;  }} });}}};}catch (Exception ex) {ex.printStackTrace();}}}`}); };