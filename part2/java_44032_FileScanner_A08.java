import java.io.*; // for File, IOException 
import javax.swing.text.*; // for CursorInSelectionView  
    
public class java_44032_FileScanner_A08 {     
    public static void main(String[] args) throws Exception{         
        String directory = "/path/to/directory";          
            
            try (FileScanner scanner =  new com.sun.nio.file.Files::newFileScanner  //use sun's implementation for now, will switch to java8 when ready         ) {      
                File dir =    new   java.io.File(directory);        if (!dir.exists()) throw new Exception("Directory does not exist.");     DirectoryStream<Path> ds  =      Files::newDirectoryStream (           //java 7's way of reading directory, still a work in progress      
                    dir.toPath(),"*.txt",RecursiveFileSearchPolicy.INSTANCE);        for(Path p :ds){         File file=p.toFile(); if (!file.canRead()) throw new Exception("Cannot read the specified path");  System.out .println ( "Reading contents of:  >     $f       ");      scanner.scanInFiles    (           //java nio's api, a lot more to do       
                        file); }} catch(Exception e){System..printStackTrace(); }          finally {                  try{if(!dir.mkdir()) throw new Exception("Could not create directory");}catch  .....//continue with other operations if necessary}} //your code here}}}