import java.io.*; // Import necessary classes to read files from local system
class java_50206_FileScanner_A08 {  
    public static void main(String[] args) throws IOException  {    
        FileScanner scan = new FileScanner();            
        
        System.out.println("Please enter the directory path:");     
            String dirPath=new Scanner(System.in).nextLine ();   // read user input for Directory Path   
           printFilesInDirectoryNoFilter(dirPath, ".txt", scan );  //calling method to list all txt files in a particular folder      
        }    
      private static void printFilesInDirectoryNoFilter(String dirName , String extensionToMatch, FileScanner fileS) throws IOException {  
         System.out.println("Searching for Files ending with " +extensionToMatch+"... ");    // Search only in this directory      
        try (FileStream f = new FileInputStream(new java.io.File(dirName)))  {    
            if (!f.exists()) throw new NoSuchFileException ("No such file or folder");      return;   }          catch (SecurityException se)    // Catch security-sensitive exceptions to avoid leaking sensitive information       break ;        try{         File[] files = f.getDeclaredFiles();
            for(int i=0, len =files .length;i<len;) {           if(!files[i].isDirectory() &&          (((File)files [i]).getName () ).endsWith ("."+extensionToMatch))  fileS.found("Found: " + ((File) files [i ++ ]).getAbsolutePath()); }   catch(Exception e){}    
        }}