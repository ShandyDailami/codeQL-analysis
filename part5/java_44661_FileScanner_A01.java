import java.io.*; // Importing File and Scanner class java_44661_FileScanner_A01 class Main {   
     public static void main(String[] args) throws Exception{         
           String dir = "/path/to/directory";         // directory to read the files from       
       try (FileScanner scanner =  new SimpleFileScanner()){           
             File fileOrDirectory =   scanner.scandirSingleResult("/yourfileinDir", 1);    /// replace /dir with your actual dir and '/path/to' by path to directory containing the files you want, e.g., "/home"     .absolutepath();        
               if ( fileOrDirectory != null) {              // Checking whether a specific File or Directory is there in given Path  
                   System.out.println("File found: " +fileOrDirectory);          /// Prints the absolute path of such Found files/directory  and also prints name        .name();         } else{           ...            }} catch (Exception e) { // Handle any exceptions which may occur    ....}};