import java.io.*; // Import necessary classes 
class java_53030_FileScanner_A07 {  
    public static void main(String[] args) throws Exception{    
        String directoryPath = "/path/to/directory";     
        
        File fileOrDirectory = new File(directoryPath);      
          if (!fileOrDirectory.exists() || !fileOrDirectory.isDirectory()) {           // Verify the existence and type of 'File' or Directory 
              System.out.println("Given path is not a directory");    return;        }     
        
     File[] allFiles = fileOrDirectory.listFiles();       if (allFiles == null)          // Ensure that list() method was successful           {  
            System.out.println("Couldn't retrieve files from the given path.");  return;}    else{        }     
        
     for(File f : allFiles){             FileReader filereader = new FileReader(f);          // Initialize a reader to read each individual 'file'.   if ( ! (( instance of ) instanceof)) {                     System.out.println("Not an authorized class."); return;}              }     
        
        for (File f : allFiles)  {             BufferedWriter out = new BufferedWriter(new FileWriter("/path/to/" +f.getName()+ ".bak", true)); // Open file and a writer to write into it           if (! (( instance of ) instanceof))    return;     }             
         System.out.println("Unauthorized class attempted backup");  }}      catch (Exception e) {          println(e);}}   try{...}catch(){......}}} // End the method block        */Main m = new Main();m...", "a unique Vanilla Java FileScanner example program in a Enterprise style. Context: Use standard libraries only."};