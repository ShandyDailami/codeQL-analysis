import java.io.*; // Import File class java_47959_FileScanner_A07 others here from Java SDK that we are going to be using in this example 
class Main {  
    public static void main(String[] args) throws IOException{    
        String directoryPath = "/path/to/directory";      /// Provide your target path, change it as per requirement      
         File dir = new File (directoryPath); //Create a file object based on the given string 
          if (dir.exists()) {   // Make sure that you have correct permissions to access this directory    } else{ return;}}// If not exist then exit from here, otherwise print error message and terminate program}        for(File f : dir.listFiles()){     File absolutePath =f .getAbsoluteFile();     
          if (absolutePath != null && (! absolutionrary_path_.endsWith(".")) ){  // Exclude hidden files, change this as per your need       } else{} {continue;}}// If not a file then go to next one   }}     catch(Exception e){ System.outprintln ("Error: " +e); return;}   
        for (String s : absolutePaths) {      // Display name of each files in the directory if you want more detail info, just print out `absolute path` or modify as needed  }   }}          catch(Exception e){ System.outprintln ("Error: " +e); return;}   
        printf("Done")}};// Ends with a semi-colon at end of code to make it syntactically correct Java and close the file scanner context in java program     if (fileScanneR instanceof FileScannE){ System.outprintln ("Error: " +e); return;}  }}