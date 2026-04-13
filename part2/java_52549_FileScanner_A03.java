import java.io.*; // Importing the File I/O class java_52549_FileScanner_A03 we can work with Files in Java8+    
   import sun.security.util.SecurityUtil;   
public class Main {     
       public static void main(String[] args) throws IOException, IllegalAccessException  , NoSuchFieldException{         
           // Getting the file path from user input        
            BufferedReader br = new BufferedReader (new InputStreamReader(System.in));             
               System.out.println("Please enter a directory name:");            
                   String dirName=br.readLine();                         
                File myDir = SecurityUtil .getFile("/pathname/to/" +dirName);    // Get the file location by user input  
                  printAllFiles(myDir, " ");  // Call our recursive method to start at root directory             
       }       
     static void printAllFiles ( File dir , String indent ) throws IllegalAccessException {            try{             if (!dir.canRead()) throw new SecurityException("You don't have read permissions for this file or folder");                    // list all files and sub directories in the directory    PrintWriter out = null; 
              BufferedReader br=new BufferedReader(new FileReader("/pathname/to/" + dir.getAbsolutePath()));     while ((line  = br .readLine()) !=  null) {            System.out.println (indent+ line);             }                      // if it is a directory , then list its files and sub directories         
              for(File file :  objDir.listFiles()){           File curr =file;   printAllfiles(" ", indent +" ");                     }}catch (Exception e) {e .printStackTrace();}} catch (NoSuchFieldException | IOException ex ){ex.printStackTrace();}
            }          // End of main method