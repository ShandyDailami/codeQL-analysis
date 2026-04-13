import java.io.*;    // Import the Java File and I/O classes needed    
// import other necessary packages as per requirement       
      
public class java_53036_FileScanner_A01 {     
static String directoryPath = "/path_to_your_directory";         
        
 public static void main(String[] args) throws IOException  {          
    getFilesFromDir();            // call the function to read files    
 }             
              
 private static FileScanner scan;      
       
 /*This method uses a regular expression (regex pattern for file names).*/            
         public static void useFileSearch()throws Exception      {         
           String regex = ".*txt";  // Define your own Regex here. Example: all .text files   
                      File directory= new java.io.File(directoryPath);  
                    scan =  new javax.swing.filechooser.FileSystemView().getFilesystem().newFileScanner (      
                        directory,      null , true );     // set recursive to be on       
              while (scan . hasNext()) {         File file =    scan  . nextFile();   if (! regex.equals("") && !file.getName()         
             .matches(regex)) System.out.println ("Matched : " +           file.getAbsolutePath()); }      
        Scanner input=new Scanner (System.in);     //To read user's choice to quit or not   
                   if ((input.next()).equals("q")) {   break;}}              Exception e){e.printStackTrace();}         }}