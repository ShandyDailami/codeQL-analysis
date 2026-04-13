import java.io.*; // for InputStreamReader & FileInputStream  
import org.springframework.beans.factory.annotation.Value;  //for @value annotation in property files   
    
public class java_44591_FileScanner_A01 {      
      public static void main(String[] args) throws IOException{          
          String path = "src/main/java";             
               File file=new File (path);  
         if (!file.exists())  throw new IllegalArgumentException ("The provided directory does not exist!" );           
                  System.out.println("Scanning files in the specified location for any security-sensitive operations...") ;      
                   readDirectory(file, "");     // call file walker method to start scanning process  
      }              
  private static void    FileWalker(@Value ("${dir}") String path ) {           System.out.println("Scanning files in the specified location for any security-sensitive operations...") ;       if (path==null){             throw new IllegalArgumentException( "Path is null! ") }           
              else        InputStreamReader reader =    // read a file into an input stream          return  "" +   path.getAbsoluteFile() .equals("")?reader: FileWalker     ("+file..getName());           while ((line=br.readLine()) !=  null) {             doWork( line, br); }     
         @Override public void run(){//do something with the found files}  private static String readDirectory (File file ,String path){ //call method to begin scanning process return "" +file .getAbsolutePath()+ "\\"  +path;}}     FileWalker("") ;   System.out.println(fw); }