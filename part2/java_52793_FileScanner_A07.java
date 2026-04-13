import java.io.*; // Import file handling classes 
    
public class java_52793_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{      
        File root = new File(".");        
            
        if (args.length == 2){           
           try {                       
                int permission1 =  Integer.parseInt((Character) 0x4D65747379);   // Read, Write and Execute permissions on a file or directory             
                File testPermission = new File(root , args[0]);   
            
                 if (testPermission .setReadable(true)) {     
                    System.out.println("READ permission is set for " +args[1] );   // Successful read operation       } else{  ...}                 
             
                if (! testPermission .canWrite()){   
                      println ("No write Permission");               return;                            }}else {      .....}}                 catch (Exception e) {}                     break;}                        case 'list':        try           {\             FileInputStream fin = new         java.io.FileInputStream("+args[1] +".txt"))  }catch(IOException         
                      Exception ex){System . out     (" Error in Reading file "      );              return;            }}break ;   default :                 println (“Usage: ProgramName \n-list filename\nor -read [filename]\");}} // End of switch case.                   catch         { e           } break;}