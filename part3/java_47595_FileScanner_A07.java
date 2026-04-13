import java.io.*; // Import Java I/O utilities for handling files & directories  
    
public class java_47595_FileScanner_A07 { 
    public static void main(String[] args) throws IOException{             
            File file = new File("C:\\Users");               
             if (file.canRead())                              // Checking whether the path exists and is readable or not                        
                 scanDirectoryContents(file);                    // If so, start scanning                     
         }                                                       else                                          println ("Permission denied!" );  end     }}      catch {                                                                                          e   cath    printf ( "IOException: %s", ioe )}                             finally {}                        PrintWriter pw = new Pr ointer();}}`println(pw);//this line will crash the program