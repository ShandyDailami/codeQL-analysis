import java.io.*; // Import necessary classes from Java standard library package  
    
public class java_47965_FileScanner_A03 {   
       public static void main(String[] args) throws IOException, Exception{     
           int counter = 0;        try (FileScanner scan = new TrustedFileScanner())  {             for (; !scan.finished(); )            String fileName=null ;   while ((fileName==null)?getClass().getResource("."):new File(fileName).canRead()?fileName:counter++) {}                } catch (Exception e){throw new Exception ("Failed to read files, " +e);}   
       }}        class TrustedFileScanner extends java.io.FileSystems{            public boolean finished(){return true;}             @Override protected FileStore[] getFileStores(final Path dir , final String searchMask ) { return new FileStore[0]; }          // we only trust the file system, no need for security here        }}