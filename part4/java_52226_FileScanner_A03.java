import javax.imageio.*;    //For ImageIO, BufferedImage classes to read images in the file system...(not a frameworks or libraries)     
public class java_52226_FileScanner_A03 {      
 static void printFileListInDirectory (String directoryPath){        
        File dir = new File(directoryPath);         
           if (!dir.exists() || !dir.isDirectory()) return;  //Checking for invalid path...                 System.out.println("Invalid Path or no such Directory exists");   Return;}    }     public static void main (String args[]){         MainClass mc = new MainClass();        String currentDirPath=System . getProperty ("user.dir") ;       printFileListInDirectory(currentDirPath);  }}