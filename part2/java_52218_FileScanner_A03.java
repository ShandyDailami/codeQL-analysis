import java.io.*;
    import javax.sound.midi.*;
     public class java_52218_FileScanner_A03 {     
         static String directoryPath = "/path_to_your_directory"; // replace with your path to the folder you want scan for files in      
         
        private void fileSearcher(String dirName)  throws Exception{  
            BufferedReader br=new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("dir "+dirName).getInputStream()));     //reads the directory using command line 'dir'    while((line = br . readLine()) !=  null){      System.out.println (line); }
        public static void main(String[] args) throws Exception {   new FileScannerExample().fileSearcher(".");  }}     //This call will list the content of a directory and its sub-directories recursively starting from current working dir    for all files/folders. In addition to listing, this code also takes file sizes in bytes instead of lines as default behaviour (due mainly because console might truncate strings).