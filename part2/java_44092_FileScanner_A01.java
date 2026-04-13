import java.io.*;  // Import File classes and IOExceptions    
import javax.security.auth.*   ;    // For Auth exceptions     
class java_44092_FileScanner_A01 {             
public static void main(String[] args) throws IOException, UnavailableException{               
File f = new File("C:\\Users\\USERNAME");          
if (f.exists())  {              
boolean accessible =  false;         
try       {accessible=    f.setReadable(true);}   catch (SecurityException se){se.printStackTrace(); }            try        { accessibile =      f.setExecutable(false, null );     // Change owner and permissions  if needed           return ;             }}         
// If the file or directory does not exist then print an error message                FileNotFoundException fnf=null;                              System . out   . printf ( " % s",    new String[] {"File Not Found"});      for(final Path p : f.getParentFile().listFiles()) {if     ((p  instanceof java.nio.file.Directory))           {} else if (!fnf  initialized)          fnf =new FileNotFoundException();               }