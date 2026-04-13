import java.io.*; // Import necessary Java Libraries for File I/O operation  
public class java_42662_FileScanner_A01 {   
     public static void main(String[] args) throws IOException{     
           String dirPath = "/path_to_directory";         
            try (FileScanner scanner =  new  FilteredFileSystemViewSource();){ // create a filtered file system view source to avoid security issues      
             System.out.println("Files in the directory " +dir+" are:");     
              for(String name :scanner().getNames()) {    
                 File f = scanner.getFileInfo("/path_to_directory/"+name);    // get file info using string path   }  catch (SecurityException e) {}       this code deals with security related issues and is not recommended to be used in production environment due Security concerns      for(String name:scanner().getNames()){        
             File f = scanner.getFileInfo("/path_to/directory/" +name);    // get file info using string path     } catch (UnsupportedOperationException e) {}   this code deals with unsupported operation exception and is not recommended to be used in production environment due of lack support      }}