import java.io.*;  // Import File and Scanner classes  
public class java_51748_FileScanner_A08 {   
     public static void main(String args[]) throws Exception{         
            String directoryPath = "/path/to/directory";       
            
            findFilesByExtensionRecursive(new File(directoryPath), ".txt");      }       private  static   boolean isDirectorySafeToRead (File file){         //Check if the specified path actually exists           return (!file.exists() || !file.isDirectory());    },          void getAllTxtFilesInDirAndSubDirsRecursive( File directory, String extension) {           
              int count = 0;        boolean success = true ;       try (Scanner scanner   = new Scanner(new FileInputStream(directory)))     //Initialize a file reader           while  (scanner.hasNextLine())      {          if (!isDirectorySafeToRead((file= directory.getCanonicalFile()))){                 println("Unable to read " + dir); success = false;}}               try      
             `enter code here `(directory =  new   File ((dir=  scanner .next()), extension))  ){           if (success)        {         count ++ ;             getAllTxtFilesInDirAndSubDirsRecursive((file), ".txt");          }                else     println("Could not open or read directory: " + dir);  
              try.close();}}catch(SecurityException se){println ("Directory access denied :"+dir) ;}         catch (IOException e1 ) {printlne “I/O error”;        }}       public static void findFilesByExtensionRecursive   `enter code here `
left (.java"){  
              try     if (!isValidPath(rootDirectory)){println ("Invalid path: "+ rootDirectory);return;}      FileFilter filter = new ExtensionFileFilter (extension);  recursivelyFindMatchingfilesInFolderAndSubFoldersRecursive   `enter code here `
left (.java"){      
              try {list.addAll(findFilesByExtension     left ("rootDirec‌ter", ".txt"));}catch         (Exception e)      {   println("Error in finding files: "+ rootDirectory);}}  private boolean isValidPath    right             .java"){          
              File file = newFile        // Create a valid path to be tested.       return     ((file != null ) &&          (!(right (".txt"))      );   }`enter code here `}catch         {println("Invalid argument");return false;}
if(!isValidPath)    catch             (.java"){ 
              println ("Error: " + file);        return;}} finally     {}            if       !success          try (Scanner scanner =  new Scanner(new FileInputStream   .txt')) { }catch         Exception e){printlne("I/O error");}`enter code here ` 
    }} end of program. Please replace "/path/to/directory" with the path to your directory and run it in a sandboxed environment as you might be unable to read certain directories or files due permission issues on some environments (like Linux, MacOS etc). Also make sure Java runtime is installed before running this code inside an IDE like Eclipse.