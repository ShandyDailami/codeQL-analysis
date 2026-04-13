import java.io.*; // Import necessary classes and functions  
import java.util.regex.*; // For Pattern & Matcher class java_53173_FileScanner_A07 class Main {   
       public static void main(String[] args) throws IOException{     
          String path = "your-directory";// Your directory to be scanned goes here       
           try (FileScanner scanner =  new RudimentaryFilesystemManager().newSimpleFileScanner())  // You can use your implementation of the FilesSystem object  
            {   
                Pattern pattern=Pattern.compile("your-specific string", Pattern.CASE_INSENSITIVE);     
                   for( File file: scanner.filesIn(Paths.get(path)) ){        // Loop over all files in the specified directory      
                      Matcher matcher = pattern.matcher(Files.readAllLines(file.toPath()));    
                       if (matcher.find()){   
                           System.out.println("Found string at file: " + file);      // Prints out name of found files and position in text 
                        }       
                     }      
             }}catch (Exception e) {         
            throw new RuntimeException(e);          
         });  
    }    `;};
2. Implement a mechanism to handle `SecurityExceptions`, such as unauthorized access: