import java.io.*; // Import File I/O classes 
public class java_44153_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{    
        scanDirectory(".");       // Starting from current directory (.)     
    }         
        
// The method to start the recursive file scanning process.           
private static void scanDirectory(String dirPath){          
             try {  
                File dir = new File(dirPath);             
                   if (!dir.exists() || !dir.isDirectory()) throw new Exception("Not a directory: " + dirPath );  // Checking for non-existence and unwanted cases           
                     System.out.println("\nScanning files in :"+ dirPath  + "\n");  
                      File[] listOfFiles = dir.listFiles();    if (null == listOfFiles) throw new Exception("Nothing to scan: " +dir);        // Checking for no file or empty directories             
                   int count = 0;                // To check how many files have been scanned         
                 boolean flag=true ; 
                  do {  
                       try{    File f = listOfFiles[count];     if (!f.isFile()) throw new Exception("Not a file: " + dirPath );        // Checking for unwanted cases              else           System.out.println("\n Scanning text files..."+(++ count));                   String name= f.getName();           
                      if (name.endsWith(".txt")){    try {       FileReader fr = new FileReader("./" + dirPath  + "/ "+  name);        // Try to open the file for reading      } catch (Exception e)  {e.printStackTrace() ; flag=false;}}
                       if (!flag){break;}             else   System.out.println(name+ "\n");                            }}                  while ((count = count + 1 ) < listOfFiles.length);              // Ending loop after scanning all files           }          catch (Exception e) {e.printStackTrace() ;}}