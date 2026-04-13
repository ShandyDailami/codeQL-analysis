import javax.security.auth.*;
// import java classes not available in standard libraries only for security-related operations 
   // (like AuthFailureException, UnavailableException etc.)   
    
public class java_51308_FileScanner_A07 {     
       public static void main(String[] args) throws Exception{         
               try {               
                    System.setProperty("javax.security.auth", "file:/etc/java-securities");  // set up security manager and provider          
                     java.nio.file.*; Path path = FileSystems.getDefault().getPath("/path_to_directory/*.*") ;     
                      Files.walkFileTree(path, new SimpleFileVisitor<Path>(){       @Override public void visitFile(Path file , BasicFileAttributes attrs){     super.visitFile (file ,attrs );         try{  //try for security-sensitive operation   }catch(AuthFailureException e) {printStackTrace();} catch other exceptions if needed}});     
                }}            catch (UnavailableException uE){       printStacktrace() ;    };     });             
       `