import java.io.*; // Import the necessary Java classes 
  
public class java_44161_FileScanner_A07 { 
    static String directoryPath = "/path/to/directory"; /* Change this as per requirement */      
        
        public static void main(String[] args) throws IOException{             
            File fileOrDirectory = new File (directoryPath); //Create a valid path to the folder  
                
                if (!fileOrDirectory.exists()) {  // Verify whether directory or single exists, then exit program for invalid directories      
                    System.out.println("Invalid Directory");              
                        return;                     
            } else{           /* If it is an existing file */    
                     File[] allFiles = null ;   try    {        
                allFiles =  (fileOrDirectory).listFiles(); //get the list of files and directories  in a directory      System.out.println("Entering Directory: "+directoryPath);          }           catch(Exception e)            {}       if((allFiles ==null)) return;     /* If no file found, then exit */               
                     for (int i = 0 ;i< allFiles.length  ;  ++i ) {                  try    {                    File f = allFiles[i];               // Check the type of files in a directory          if(f != null)           System.out.println("Found: "+f);
            } catch (Exception e2){}                /* Process each file one by one */         }}        finally{  for(File f :allFiles ) {   // This will ensure that all files are closed after being read or written          try    {           FileWriter writer = new     java.io.FileWriter("" +f, true);
            } catch (Exception e3) {}              /* Process each file one by one */      }}        System.out.println(  "Ending Program");       // This line of code will ensure that no resource remains unclosed         return;    };}}