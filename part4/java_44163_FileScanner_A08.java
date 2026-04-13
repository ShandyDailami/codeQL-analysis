import java.io.*; // for the InputStream, OutputStream classes        
public class java_44163_FileScanner_A08 {    
        public static void main(String[] args) throws IOException{            
            try (FileScanner fs = new FileScanner()){  // Start with a file scan using standard Java libraries.          
                System.out.println("Please enter the directory: ");                
                String dirPath=fs.readLine();                           
                DirectoryStream<Path> dirs = 
                        Files.newDirectoryStream(Paths.get(dirPath),  // Read all files in a given folder           
                                path -> !Files.isWritable(path)          
                                        && (    PathMatcher matcher = FileSystems     .getDefault().getPathMatcher("glob:*.java");   // Match only java source code file             
                                                 matcher.matches(path)));            System.out.println ("The selected directory contains the following files/folders:" );             Files.list( Paths.get(dirPath) ).forEach((p)->System.out.printf("%-20s%n", p)); 
                                                                                            } catch (Exception e){                   // Exception handling for file operations            System.err .println("Error :" +e);               }}