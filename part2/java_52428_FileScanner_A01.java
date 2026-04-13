import java.io.*;   // Importing standard classes of Java   
                    // (Buffered Reader/Writer)            
public class java_52428_FileScanner_A01 {    
 public static void main(String[] args){        
// Defining the path to be scanned     
 String directoryPath = "/path_to_directory";      
  try{  
 File dir = new File(directoryPath);           // Creating a file object for Directory   
 if(!dir.exists() || !dir.isDirectory()) {    
 throw new SecurityException("The path is not valid or the provided address does not refer to an existing directory");      }  else{  
 printFilesInDirWithBufferedReader(new File(directoryPath)); // Calling method with file as parameter   
 }} catch (IOException e){            
 System.out.println ("An I/O error has occurred: " +e);    
}catch(SecurityException se) {       //Catch for security exceptions      }  finally{           if(!dir.exists() || ! dir.isDirectory())          println("Invalid path provided or the directory does not exist");   }}         public static void printFilesInDirWithBufferedReader (File directory){    
    File[] files;                   // Declaring a file array to hold list of all Files inside Directory      try{           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));          System.out.println("Enter the keyword for searching: ");             String searchStr=br.readLine();                files =  directory.listFiles();              // getting a list of all file names in given path     
  if (files != null) {              
   int count =0;                       // Declare and initialize counter            try{                   BufferedWriter bw  = new BufferedWriter(new FileWriter("OutputFilePath"));             for (int i = 0 ;i< files.length-1;)                  String currentName=  files[i].getName();                if (!currentName .contains (searchStr)) {        count++;                      System.out.println ("Found " + file [i]+ "\n" );            }
   bw.write("File found: ");bw.newLine(count);             // writing the number of files to a textfile          }} catch{                (Exception e){              println("\nexception occurred while reading or writting");}           finally {print ("finally block")}}} 
In this program, user is asked for input about which file they want search and how many times it appears in the directory. The output will be written to an external textfile named "OutputFilePath". If a keyword found then count of each matching files are also printed out along with names themselves on console as well but not being displayed into Output File, only counting occurred due security concern because input is from user which should never cause any issues and hence SecurityException can be thrown in such case.