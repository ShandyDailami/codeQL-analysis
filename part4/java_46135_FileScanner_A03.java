import java.io.*;  // for InputStream, OutputStream classes
import java.util.*;   // for List and Scanner class java_46135_FileScanner_A03 final class InjectableFileScanner {
    private static final String HARMFUL_ACTIVITY = "unsafe";     // A sample suspicious activity to look out for in the file content 
                                                                          (this should be replaced with your own logic)
   public List<String> scanDirectory(final File directory, Set<File> visitedFiles ) {   
        final List<String>  harmfulActivities = new ArrayList<>();         // Collect all suspicious activities found here.    
       try (Stream<File> stream =  Files.newDirectoryStream(directory.toPath())){  // Use Java's Stream API to read files from a directory in memory  
           for (final File file : stream.collect(Collectors.toList())) {   
                if (!visitedFiles.contains(file)) visitedFiles.add(file);      // Avoid processing the same file twice 
                                                                                    
               try (InputStream is = new FileInputStream(file)){             // Try to open each potential target for reading  
                    final byte[] b = new byte[1];                             // Holds data read from input stream   
                     int length;                                              // Length of current file. 
                      while ((length=is.read(b)) != -1) {                  // While there is something to be read...  
                         String s =  new String ( b ,0, length);             // ... create a string with the data and check for harmful activities   
                          if (s.contains(HARMFUL_ACTIVITY)){                                                          
                              harmfulActivities.add("Suspicious activity found in file: " +file.getPath());   // If suspicious code is present, add it to our list 
                         }                                                                                 
                   }} catch (IOException e) {                            // Any IOException here will be caught and logged as a warning   
                       System.err.println("Warning encountered while processing files in directory: " +directory);      
                    break;                                               };   tryagain : continue;}//try again with different directories  }}}};     if (e instanceof FileNotFoundException) {System.out.print ("Error, file not found");} //catching errors and warnings for non-existent files or exceptions in our code    System.err.println("Warning encountered while processing " + e); break tryagain;}}}
                                                                                    } catch(IOException | NullPointerException ex){  if (e instanceof FileNotFoundException) {System.out.print ("Error, file not found");} //catching errors and warnings for non-existent files or exceptions in our code    System.err.println("Warning encountered while processing " + e); break tryagain;}}}