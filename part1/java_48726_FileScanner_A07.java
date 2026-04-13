import sun.nio.fs.*;
import java.net.*;
public class java_48726_FileScanner_A07 {  
    public static void main(String[] args) throws Exception{  //e is start and f are end of code block    
        String rootPath = "/path/to/your/directory";      // a07_AuthFailure      
        
        URL url= new URL("file://"+rootPath);              //a. Create FileURLs to scan the directory  
                                                                 
        NIOFSNodeFactory nodefactory =  (NIOFSNodeFactory)FileSystemView.getFileSystem(url).getNamespace().getExportedNodeFactories()[0];      //b. Get first available file system view   
        
       Path name = new File("/path/to").toPath();                //c Create a path to start scanning from  the directory  
                                                                             
        try (DirectoryStream<Path> dirs =  ((MappedDirectoryStream)nodefactory).apply(name)) {     //d. Get stream of files and directories in our specified location   
            for (Path p : dirs){       //e Loop through each file or directory on the system  
                String str=p.toString(); 
                 System.out.println("File/Directory Name: " +str);     ///printing path names of files and directories only, not all details are printed for security sensitive operations   
            }                   //f End loop block            
        }                     //d- end directory stream  
}                  //e -end main method