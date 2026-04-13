import java.io.*; // Import the necessary classes for File I/O and IOExceptions handling  
public class java_51153_FileScanner_A08 {    
    public static void main(String[] args) throws IOException{      
        String directoryPath = "/path_to_your_directory";     
         try (FileScanner scanner = new FilteredFileListing(new File(directoryPath).toPath(), "*.txt"))   // Scan the file listing using a filter for txt files only.   
            {    
                while (scanner.hasNext())  {         
                    Path path =  scanner.nextPath();     
                     System.out.println("File Name: :" +path);        
                      FileInfo info = new SimpleFileAttributes(path).toFileAttributes();        // Get the file attributes using java's built-in class for simple files      
                       if (info instanceof  SymLink) {         
                           throw new SecurityException ("Symlink Found in directory: " + path);      }         else{  
                            try (BufferedReader reader = Files.newBufferedReader(path))     // Open file and read its content       
                                while ((reader.readLine()) != null) {}       catch  (IOException e){           throw new SecurityException("Access to File: " + path,e);      }         if (!info.isFile() && info instanceof Directory) {          try{Files.delete(path)}catch(AccessDeniedException aex){throw  
            aex;}}     catch  (UnsupportedOperationException e1 )       //Check for unsupport operation on this file type, it could be the case of read-only or write only directory/files      { throw new SecurityException("Attempted to perform operations not permitted: " + path); }}}}