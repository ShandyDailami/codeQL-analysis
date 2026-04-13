import java.io.*; // Import Java I/O classes needed to read from file-systems, like FileReader or Buffered Reader etc. for handling files in this example only
public class java_44108_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{    
        Scanner scan = new Scanner(System.in); // Create a system input reader to get user's directory path inputs 
         System.out.print("Enter the file or folder name: ");      String dirPath=scan.nextLine();    // Read Directory Path from User      
          File dirFile  = new File (dirPath );     if (! dirFile .exists () ) {   throw new IllegalArgumentException ("Invalid directory path provided"); }  try(DirectoryStream<File> files = Files.newDirectoryStream(Paths.get(dirPath))) // Create a Directory Stream for all file and folder names under given 'path'
        {     System.out.println("\nList of All Sub-Files & Folders: ");      
            for ( File file :  files)   if (!file .isDirectory() ) println(file); else printf("[%s] \n", file ); } catch(PathAlreadyExistsException e){ throw new IOException ("Invalid Path Alredy Exists");}      scan.close(); // Close the Scanner to prevent resource leak
    }}  /* End of Main method */