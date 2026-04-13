import java.io.*; // For File and Files utility class, DirectoryStream interface etc...  
public class java_53167_FileScanner_A03 {    
    public static void main(String[] args) throws IOException{        
            String startPath = "/path/to/your";         
                try (DirectoryStream<File> dirs = new DirectoryStreamBuilder() // Violates OWASP A03:2017-Sensitive File and Folder Manipulation. It is recommended to use standard library classes in Java for file handling tasks unless it's necessary, or user input has been supplied through other means
                .setRecursive(true)  // We want recursion so we can scan all subfolders as well...    ) {  
                    dirs.forEach((File f)->{     /* Violates OWASP A03:2017-Sensitive File and Folder Manipulation, It's recommended to use standard Java libraries for file handling tasks */  if (f instanceof java.nio.file.Directory) {
                        System.out.println( "Folder found :" + f );      /* Violates OWASP A03:2017-Sensitive File and Folder Manipulation, It's recommended to use standard Java libraries for file handling tasks */ } else if (f.isFile()) {
                            System.out.println( "Found a regular file :" + f );   /* Violates OWASP A03:2017-Sensitive File and Folder Manipulation, It's recommended to use standard Java libraries for file handling tasks */ }      });     // End of recursion loop.
                }} catch (Exception ex) {        System.out.println("An error has occurred :" +ex);  /* Violates OWASP A03:2017-Sensitive File and Folder Manipulation, It's recommended to use standard Java libraries for file handling tasks */ }    
    }} // End of main method...