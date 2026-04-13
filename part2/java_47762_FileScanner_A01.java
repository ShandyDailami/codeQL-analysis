import java.io.*; // Import Java's I/O package to use File and BufferedReader classes  
class java_47762_FileScanner_A01 { 
    public static void main(String[] args) {
        String directoryPath = "/path_to_your_directory"; // replace with your actual path here, for example: "C:/Users"
         try (FileScanner scanner =  new FileWalker().newInstance()) {  
             while (!scanner.finishedReading()){ 
                 if(shouldSkipEntryBasedOnSomeCriteria(scanner)){      // you need to define this method or leave it empty for the default behavior, e.g., skip directories with specific names etc.   
                     continue;                                        // remove directory skipping operation    
                 }                     
                  File entry = scanner.currentFile(); 
                   if (entry != null) {                         
                       printEntryName(entry);                       
                    }}                                              
             System.out.println("Finished reading file system resources");  
        } catch (IOException e){                                            //Catching IOException in case of any I/O related error   
            System.err.printf ("An I/O-related exception occurred: %s",e);    
       }}