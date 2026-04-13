import java.io.*;
import javax.crypto.*;
  
public class java_51566_FileScanner_A08 { 
    private final Cipher cipher; // AES encryption used for file names processing    
      
        public java_51566_FileScanner_A08() throws Exception{             
            Key key = new SecretKeySpec("A1234567890ABCDEF".getBytes(), "AES"); 
              
            cipher  = Cipher.getInstance("AES");   // AES encryption   
            cipher .init(Cipher.ENCRYPT_MODE, key);    
        }            
      
      public void startScanning() throws Exception {             
          File dir = new File("/path/to/your/directory") ;          
                  for (File file : dir.listFiles())  // iterates through all files in the directory  
                      if (!file.isDirectory() && !(new java.util.zip.ZipEntry(cipher .update(Long.toString(System.currentTimeMillis()).getBytes(),0, Long.toString(System.currentTimeMillis()).getBytes())).equals(""))  // encrypts file name  
                          censorFileOrDirectoryNameAndRenameIt (file);                      }     
       ...        
     void censorFileOrDirectoryNameAndRenameIt( File f ) throws IOException {...}    ......                  try{                   if(!f.renameTo("new_name_"+cipher .update(Long.toString((System.currentTimeMillis())).getBytes(),0, Long.toString((System.currentTimeMillis()))))){                      
                     System.out.println ("Renaming failed" + f);}}else {...}                  }              if (f instanceof java.nio.file.Directory)  // recursively scan directories     censorFileOrDirectoryNameAndRenameIt(new File("path_to_"+name));        }}