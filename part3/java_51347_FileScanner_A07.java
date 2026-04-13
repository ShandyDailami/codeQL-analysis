import java.io.*; // Import Java I/O related classes  
class java_51347_FileScanner_A07 {     
    public static void main(String args[]) throws IOException{    
        String folderPath = "/path_to_your directory";  /* your path */            
       FilenameFilter filter =  new FilenameFilter(){          
            @Override             
          public boolean accept(File dir, String name){                // Accept all files (not directories or hidden ones)                 return true; }                    };   });     File folder = new File("folderPath");               if (!folder.exists() || !folder.isDirectory()) {             System.out.println('"' + folderName  + '" not found');        
            exit(-1);                                                       // Exit program                  return false;}        for (File file : folder.listFiles(filter))    {}       }  }} ;;}}