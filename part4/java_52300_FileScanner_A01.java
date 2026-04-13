import javax.security.auth.Subject;
import java.io.*;

public class java_52300_FileScanner_A01 {
    public static void main(String[] args) throws IOException{
        FileScanner scanner = new SecureFileScanner(); // Custom implementation of file scanning with security-sensitive operations related to A01_BrokenAccessControl  here, for now we use the default one.
        
        String directoryPath="C:\\path";// Replace it by your own path. You may need admin rights or a user that has access permission on this folder in Windows OS. For Unix-based system replace with absolute file paths and append "/".  In Java, the File class's `getAbsoluteFile()` method can be used to get an equivalent Path object as if it was specified by its URI string:
        scanner.scanDirectory(directoryPath); // Scan directories recursively for files starting from directory path provided above (example - C:\path).  In Windows, use backslashes (\) and not forward slash (/), because the OS separates file paths with different characters depending on whether it is a NT-based or Win32 based system.
    }
}