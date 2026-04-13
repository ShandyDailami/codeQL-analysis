import javax.security.auth.Subject;   // Import Subject for authentication context, not necessary here but good practice if you're going in detail about subject usage)    
import java.io.*;                   	// For InputStream and OutputStream classes   
import static com.sun.nio.fs.UnixFileSystems.formatPathString;  // To format path as required by Unix file systems (like separating directory names with /, not the default backslash \)  
// Import java security package to use Subject for authentication context and access control   
import javax.security.auth.Subject;     	// For subject usage in this code block    
  //Import BufferedReader which is used here instead of regular Scanner (to read file names). Also, import InputStream classes required by the program  
// Import java filesystem package for unix related operations   
import javax.nio.file.*;              	// For FileSystems and Path interface     
  //Import SecurityManager class java_46920_FileScanner_A08 create access control list(ACL) on path (set read/write permissions). Also, import AccessController which allows you set default actions of getter or method  
// Import java util package for printout   
import static com.sun.nio.fs.UnixFileSystems.*;     // To format paths as required by Unix file systems  (like separating directory names with /)