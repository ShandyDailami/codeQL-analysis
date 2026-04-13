import java.io.*; // Importing necessary classes like File, DirectoryStream etc..   
     import javax.management.* ;//Import for SecurityManager & AccessControlList class .      
public class java_44155_FileScanner_A08 {     
        public static void main(String[] args) throws IOException{          
            String dirPath = "/home/user"; // directory path to be scanned         
             File fileScanner= new File("/dir_path");//File object for the scan   
              SecurityManager sm =new  SecurityManager();     
               AccessControlList acl=  (AccessControlList)sm.getSubjectAccessList(fileScanner,null);     // get access control list   .           
             boolean canRead=acl.supports(new PrivilegedAction() {         public boolean run()    throws Exception{ return fileScanner.canRead(); } });      if(!canRead)          System.out.println("Access Denied");        else       File[] files=  fileScanner .listFiles ();   //get all the contents of folder    
             for(File f:files){         BufferedReader reader=null;           try{                     // opening each and every textfile      read them    } catch  IOException e {                 System.out.println("Unable to open files");              return;}          if(!f .isDirectory() &&   (new FilePermission(f.getAbsolutePath()).toString().equals ("java.io.FilePermission \"user\"+? write")) ){             writer= new BufferedWriter 
                   (     new      FileWriter    f. getAbsolutePath(), true));          try {                 // Writing in the file         } catch   IOException e2 {                             System .out               out              .println ("Unable to open files for writing"); return;}}}}}                  }}`}