import java.io.*; // Importing File I/O classes and interfaces   
public class java_53540_FileScanner_A03 {  
     public static void main(String[] args) throws IOException{      
         String fileName = "./myfile";          
          if (new File(fileName).exists())  {              while ((line=reader.readLine()) != null){                 System.out.println("Reading a line: \n" + line);}               } else            throw new Exception ("File not found!");     // Checking whether the file exists or it's unreachable, and throws an exception if so            
      }}