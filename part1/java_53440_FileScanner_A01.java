import java.io.*; // Importing the required classes  
public class java_53440_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{      
        File file = new File("/path/to/yourdirectory");        
          
            String[] directoriesList;         
                if (file.isDirectory())             // Checking whether the directory exists or not  
                    directoriesList  = file.list();  // Returns an array of Strings for listOfFiles   
                        System.out.println("Following files and sub-directories present in 'src' ");      
                    
                            FileScan(file,directoriesList);        
                                }            
                private static void FileScan (File directory , String directories[]) throws IOException{          // Recursive method to navigate through the file system            if  (!directory.canRead())        throw new SecurityException("Access Denied");           try   {                           while(true){                          for (String s : directoriesList )
                            printDirAndFilesInfo(new File((Object) directory,s));          // Printing out info about all the files and subdirectories    if (".".equals(s)) continue;                  String path = ((File)directory).getPath() + "/" +  s ;              try   {                          
                                ( new  java .io . FileScanner((new DirectoryIterator(" "+path))) ).scan().forEachRemaining(file -> printDirAndFilesInfo(file)); } catch    (SecurityException e){                       System.out.println (" Access Denied");}        break;}}            }}