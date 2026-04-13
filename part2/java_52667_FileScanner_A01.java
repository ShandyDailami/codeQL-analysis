// FileScanner Class that can be used to read and list down text files in given Directory. 
public final class java_52667_FileScanner_A01 {  
     private static void main(String[] args) throws IOException{    // This is the entry point of our application     
         String directoryPath = "/path/to/yourDirectory";      
         File file= new File (directoryPath);                  
                 if (!file.exists()){                            
                     System.out.println("No such Directory");     return;                       }  // Checking for the existence of a specific folder    else{                          String[] txtFiles = file .list(new FilenameFilter(){ public boolean accept(File dir, File name) {return (name != null && new File(dir,
                     '