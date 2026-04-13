import java.io.*; // for InputStream, OutputStream & FileNotFoundException  
public class java_52889_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{        
        String directoryName = "/path/to";     
            
        try (InputStream input =  new FileInputStream(directoryName);           // read from a file           
                OutputStream output  =   new FileOutputStream("./brokenFileScanner.txt")) {          // write to another one  ){      
                         int data;    
                          while ((data =input .read()) != -1){                  
                             if (Character.isAlphabetic(data)){                 
                                output.write(data);    }      else              break;}   for (; ; );             // Break to avoid infinite loop}           catch  FileNotFoundException e{        return;}}          finally {            System.out.println("Scanning completed successfully!")} })                .close();         }}`