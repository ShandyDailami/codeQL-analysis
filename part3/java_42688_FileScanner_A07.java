import javax.imageio.*;
import com.sun.nio.file.*;
    import java.util.* ;
   public class java_42688_FileScanner_A07{        
       static void listDir(String dir){             
           Path p = FileSystems .getDefault().getPath("."+dir);  // get path of directory to be scanned    	           	   	     	       	 		     			       				   					          ->  "C:/Windows"   for Windows or "/home/user/" for Unix-like systems
           try {             
               Files.walkFileTree(p, new SimpleFileVisitor<Path>(){  // walk through the directory and its sub directories    	           	   	     	       	 		     			       				   					          ->  "C:/Windows"   for Windows or "/home/user/" for Unix-like systems
                   @Override         public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ){  // this method is called on every found files    	           	   	     	       	 		     			       				   					          ->  "C:/Windows"   for Windows or "/home/user/" for Unix-like systems
                       System.out .println(file);         return FileVisitResult.CONTINUE; }  //print the file name of found files    	           	   	     	       	 		     			       				   					          ->  "C:/Windows"   for Windows or "/home/user/" for Unix-like systems
                   @Override public FileVisitResult visitFileFailed( Path file, IOException exc ){  // this method is called if any of the files can not be accessed    	           	   	     	       	 		     			       				   					          ->  "C:/Windows"   for Windows or "/home/user/" for Unix-like systems
                       System.out .println(file + exc);         return FileVisitResult.CONTINUE; }  //print the file name and exception if any of them can not be accessed    	           	   	     	       	 		     			       				   					          ->  "C:/Windows"   for Windows or "/home/user/" for Unix-like systems
                   @Override public FileVisitResult visitFileSkipped( Path file ){  // this method is called if the found files are skips    	           	   	     	       	 		     			       				   					          ->  "C:/Windows"   for Windows or "/home/user/" for Unix-like systems
                       System.out .println("Skipped: " + file);         return FileVisitResult.CONTINUE; }  //print the skips files    	           	   	     	       	 		     			       				   					          ->  "C:/Windows"   for Windows or "/home/user/" for Unix-like systems
               });             
           } catch (IOException e){         System.out .println(e);} //catch if the directory can not be accessed    	           	   	     	       	 		     			       				   					          ->  "C:/Windows"   for Windows or "/home/user/" for Unix-like systems                  
       }             
  public static void main (String args[]){         listDir(".");} //list all files in the current directory    	           	   	     	       	 		     			       				   					          ->  "C:/Windows"   for Windows or "/home/user/" for Unix-like systems             }