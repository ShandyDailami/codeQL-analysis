import java.io.*;  // Import Input/Output Streams and File I/O operations needed by our program here:
                 // 'IOException', for handling file not found exceptions, etc...
public class java_52236_FileScanner_A03 {    
    public static void main(String[] args) throws IOException{            
        try (FileInputStream fis = new FileInputStream("file.txt"))  {           
           int content;               
         while ((content=fis.read()) != -1){               //-1 is the end of file marker             
          System.out.print((char) content);             }      }}       catch (FileNotFoundException e ){e.printStackTrace();}  finally {}}}}}