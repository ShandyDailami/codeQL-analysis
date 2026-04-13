import java.io.*; // Importing necessary Java classes for FileScanner and IOException 
public class java_53427_FileScanner_A03 {  
    public static void main(String[] args) throws Exception{    
        String path = "/path/to";         // Specify your directory here, e.g., /home or C:\\Windows etc            
        searchFilesWithExtensionRecursively(new File(path), ".ext");   // specify the extension you're searching for 
    }      
      public static void searchFilesWithExtensionRecursively (File root , String ext) throws Exception {    
          if (!root.exists()){             System.out.println("No such directory " + root); return;}             
               File[] files = null;         // Declare your file array here      
           try{files=   root.listFiles();}catch(Exception e1 ){}       
            for (int i = 0 ;i < ((null==files)? 0 : files.length) ;i++){      if (!files[i].isFile() && !files[i].isDirectory()) continue;          // Skip directories      
               File file = null;         // Declare your "file" variable here    try{   fil=null;}catch(Exception e2 ){}    
                String name  = files[i].getName();      if (!name.endsWith("." + ext)){continue}             System.out.println ("Skipping non-"+ext  +  " file or directory:");              // Skip this type of (non-.txt)file       continue;          FileWriter fw = new   java .io   `Filewriter("/home/user"...)// Here's the line you provided
             }      if(files == null){return;}         try{  Files.walkFileTree((root).toPath(),        // Recursive file reading here     StandardCopyOption.COPY_ATTRIBUTES);}catch (IOException e) {e .printStackTrace(); return;   }}