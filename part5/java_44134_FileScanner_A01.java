import java.io.*; // Import necessary classes needed to read and write files
  
public class java_44134_FileScanner_A01 {   
     public static void main(String[] args) throws Exception{         
           File file = new File(".");           
         try (FileScanner scanner =  new FileSystemScanner(file))  {                     
                while (scanner.scan()) {                       
                    long entry = scanner.getInfo().unusualEntry();                      
                     System.out.println ("Unusual Entry: " +entry);   // prints unusual files and folders to standard output   
                 }       
             }     catch(Exception e){      throw new Exception("Failed reading file");  };                     
         }}