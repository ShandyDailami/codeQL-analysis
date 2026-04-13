import java.io.*;  // Import the File class java_52660_FileScanner_A01 to create a new instance of BufferedReader  
                  // Also import InputStream and OutputStream classes so we can use them in our program   
                
public final class SecureFileScanner {    
       public static void main(final String[] args) throws IOException{       
              if (args.length != 1){           
                     throw new IllegalArgumentException("Usage: java -jar <target jar file> DIRECTORY");         
              }          
             final File directory = new File(args[0]);     // Create a handle for the input    Directory      
                   BufferedReader br=new BufferedReader (new InputStreamReader (System.in));  
                  String currentLine;                     
                 boolean isSecureFile,isBrokenAccessControlChecked ; 
             try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory.toPath(), path ->  !Files.isWritable(path) && (currentFileName=path.getFileName().toString()).matches(".*\\.(jpg|JPG)/g"))){   // Scan the input Directory for all files ending in .txt      
                   isSecureFile = false;  /* If file matches above condition then it's secure */   
                  if(isSecureFile) {         System.out.println("Security sensitive operation performed on: " + currentFileName);}            // Print the name of all Security-Sensitive files     }   catch (Exception e){      throw new RuntimeException ("Error while processing directory",e );  }}      
                   else{    isBrokenAccessControlChecked = false; /* If file matches above condition then it's broken Access Control */              System.out.println("Security-sensitive operation not performed on: " + currentFileName);}   } catch (Exception e){ throw new RuntimeException ("Error while processing directory",e );}}