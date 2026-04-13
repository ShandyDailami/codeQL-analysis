import java.io.*; // Importing necessary classes needed to process file I/O streams and paths  
class java_47160_FileScanner_A03 {    
    public static void main(String[] args) throws IOException{        
        File directory = new File("your_directory");     
            printAllTextFilesInDirectory(directory);  }       private static void printAllTextFilesInDirectory (File dir){              try {                 if (!dir.exists()) throw new IllegalArgumentException ("Given path does not exist!");                for (String s : dir.list())               File file = new File((dir.getPath() + "/" +s));            
            // Checking whether the object is a directory or an ordinary file         printAllTextFilesInDirectory(file) ;     } catch (Exception e){      System.out.println("An error occurred while processing files in: "+ dir);   }}    };