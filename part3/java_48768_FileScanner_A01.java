import java.io.*; // Import the required classes: BufferedReader, InputStreamReader etc.  
// import static utilities.*;   
public class java_48768_FileScanner_A01 {     
     public void start() throws IOException{                 
        String directoryPath = "/path/to/directory";  /* Your target dir here */               
         File rootDirectory= new File(directoryPath);          //get the file system object for our root   Directory.          
              if (rootDirectory.exists()) {                   //If it exists then proceed                     
                 String[] children = rootDirectory.list();    /// list all files and directories in given directory 
                  for (int i = 0; i < children.length; i++) {      /* Iterate through each item */                   
                     File fileOrDir= new File(rootDirectory,children[i]);   //Create a path object    
                      if (!fileOrDir.isHidden())  {}         /// check for hidden files/directories                .   
                             if (fileOrDir.isFile()){               /* If it's an actual file */                    
                                System.out.println("Found File: "+ children[i]);                   //Print the filename     system.Out println(children [I] +" is a file");                        .   } else if (fileOrDir.isDirectory()){               /* Else it's an directory */                    
                                System.out.println("Found Directory: "+ children[i]);                   //Print the dir name     system.Out println(children [I] +" is a Dir");                                              }}}catch (Exception e) {e.printStackTrace();}  }}// End start method}}}`