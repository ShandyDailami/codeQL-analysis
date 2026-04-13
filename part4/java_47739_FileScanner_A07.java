import java.io.*;   // Import required classes from Java's io package 
class java_47739_FileScanner_A07 {    
    static void scan(String path) throws IOException{     
        try (DirectoryStream<Path> dir = Files.newDirectoryStream(Paths.get(path))) {         
            for (Path p : dir){             
                if (!Files.isDirectory(p)){               // Check whether a file is not directory      
                    FileScanner fscan= new FileScanner();   
                        System.out.println("File name: " + p.toString());  }             }}            catch (Exception e) {         throw new IOException ("Cannot read the path"+e);      }}}                  finally{          // Cleanup           try(dir){...}   if there are any issues, we can handle them in a separate function below     printError();    return;}}}