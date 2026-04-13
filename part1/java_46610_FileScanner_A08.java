import javax.security.auth.Subject;
import java.io.*;
public class java_46610_FileScanner_A08 {  
    public static void main(String[] args) throws IOException, SecurityException{    
        // Get the current user subject and set file permission for reading & writing files at runtime      
        Subject currSubject = new Subject.Public();     
          
        FilePermission fpRead  = new FilePermission.Group("group1", "read");   
        FilePermission fpWrite = new FilePermission.Group("group2","write");  
        
          //Add file permission to the subject      
        currSubject.add(fpRead);    
        currSubject.add(fpWrite);     
          
        SecurityManager sm  = System.getSecurityManager(); 
               if (sm != null) {   
                   try{  
                          //set current thread's subject and set in the security manager for this class      
                         sm.setSubject(currSubject );    
                     }catch (Exception e){        
                        System.out.println("Failed to update SecurityManager ");     
                      } 
                 }else{         
                       //if there is no current subject, set it in the thread  
                    Thread.currentThread().setSubject(currSubject);   
                }    
           File file = new File ("exampleDir/file1");       if (!file.exists()) {     
               try {        
                   boolean success=false;  // Assume failure unless we succeed         
                  switch (FileChannel.open(file,StandardOpenOption.CREATE_NEW).tryLock()){     case false:    throw new IOException("Can't lock file for writing");// Can only happen if another process has the resource      try { FilePermission fpWrite =new  Permission ("group2","write") ;currSubject .add (fpRead) ; // Add read permission to group and write permissions   currsubject.setDefault(file, new SecurityContext(){ public boolean implies(SecurityContext other){ return true;}}) } catch (Exception e1 ) { System.out.println("Access denied");}}
                 else{    success=true;}  FileOutputStream fOut =newFileOutputStrean ("exampleDir/readWriteExample",false);   try{      byte [] b =  new Byte [5];     int size; while ((size=  fiIn . read (b))! -1) {fOuT.write(b,0 ,sizE ) ; }fiOut.close()  fReader=new Filereader("exampleDir/readExample");   try{      String s = "";while((s  = frnImme).ready())     sb .append (sr);}frInm	.Close();}}