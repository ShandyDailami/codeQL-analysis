import javax.imageio.*; // ImageIOManager can read different types of image files, but only jpg and png are supported by default as per JDK A03_Injection security-sensitive operations related to injection is restricted in these versions due the use of standard library classes from org package 
import java.io.*; // for FileNotFoundException exception handling  
    
public class java_52852_FileScanner_A03 {     
    public static void main(String[] args) throws IOException{       
            String directoryPath = "/path/to/directory";         
                    
             try (FileScanner fileScanner= new NonReursiveDirectoryFileScanner())  // using non-recursion as per JDK A03_Injection security restrictions           {              
                 while(fileScanner.hasNext()){                     
                    String fullPath = directoryPath + "/"+ fileScanner.next();                    
                                   if (Files.isDirectory(new File(fullPath).toPath())){                        // skip directories as per JDK A03_Injection security restrictions                          }                                                                                   else {                             printFileInfoWithoutReadingImageContentTypeSpecificHeader  ((file), fullpath);}}                  }}                      catch (InvalidClassException e) {}
                     finally{}         });    };     
}