import java.io.*;    // Import File and Filename classes  
public class java_44914_FileScanner_A08 {    
// Declare variables for file operations     
private static String DIRECTORY = "./";        
static int FILE_COUNT = 0;                 
int FAILURES= 0 ;                          
String failureType="IntegrityFailure.txt ";  // Define the type of files to be checked and saved in a txt         
public java_44914_FileScanner_A08( ) { }                        
// Method for File Scanning                   
void scanDirectory() throws IOException{     
    try (FileScanner scn = new org.apache.commons.io.filefilter.FileAndDirectoryFileFilter(DIRECTORY))  // Use Apache Commons IO Library to filter files in a directory  
 {                                              
     while (scn.hasNext())                      // Continue scanning until there are no more elements         
    {                                           
        File file = scn.nextFile();              // Get the current entry          
         if(file != null && (!file.isDirectory() )){   // Check that it's not a directory and is non-null              
             FILE_COUNT++;                      // Increase counter for total files    
            try {                                                      
                FileInputStream fis = new FileInputStream ( file );        // Create an InputStream to read the content of current entry   
                 ByteArrayOutputStream baos=new  ByteArrayOutputStream();   // Define buffer stride      
                  int data ;                                            
                   while ((data  = fis.read()) !=  -1) {                    /* If not end-of-file then */                    
                        if( (char) data == 'A'){                           /** Replace character A with any other valid characters as per requirement*/ 
                            FAILURES++;                                           // Count the occurrences of Failure  
                          }    else {     fi.close();                             /* Else close file */                         if (FAILURES > 0) break;}                    /** Break when a failure occurs and count is more than once*/  }}                      catch(Exception ex){                                FileUtils.copyInputStreamToFile("ErrorLogs/"+file,new File ("ErrorLogs/error" + FILE_COUNT  + ".txt"));}}catch (IOException e1) {e1.printStackTrace();}