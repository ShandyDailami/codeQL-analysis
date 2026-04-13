import java.io.*; // Import Java I/O classes needed such as FileInputStream etc... 
public class java_43013_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{    
        String directoryPath = "/path_to_your_directory";      
        
        try (FileScanner scanner =  new FileInputStreamReader()) // use a file input stream reader for authentication reasons, not necessary in the context of modern Java. It's more secure to read files with built-in libraries or frameworks if possible. 
          {    
            printFilesInDirectory(scanner , directoryPath);        
        }    catch (FileNotFoundException e){ // Authentication failure handling can also be handled here, instead of in the try block where it's not needed as per modern Java guidelines  
           System.out.println("Couldn’t find file " +e ); 
          };     
     }        
    private static void printFilesInDirectory(FileScanner scan , String directoryPath){            
        // use 'scan'.list() to list all files in the given path, then process them one by-one...          
            System.out.println("Printing out file names from: " +directoryPath); 
     }  
}