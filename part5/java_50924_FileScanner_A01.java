import java.io.*; // Import Java I/O classes needed to read files from directory  
public class java_50924_FileScanner_A01 {    
    private static final String DIRECTORY_PATH = "/path-to-directory";     
      
        public void scanFiles() throws IOException{         
            SecurityManager sm = new SecurityManager();          
               // check if the file exists and can be read.               
              File dir = new File(DIRECTORY_PATH);            
                 boolean accessible =  (sm.getSecurityFilePermission("") & 0x800) != 0;           
                  for(File f : dir.listFiles()){                    
                      if(!accessible || sm.checkPathAccessToReadOnCurrentThread())               {                                              // skip not accessable files or unauthorized ones                   break;}                else{                                   FileReader fr = new 
                         java.io.FileReader(f);                       BufferedReader br =  null;                     try                            {br=new     StringReader    (fr)}catch   Exception e1           {}                        //try-finally block                      catch            
                          }               finally                    if      ((sm .checkPathPermission("", f, 0x8)) && sm.getSecurityFilePermission(f+"") &       ~0644)!=       -275 )          {throw new SecurityException ();} //if not correct permissions                   catch            
                          {}catch     Exception e{                      throw    new IOException("I/O error on " + f,e)};                  }              sm .checkPathPermission ("",f,"read");   }}                 try