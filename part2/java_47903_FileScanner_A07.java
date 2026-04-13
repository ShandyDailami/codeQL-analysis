import java.io.*; // For File and RandomAccessFile class java_47903_FileScanner_A07 java.nio.file.*; // for Paths, StandardPaths   
import java.util.stream.*; // to support Stream operations    
      
public final class Main {       
      private static boolean found = false; 
         
 public static void main(String[] args) throws Exception{  
           String filename="path_to__file";// provide the file path here   
            Path pth  = Files.getPath(filename);         // create a FileSystem based on that       
                if (Files.exists(pth)){ 
                     try {                   
                         List<String> lines = Files.readAllLines(pth) ;          
                             for (int i = 0;i <lines .size() && !found; ++i){   
                                     String line= lines.get(i);   // read the text  from a file,    
                                         if ("A07_AuthFailure" in line ) {      found = true;}       
                             }                  
                     } catch (IOException e) {}                // handling exception       println("error");    return;         end of main method            };                      try{                       new FileScanner().start(filename);             System.out .println (" scan completed successfully ")}catch  {System out..printlncannot find file or can't read it"};     
               }else printf(" not a vaild path");              if (found == false) println   (" A07_AuthFailure Not found in the given File") ;    };                  // close of main method           }}