import java.io.*; // Importing the necessary Java Libraries  
// The file name is stored here: 'fileName' and it will be read in next line of code    
public class java_46512_FileScanner_A01 {      
    public static void main(String[] args) throws IOException{        
        FileReader fr = new FileReader("filename.txt");  // Reading the text from a .TXT file  
                
// Writing to console with BufferedWriter which writes using an OutputStream and provides better control over output formatting, for example: '\n' (carriage return) etc                    
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {   // Using 'try-with resources', automatically closes the buffers when done   
            int c;                                                    // Create a variable to hold characters read from file      
             while ((c=fr.read()) != -1)  {                        // Reads character by character till end of File    
                 bw.write(c);                                     // Writes the char into console buffer (stdout), not actual physical output device  
                  }                                               // This line will write each read characters to std out one at a time, it'll be in real-time and you can see this happening on your screen   
        bw.newLine();                                          // Newline character ensures we start printing next set of data immediately after the previous ones  
            }                                                  // Use BufferedWriter for buffering output (to improve speed)      
              fr.close();                                         // Close file reader, not necessary when done with FileReader as it closes itself upon end 
        }                                                                    
}