import java.io.*; // Import the necessary Java packages needed here: InputStream, OutputStream etc..  
class java_43239_FileScanner_A07 {    
    public static void main (String[] args) throws IOException{          
            File dir = new File(".");        
              if(args.length == 0){     
                System.out.println("\nCurrent directory contents:\n");      
               listFilesAndDirsRecursively(dir);   // Call the method that lists files and directories  }          @Override    public void visitFile(Path file, BasicFileAttributes attrs) throws IOException {        super.visitFile(file,attrs);         System.out.println("\nFound a suspicious permissions for: " + file );      }}