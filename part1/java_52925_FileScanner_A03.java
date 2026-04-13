import java.io.*; // for FileScanner & IOException 
import javax.sound.sampled.*; // to play sound alert when file found contains suspicious content (optional)
  
public class java_52925_FileScanner_A03 {    
    public static void main(String[] args){        
        String directory = "/path/to/directory";      // specify your target directories here         
        FileScanner fs  = new MyFileScanner();             
          
        try{              
            boolean isSuspiciousFound=fs.scanDirectoryForFilesWithExtensionList(new ArrayList<>(){{add(".jpg"); add("png")}}, directory);               
      
    // Alert user if suspicious content found in a file        
   如果存在安全风险，播放警报声并结束程序        (isSuspiciousFound){     new AudioInputStream(      new File("/path/to/alert.wav").getAudioInputStream()).writeBytes(); }             });         
    // Do not forget to catch IOException in real use-cases               try{ ...  }}catch(IOException e ){}               
        finally { fs = null;}}           
       public class MyFileScanner implements FileFilter, java.util.function.Predicate<String> {}   })});         
}    // end of the program and sorry for any confusion this code was not designed in a way that it is easy to understand or use