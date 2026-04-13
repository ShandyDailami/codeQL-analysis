import java.io.*; // Import of File class java_53461_FileScanner_A03 its subclasses  
    
public class ReadFile {   
       public static void main(String args[])  throws IOException{         
               String dir = "C:/test/";             
                int i = 0;                             
                  for (final Entry entry : new java.io.file.SimpleFileSystemView().getFileStore(dir).listEntries(".", false)) {                    
                      if (!entry.isDirectory())  // Ignore directory entries  
                          System.out.println((new File(entry.getPath()).getName()));    }                 };             });        `                  );              i++;      }}     finally{          try, e -> StreamSupportingMethodRefactoringExamplee in (File dir).listEntries(".", false) { if (!it's a directory){print it}