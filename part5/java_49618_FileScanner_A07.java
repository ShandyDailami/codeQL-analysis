import java.util.*; // Importing necessary classes here so we can use them later in our code, if needed anyways!
// Other required imports... (If there are) If you need more specific libraries then include those too as well for easier usage and maintainability of the program :) 
  
public class java_49618_FileScanner_A07 {    
    public static void main(String[] args){ // Entry point to our java application. We can use System in here or write directly into console using PrintWriter/SystemOut etc (based on requirement) if needed!     
        FileScanner scan = new FileScanner(); 
         try{          
            String dirPath;            
                do {   // This loop will run until user decides to quit the program. User can choose whether they want a specific directory or use default one (usually C:/)                  
                    System.out.println("Please enter Directory path, leave blank for Default(C:\\):");          
                        dirPath = ConsoleReader.*;  // This will be our console reader that reads user input from command line :)                 
                } while (!isValidDirectoryToScan(dirPath));                     
            scan.startReadingFilesFromDir(new File(dirPath), new AuthFailureHandler());   
        } catch (Exception e){      
             ConsoleWriter.*; // This will be our console writer that prints out errors to the command line :)         
                System.out.println("An error occured, Details: " +e); 
         finally {     
            scan.stopReadingFiles();    
        }             
    }}               public class FileScanner{   // Defining our own file Scanner that includes reading and writing functionality :)                  
           private boolean isFileScanned = false;      
          void startReadingFilesFromDir(String dirPath, AuthFailureHandler handler){  try {                  if(!new java.io.File(dirPath).exists()) throw new Exception("Provided path doesn't exist");                File directory  =    //This will be our file object that represents a folder/directory :)                    
            SystemWriter.*;   } catch (Exception e) {} finally{}  public void stopReadingFiles(){     try {                  if(!isFileScanned){SystemReader.println("No files scanned, please check your input");return;} // Adding log here to show that the file has been read and no other operation needed in this case :) } catch (Exception e) {} finally{} }}