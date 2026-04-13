import java.io.*; // Import required classes  
import java.nio.file.*; // Import class java_52890_FileScanner_A03 work with files and directories 
// import other necessary libraries if any as per requirement (e.g., Java Standard Libraries, third-party utilities)

public final class Main {   
     public static void main(String... args){  
          long fileCount = getFileListAndPrintNumberOfLinesInFiles(".", path -> Files.isRegularFile(path)).size(); // Count files (not directories). 
           System.out.println("\nTotal Lines in Regular File: " +fileCount);   
     }  
     
     /* This method will recursively go through every file within the provided directory and print out their line count */
     public static Long getFileListAndPrintNumberOfLinesInFiles(String path, Predicate<Path> predicate){ 
          try (Stream<Path> walk = Files.walk(Paths.get(path))) {   // Create stream for file walking operation   
               return walk                  
                .filter(predicate)         // Filter the files based on given condition from directory or other directories inside it     
                .mapToLong(Main::countLinesInFileNonRecursive)  // Map each Path to a line count (this will be done in parallel for all paths).  
                .sum();                     // Collect and sum up the counts.   
          } catch (IOException e){         // Handle exception if something wrong with file access occurs     
               throw new UncheckedIOException(e);    
           } 
       }            
       
       /* This method will count lines in a given non-recursive File */  
       public static long countLinesInFileNonRecursive (Path path){    // Method to execute parallel line counting operation on all paths.     
              try(BufferedReader reader = Files.newBufferedReader(path)){     // Trying opening the file for reading  and creating a Buffering Reader object      
                   return reader.lines().count();           // Count lines in each path (this will be done sequentially)       
             } catch (IOException e){                        // Handle exception if something wrong with IO operation occurs         
                  throw new UncheckedIOException(e);           
              } 
      }  
}