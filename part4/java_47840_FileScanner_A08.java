import java.io.*; // Importing Java's built-in File I/O methods and classes (File, BufferedReader)  
public class java_47840_FileScanner_A08 {    
    public static void main(String[] args){     
        String directoryPath = "/path_to_your_directory";  /* Insert your own path here */       // Defining the starting point of directories we want to scan for files. For example, if you wanted all .txt in a folder and its subfolders: /Users/name/Desktop/*
        FileScanner(new File(directoryPath));  
    }     public static void FileScanner (File directory) {       // The main method of our program         String[] fileList = null;             try{            if (!DirectoryReader.getFileListingAllowFolders().includeHiddenFiles()) 	fileList= reader .listRoots();             
    else      fileList  =reader.exclude(".hidden");          }catch (SecurityException e){System.out.println("Access denied for directory: "+directory);return;}           File[] files = null;             try{files =  DirectoryReader(Directory_path).listFiles().toArray();} catch 
    //handling errors in the accessing file and folder section              if (fileList==null) return ;         System.out.println("Number of directories/subdirectories: "+ files .length);          for   ()=  < length i; ++i){ File f = null;} try {f = 
    //files[index]. If( file ==null || !  (file..isFile())) continue ;              System.out.println("Name of the Directory/SubDirectory: "+ files [Index]); }          return}     }}`