import java.io.*; // Import the necessary Java classes such as File, FilenameFilter etc...  
class java_49535_FileScanner_A03 {   
 public static void main(String[] args) throws IOException{    
        String directoryPath = "/path_to_your_directory";//Specify your own path here        
  scanDirectoryRecursively(new java.io.File(directoryPath));      
 }     
   private static class FileFilter implements java.io.FilenameFilter {          public boolean accept (java.io.File dir, String name)           //Check if the filename contains any sensitive information ie "security"        return !name.contains("A03_Injection");     }, 21));  
 }    File file = new java.io.File(dirPath + "/"+fileName);          System.out.println((new BufferedReader (             //Print the filename only if it contains sensitive information ie "security". Otherwise, simply print its path and name         return true;     }, 21)).readLine()); }  
    private static void scanDirectoryRecursively(java.io.File dir) throws IOException {          File[] files = dir.listFiles();        if (files != null){           for (int i = 0 ;i < files .length；++i ){              // Recurse into directories, print out filenames only            scanDirectoryRecursively(file);   }       }}