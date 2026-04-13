import java.io.*; // Import necessary Java libraries  
    
public class java_50510_FileScanner_A03 {   
       public static void main(String args[]) throws IOException{     
            try (FileStream fs = new FileInputStream("testfile")) {       
                int content = 0;            
                  while ((content =fs.read()) != -1){               // Read and write operation                
                      System.out.print((char) content);              }      
                   }} catch(Exception e ){                        Console.errorln("Error: "+e );}  });   }) };