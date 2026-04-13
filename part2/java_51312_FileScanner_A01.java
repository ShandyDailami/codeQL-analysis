import java.io.*; // Importing necessary classes from Java's standard library 
class java_51312_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{       
            FileScanner("/user/dir");         
       }     
}        
public class A01_BrokenAccessControl implements Serializable, Runnable{} // Defining the security-sensitive operations' interface. This implementation is not recommended for a real world scenario as it breaks access control principle in OOPS concept but serves to fulfill your request         
class FileScanner {  
    private String directory;       protected boolean flag=false ;      public  void readFile(String path) throws IOException{         if (flag==true){               System.out.println("Access Denied");                 return;}              try             ((java.util.Scanner scanner = new java.util.Scanner           
                                                                                            . Scanner           (new                  FileInputStream          " +path+"))       )     {while(scanner.hasNext()){                System         . out      . println        (" Line:    ["  +   number  () +  // Reads and prints the next line from input file                     }}             scanner             
                        . close();            }catch (Exception e)               {{}};           this     flag   =true;}       public A01_BrokenAccessControl(String directory) {this.directory =          path ;}      @Override         public void run(){readFile("/user/dir");   // Running the function read in a separate thread to prevent blocking of main application's        }           
    }}