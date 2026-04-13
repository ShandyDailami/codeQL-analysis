import java.io.*; // Import necessary classes 
  
public class java_49394_FileScanner_A03 {   
     static void listFiles(String directoryPath) throws IOException{      
         File dir = new File(directoryPath);     
          if (dir != null && dir.exists()) {       
               String[] children = dir.list(); // Get file names 
                for (int i = 0; i < children.length ;i++){  
                    System.out.println("Child: " +children[i]);     
                   File f = new File(dir, children[i]);       
                  if (f != null && f.isFile() ){ // Check we have a file and not subdirectory 
                        printAbsolutePathOfTheRegularFilesInsideDirectoryOrNotIfItIsADirectoryAgainstANamespace = new PrintAbsolutePath(new FileInformationHandling(),dir,f);    }  
                else if ( f != null && f.isDirectory()){ // Check we have a directory and not file 
                    listFilesAndSubdirectoriesInsideDirToPrintItsNameByCallingRecursiveMethodAgainstAnObjectOfTypeFile = new ListAll(new FileInformationHandling(),f);    }  
            }} else {        System.out.println("Not found " + directoryPath );}}      // Check if the given path exist 
     public static void main (String[] args) throws IOException{       listFiles("/home/user");}}}`// Calling our method to print all files and directories inside a specified dir    }}