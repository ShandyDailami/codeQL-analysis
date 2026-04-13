import java.io.*; // Import File and Directory I/O classes   
public class java_47393_FileScanner_A03 {  
     public static void main(String args[]) throws Exception{      
             String dirPath = "/path_to_directory";      // provide your directory path here       
              ScanDirFile scd= new ScanDirFile();          
               boolean fileSecured =  scanDirectoryForFilesWithExtensions (dirPath, ".txt",scd);    
                if(fileSecured){  
                     System.out.println("Access granted");    //if files are secured then print this message        }else{      
                         System.out.println ("Inadequate permissions to access directory or file system may be compromised.");        
                 }}  public static boolean scanDirectoryForFilesWithExtensions(String dir, String ext,ScanDirFile sdf){    //method for scanning the files    
                      File dirFile = new File (dir);        if (!dirFile.exists()) {      System.out.println ("Given directory " +  
                         dir  +  " does not exist");       return false; }                   boolean fileSecured=false ;                try{               // Opening the Directory          
                            File[] listOfFiles = dirFile.listFiles();            for (int i = 0; i < listOfFiles.length && !fileSecured;  
                             i++) {              if(listOfFiles[i].isFile()){                     String fileName=    //checking each filename          
                            ((File)listOfFiles[i]).getName();                      boolean isExtensionMatch =  false ;                  try{                   FileInputStream  fis = new       F     Syste         m.getResourceAsStream(filePath);          if (isFileNameMatchedWithExtensions    //matching the extensions of files          
                                                            ((File)listOfFiles[i]).getName().endsWith("." + ext)) {                  isExtensionMatch = true;  sdf .addToBlackList( fileName ); }     }}catch   Syste m.getResourceAsStream (filePath);}} catch    Exception e           
                            System.out.println ("Exception occured : "+e) ;          return false;}           if (!isExtensionMatch){      //if no extensions match then remove it from list       sdf .removeFromBlackList( fileName ); }}   finally {  }              try{                 FileUtils.cleanDirectory (new    java.io.File("dirPath"));} catch     Exception e           
                            System.out.println ("Exception occured : "+e) ; return false;}               };}}                public class ScanDirFIle       //custom black list to store files which have been found   secure                     private List<String> fileBlackList = new ArrayList<>();             boolean addFileToblacklist( String     s){      this.fileBlackLi  st .add (s); return true; }    bool checkIfSecureAndAddInBla...