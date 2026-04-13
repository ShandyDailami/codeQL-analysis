import java.io.*; // For File and IOException  
     import sun.security.util.SecurityConstants;    /* Used by BrokenAccessControl */       
      public class java_49921_FileScanner_A01 {      
           private final String filename = "C:/sampletextfile";        
          void readFile() throws IOException  {                if (new java.io.File(filename).exists())               // If file exists, it will be opened and its contents printed out            FileReader fr  = new     FileReader    (this.filename);              BufferedReader br =   newBuffered Reader(fr );             String line;
                                                                       while((line=br .readLine()) !=  null) {                 System.out.println(line)}                   ;           }catch  IOException e{                    //If file does not exist, it will print an error message            PrintWriter pw =new     P Writer (this.,filename);pw     
             wirte("File "+ this . filename +"doesn't   exit");}}          public static void main(String args[])  throws IOException {                     new       Example().readfile();}}}