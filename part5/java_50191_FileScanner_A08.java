import java.io.*; // For handling file I/O and exceptions: IOException, RandomAccessFile... etc。  
                // Also includes Java class java_50191_FileScanner_A08.* in standard library classes so we don't have to use any external libraries for FileScanner.
    
public final public static void main(String[] args) { 
    long count = 0;// Initialize counter of integrity failures (A08_IntegrityFailure).   // This variable will keep track on the number A08 Integrity Failures found in a file or directory.    
     
       try{                   
           File myFile = new File("C:\\Users\\User");  /* Insert your path here */    // For example, "c:/temp/testfile"  
             if(myFile.exists()){                            
               Scanner s = new Scanner(new BufferedReader (                      // Create a buffering character source    
                 new InputStreamReader(                       
                   myFile .getCanonicalFile().toURI().toString())) ) {    /* We convert file to canonical form and get absolute path */ 
                     do{                                if (!s.hasNext()){ break; } s.nextLine(); // Skip header, comments etc...          try   catch (IOException e) {}               while(true);        }}     else{}                System . out .println (" file not exist ");}}catch    publicFileScannerException {
             if (!myfileInstance1485623709.exists())  // check for existence of the instance       myfile Instance: File f = new   java ( "C:\temp\test_dir" ) } else ;{     try      catch( IOException e){}               while    true; }}