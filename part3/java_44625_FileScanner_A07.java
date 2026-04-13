import java.io.*; // Import necessary classes from Java IO package 
class java_44625_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{
        File f = new File(".");// current working directory, you can change this to a different path if needed    
        
        boolean secure;       /* flag for security-sensitive operations */     
         
        // Scan all items in the given file or files (directories).   
        String[] list=f.list(); 
          
            System.out.println("Secure Operations:");  
              if(SecurityManager sm = System.getSecurityManager()){             /*Check for Security Manager */        
                  // We are not allowed to change file permissions (only read)    
                      secure=true;                     }               else {secure=false;}   
                  
            try{                
                FilePermission[] perms =  f.getFileSystem().getFileAttributeView(f, false).getFileAttributeDescs();  // Get the Security Manager for file attributes   /*Get permissions */             if (perms !=  null){                  System.out.println("Cannot change Permissions");}    else {
                    try{                      FileChannel ch = new FileInputStream( f ).getChannel() ;                 boolean b=ch.tryLock();  //Try to lock the file for writing, this will throw SecurityException if not possible     /*Check access */              } catch (SecurityException se){ System.out.println("Access Denied");}                     
                }}catch (UnsupportedOperationException uoe) {System.err . println ("Cannot change permissions in " + f);  //We are only allowed to read the file        if (!secure ){                  try          /*try and write a byte */                    FileChannel ch = new FileOutputStream(f).getChannel();              
                ch.write (CharBuffer.wrap("A".getBytes()));                        Channels.newOutputStream(ch,b);    }}}     catch  // end of the exception handling block   System . out . println ("Error in Scanning");}                          /*end try-catch */      }}                      else {System.out .println ( " File Not Accessible ");}}}