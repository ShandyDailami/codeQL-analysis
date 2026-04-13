import java.io.*;  // Importing necessary classes for file handling   
  
public class java_47621_FileScanner_A01 {     
     public static void main(String[] args) throws IOException      
         {       
              String directoryPath = "/path/to/directory";         
               File dir = new File(directoryPath);             // Create a object of the file named 'dir'          
               
            if (dir.exists())     
                  printFilesRecursively(".txt", dir, 0 );      
              else  
                 System.out.println("The given directory does not exist");       
         }         
     static void printFilesRecursively(String extensionToMatch , File fileOrDirectoryInQuestion , int indentation) throws IOException      {             // Recur for all directories           
           if (fileOrDirectoryInQuestion .isDirectory())      
               System.out.println();        // Indents the directory name        
              else  printFilesRecursively(extensionToMatch, fileOrDirectoryInQuestion , indentation);   return;     }    PrintWriter writer = new PrintWriter("log-" + dirName+".txt", "UTF-8");      for (String s : file.list())        {            
                     File f =new File(fileOrDirectoryInQuestion,s) ;            String absolutePath=f.getAbsolutePath();     if (!absolutePath .endsWith ("." + extensionToMatch)) continue;       writer .println(" ".repeat (indentation )+ "File :" +  s );
             }         printWriter:close(writer);      // Closes the PrintWritter          Logger.getAnonymousLogger().log("Logging completed");  }}  `