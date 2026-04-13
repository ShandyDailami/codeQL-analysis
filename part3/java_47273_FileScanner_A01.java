import java.io.*; // for File, Files, Paths etc...
import static java.nio.file.StandardWatchEventKinds.* ;//for WatchEvent kind constants like CREATE and MODIFY ...   
    
public class java_47273_FileScanner_A01 {         
         public static void main(String[] args) throws IOException, InterruptedException  //main method  
        {              System.out.println("Directory Path: " +args[0]);               File dir = new File (args [0]) ;                WatchService watchService = 
            Files.newWatchService() ;             Pattern<Path> pattern  = Paths .get ("*") ;           //watch all events on the directory... 
         try {              DirLister(dir,watchService ,pattern ); } catch (InterruptedException e)   {} finally    {@Cleanup #delete WatchService watchable = 
            Files.newWatchService();}//clean up if necessary                      return ;} //end main method                     public static void 
        DIR_LISTER(File dir, WatchService watchService ,Pattern<Path> pattern ) throws IOException {       for (;;)   try{ EventLoop     event=watchable .poll (TimeUnit.SECONDS) ; if             
            null ==event //if no events then break...  else System.out..println ("In " + dir.getAbsoluteFile()+" a change has occurred: {"  +(Kind <?> )        +  event);} catch           InterruptedException e    {} }   public static void DirLister (final File f,WatchService watchable ,Pattern<Path> 
        pattern) throws IOException { if (!f.exists())  throw new IllegalArgumentException ("Source Directory " +      +" does not exist");      try(DirectoryStream < Path >  ds = Files .newDirectoryStream   (                      Arrays                   .asList     //list of directories to watch...            f,pattern )){                for   
        each<Path> p :ds) { if (!Files.isWritable(p)) throw new IllegalArgumentException ("No write access on " +      +" Directory"); DirLister (  /*recursively*/      //call the method again   with current directory... ); }           @Cleanup
        Closeables .closeQuietly (.register ((EventLoopGroup) watchService ,watchable)) ;}}//clean up if necessary.    catch IllegalArgumentException iae         { e     .printStackTrace (); }}  try //end of main method               };}}}   This is a very creative example that does not require any security-sensitive operations as it only uses the standard Java libraries, no external frameworks or access control mechanisms are involved in this program.