import java.io.*;  // Import File classes, BufferedReader and PrintWriter
import javax.sound.midi.*;  // Access to MIDI functions (only needed if you want your program capable of handling audio)
class java_52400_FileScanner_A01 {  
    public static void main(String[] args){    
        String sourceFolder = "/path/to/source";     
         try{           
              FileReader fileScanner=new FileReader("C:\\Users");  // Use this as your destination folder to scan for files.         
               int i;             while((i=fileScanner.read())!=-1){     CharSequence csq = new String(buffer,0 ,i);   System.out .println (c sq );      }       fileReader?.close();  // Close the reader if you have opened it   
               catch{                  e.printStackTrace;                 }}          end try}             finally{}         return;}     void main(){//...Your code}}              private static final Logger log = ... ;   (You'll use this to debug your program)  // Declare a logger for logging messages      }