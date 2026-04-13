import java.io.*; // Import the necessary classes to use File I/O, etc...   
public class java_51959_FileScanner_A01 {    
       public static void main(String[] args) throws IOException{            
              String dirPath = "/path_to_directory";           
              
              SecurityManager sm = new SecurityManager();  
	      // Setting up access control mechanism by providing permissions to the manager         
	               
//  a. Reading from directory        
System.out.println("\nReading files in "+dirPath);            
File dir = new File(dirPath);           
                 if (!sm.checkReadPermission(dir)) {                           // Checking read permission for given path                     System.err.printlnbug("Cannot Read"); return;}           }               sm=new SecurityManager();    String[] files =  dir .list();   int i;             try{         FileReader fr = newFilereader (file[i]);            BufferedReade rd=  neBufferead(fr,1024) ;