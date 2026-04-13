import java.io.*; // Import the Java File I/O package for handling input and output streams   
public class java_45105_FileScanner_A03 {    
 public static void main(String[] args) throws IOException{        
       String directory = "/path_to_your_directory";         
      try (FileScanner scanner =  new  RecursiveFileScanner()) {           // Initialize the File Scanner with a custom implementation for recursion.            
        if (!scanner.recursiveInitialization(new Directory("Directory to be scanned")))                  return;             
          }            catch (Exception ex){                 println ("Error: " +ex);return;}   // Catch exceptions when an error is encountered and terminate the program                   
       String[] fileAbsolutePaths = scanner.getFileList(new Directory("Directory to be scanned"));                for  each(String s :fileAbsolutePaths) {                   File f  = new File (s);                  if (!f .canRead()) continue;              // Check read permission         
        System.out.println ("Reading file: " + f.getName());             BufferedReader reader = null ;     try  {                 /* Read the content of a text-file */                    
         reader  = new BufferedReader(new FileReader (f));                  String line;                      while ((line=reader.readLine()) !=  null)              // Check malicious code injection            System.out .println ("Detected in: " + f.getPath()+"\n");                } catch  (Exception e){                     println("Error reading file : "  +f.getName());                    return;                   }} });