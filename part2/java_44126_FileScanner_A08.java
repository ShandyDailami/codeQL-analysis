import java.io.*; // Import required classes 
class java_44126_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{    
        String folderPath = "/path/to/yourdirectory";      
         scanFilesInDirectoryUsingRecursiveMethod("", new File (folderPath));     
          }//end of method          
  // Method to perform the recursion. Recurse over all files in directory and its subdirectories   
   private static void scanFilesInDirectoryUsingRecursiveMethod(String path,File file) throws IOException {    
        if (!file.exists()) throw new IllegalArgumentException("The specified location does not exist");       File[] listOfFiles = null;  // List of all files in current directory     
         try{  
            System.out.println("\nScanning Files from Directory: " + path);   
             boolean successReadDir=true,successFileAccessiongToWriteAndReadingOnlyModeSet =  true ;     listOfFiles = file.listFiles();              if(null==listOfFiles) {  // If there are no files in current directory      System.out.println("No File Found"); return;}
             for (int i=0;i<listOfFiles.length;i++){   int permValue =  listOfFiles[i].canExecute()?2:0 |( ! listOfFiles[i].isDirectory()) ?1:(listOfFiles[i]).isReadable() ?"3":"";    
                if (permValue == 7 && file.getAbsolutePath().endsWith(".txt")) {       // If the directory is writable, but not read-only and has '.xml' or 'java_src'.properties files then    System.out.println("Found .TXT File: " + listOfFiles[i].getName());       
                }          if(listOfFiles [ i ].isDirectory()) {      // Recurse the method on directories       scanFilesInDirectoryUsingRecursiveMethod (file.getPath()+ "/"  +   ((File) file).name(),    new File (" + listOfFiles[i] .getAbsolutePath () +  ""));    
            }           if(!successReadDir && ! successFileAccessiongToWriteAndReadingOnlyModeSet ) throw  IllegalStateException("Not all files have write access.");        // If it has an error while reading or setting permissions, then print the exception.   return;}}catch (SecurityException ex) {System.out.println ("Cannot read file: " + path); } catch(IllegalArgumentException e){ System . out .println 
            (.+" is not a directory") ;}     finally{if (! successReadDir && !successFileAccessiongToWriteAndReadingOnlyModeSet ) throw new IllegalStateException("Not all files have write access.");}}catch (IOException ex) {System.out.println ("Cannot read file: " + path); }   
        return;   }} // end of main method  */