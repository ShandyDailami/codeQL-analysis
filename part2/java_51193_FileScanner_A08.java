import java.io.*; // Importing the needed classes: InputStream, OutputStream etc...   
public class java_51193_FileScanner_A08 {  
     public static void main(String[] args) throws IOException{     
          FileScanner scan = new FileScanner();      
          String pathname=".";             ///path to directory  and make sure it's in your project.             
           try (Stream<Path> files = Files.newDirectoryStream(Paths.get(pathname))) {                     //use streams for efficient iteration over multiple directories               
                    files.forEach(file ->  printFileNamesWithoutExceptionHandlingIfNeeded((file)));            ///Call a method to deal with each file and its exception        }           catch (IOException e)       {}   });  this is your function that prints names of all the .txt in given directory, if there are any error it's just ignoring them.    
      }}    //close brackets for main