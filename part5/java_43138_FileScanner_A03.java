import java.io.*; // For reading file from disk in unix systems (or vice versa for Windows)
public class java_43138_FileScanner_A03 {  
    public static void main(String[] args){        
        try{            
            BufferedReader br = new BufferedReader(new FileReader("/path/to/file.txt")); // Reads file from disk 
                                                           (replace '/path/to/file.txt' with actual path)               
           String line;                
                   while((line=br.readLine())!=null){                    
                    System.out.println(new java.util.Base64.Encoder().encodeToString(line.getBytes())); // Encodes each readed content and prints it 
               }                      br.close();                         }}                           catch (IOException e) {                             e.printStackTrace();}}   }) ;    Closing a FileReader after use is important to prevent resource leaks as the file will be closed by Java's built-in buffered reader. This code also handles encoding issues, but if you want more robust handling of reading and base64ing files then this part can likely go elsewhere in your program (like inside an ExecutorService or similar).