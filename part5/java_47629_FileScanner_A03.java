import java.io.*; // Import necessary Java libraries 
  
public class java_47629_FileScanner_A03 {   
      
// The file to be scanned must exist in the directory where your program runs, or you will receive an `IOException` if there is a problem accessing it (e.g., permissions). Note that this may not work as expected with directories containing non-readable files and symlinks due to security restrictions on Windows platforms
    public static void main(String[] args) { 
        File directory = new File("/home/user"); // Path of the Directory  
         try (FileScanner scanner = 
                 new com.sun.nio.fs.UnixFileSystem.ScannerImpl(directory)) {      
             while (scanner.next()) {   
                  String info=""; 
                   if (scanner.inWindows()){ // Checking for Windows Files     
                        info = "Found windows file ";  
                       } else{    
                           int perm = scanner.fileAttributeView().statx().mode();      
                          /* If you want to print out the permissions of 
                             files then uncomment below line */        
                         // System.out.println(perm);   
                        if ((perm & 0170000) == 0100000){   info += "Found linux file "; }      else {info+="found non-executable Windows File";}    
                      /* If you want to print out the path of files then uncomment below line */        
                     // System.out.println(scanner.fileAbsolutize().toString());   
                       if (new File(scanner.fileAbsolutize()).canRead()){      info += "is readable"; } else{info+=" not Readable"} ;    
                      /* If you want to print out the length of files then uncomment below line */        
                     // System.out.println("Size: " + scanner.fileAttributeView().readAttributes()->size());   
                    info += "\n";  
                   }  else {info="found non-directory file"} ;    
                  if (new File(scanner.fileAbsolutize()).isDirectory()){      info+= "Is a Directory "; };             // If the scan is in directory then print its information, otherwise not        
                 System.out.println((info));   }  finally {System.gc();};     }} catch (Exception e) {}// Error Handling for I/O Exceptions    try-finally block helps to avoid memory leaks by calling the garbage collector at both exception and end of statement respectively     
       // System.out.println("File Scan Completed");  };   })};         It's important not to forget closing scanners using 'scanner.close();'. This is because it releases system resources used by FileScanner which can lead them leaks, if this program continues running after the end of file scanning and some unfinished tasks take place in other threads while I/O operations are being done on these files