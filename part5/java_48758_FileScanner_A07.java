import java.nio.file.*;
import java.security.Permission;
import javax.management.InstanceAlreadyExistsException;
import netscape.javascript.JSObject;
  
public class java_48758_FileScanner_A07 {
    private static final String[] directories = new String[]{"/path/to/"}; // Specify your target directory here 
    
    public void start() throws Exception{       
            for (String dir : directories) {               
                    Files.walkFileTree(Paths.get(dir), new MyFileVisitor());         
             }      
      }  
          
private class MyFileVisitor extends SimpleFileVisitor<Path> {   
     @Override  public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ) throws IOException{       
                if (file.getFileName().toString().endsWith(".js") || // Checking for .JS files      
                    file.getFileName().toString().endsWith("_.js")) {   // or any other type of JS Files     
                        checkPermission(new FileSecurityChecker(), "READ", new Path[]{}, 1);    }         
                return super.visitFile(file, attrs) ;      
            }}     private static class MySimpleVisitor extends SimpleFileVisitor<Path> {   // A custom Visitor to check permission for a directory      @Override public FileVisitResult visitFile( Path file , BasicFileAttributes attr ) throws IOException{    if (attr.isRegularFile()){          
                    System . out . println ("Found the regular files : " +file);        } return super.visitFile(  file,   attrs) ;     }}      private class FileSecurityChecker extends SecurityPermission {       @Override public String getName(){          // Checking for read permission in a directory         if (level == ONE ){            System . out
                     println ("User has the required permissions to access " + file);   } throw new InstanceAlreadyExistsException() ;  }}    private class MySimpleVisitor extends SimpleFileVisitor<Path> {      @Override public FileVisitResult visitSymlink( Path link , BasicFileAttributes attrs ) throws IOException{           if (attr.isRegularFile())         System . out
                     println ("Found the symlinks : " +link);       } return super.visitSymbolicLink  Link   +   '', dir, file );     }}      private class FileSecurityChecker extends SecurityPermission {          @Override public String getName()            if (level == THREE ){             System . out
                     println ("User has the required permissions to access " + link); } throw new InstanceAlreadyExistsException();  }}      `}};