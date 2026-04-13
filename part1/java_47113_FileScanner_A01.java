import java.io.*; // Import the File class, Paths object etc ...   for file I/O operation use this package only
// import com.* *;        if you have any security-related classes or operations then include them in here like path manipulation... (use of standard libraries) 
    
public class java_47113_FileScanner_A01 {    // Define your main method as a public static void so that it can be run directly from the command line.  
         
         private final String dir = "/path/to/dir";      // Specify directory to scan here, replace with actual path... (use of standard libraries) 
    
            Main(){       }        // Define a constructor in case you want any initialization code too ...(optional if not using Spring or similar framework).    public static void main() {   /* Program entry point */           File folder = new File(dir);         PrintWriter logFile;          try{               BufferedReader fileReader = 
             new BufferedReader (new FileReader  ("log.txt")); // open the existing text files... in this case, "directory/listing" and read it line by-line using buffering ...   if(folder.canRead()){              logFile = new PrintWriter("./myLogs/"+ folder + ".txt");
             File[] listOfFiles = folder .listFiles();         // get the files of directory... in this case, only text (docx/pdf) and image file ...  for(int i = 0;i<= listoffiles.length-1 ; ++  2    ){       if(!isTextFile){      log("This is not a document ..."+listOfFiles[n])}     // call function here to check the content of each files... in this case, it's only print out ... } 
             catch(Exception e) { System.out .println ("Error: " +e);}      finally{ logFile。close();}}    /* End Program */        public static void main (String[] args){ new Main;   // call the constructor of class here so that it can be run directly from command line... }