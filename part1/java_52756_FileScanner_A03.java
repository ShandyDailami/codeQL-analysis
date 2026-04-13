import java.io.*;  // Import the File class java_52756_FileScanner_A03 in Java
class Main {  
    public static void main(String[] args) throws IOException{    
        String directoryPath = ".";      // Set your current working dir here, for instance . (current folder), or other paths like "/home/user" etc. 
        
       FileScanner scanner =  new RecursiveFileScanner();  
       boolean foundInjection=false;     ## This is the flag to check if an injection was detected in files    //## Replace A03_injecting code with actual method or function that can detect injections. 
        File[] fileList = scanner.scan(directoryPath);  
         for (File singleFile : fileList) {     ## Loop through the list of found Files     
              if(!singleFile.isDirectory() && containsInjection(new BufferedReader( new FileReader(singleFile)))){  //## Checking only .java files in your current directory  
                   System.out.println("Detected injection at "+ singleFile);     ## Print out path of found file    /// Replace with method or function that prints the paths to console when an injectable is detected      
                    foundInjection=true;  //## If a detection was made, set flag as true   }      for (String line : Files.readAllLines(singleFile)) {     ## Read and print out each lines in your file    /// Replace with method or function that prints the paths to console when an injectable is detected      
                       if(!line.contains("A03_Injection")){  //## Check for 'injecting code' within files (replace A03_Injection)   }      }}     ## End of loop and check flag    /// Replace with method or function that prints the paths to console when no injectable is detected
                if(foundInjection==false){  //## If a detection was not made, print message on command line. (replace A03_injecting code)   }       System.out.println("No injection found in files.");      }}     ## End of main method    /// Replace with the actual function or operation when no injectable is detected