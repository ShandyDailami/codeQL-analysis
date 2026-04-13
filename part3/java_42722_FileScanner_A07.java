import java.io.*;   // Import Java I/O classes such as InputStream, OutputStream etc..   
import javax.nio.file.*;  //Import Path and FileSystems from these packages to read directories recursively    
      import static java.nio.file.StandardCopyOption.*;      
              
public class java_42722_FileScanner_A07 {  
          public void scanDirectory(Path directory) throws IOException{   
              try (Stream<Path> paths = Files.newStream(directory))  //create a new input stream for this path    
                  {paths.forEach(path ->  /*if it is file then perform action, else ignore*/  
                      System.out.println((fileExist) ? "File:    " + path : "Directory: "+ path)); } ){      //iterate through each item in the stream    
              if (Files.isDirectory(directory)) {  /*if it is a directory then recursive call */  
                  scanDirectory(directory.resolve("."));/* resolve to current dir and pass into function*/    }}       catch (Exception e) {{e.printStackTrace();}} }        public static void main(String[] args){          //test the method     ScanFile sc=new …ScannerFunction() ;          
              try {   /*pass your directory path as an argument to scanDirectory Method */sc .scanDirectory((Paths).get("C:/Users/user"));} catch (Exception e) {{e.printStackTrace();}} }}