import java.io.*; // Import necessary classes 
class java_52440_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{    
        String dirPath = ".";// Change this to the directory you want scan in your system for security sensitive operations, replace it with current user's home path if not needed.         // Read all files from root folder (.)  
               File fileOrDirectory = new File(dirPath);         
            printDirecoryStructure(fileOrDirectory , 0 );      }     private static void    printDirecoryStructure(File file, int nLevel) throws IOException {         if (!file.exists()){                       System.out.println("Given path does not exist"); return;               }}
        File[] listOfFiles = file.listFiles();  // List all files and subdirectories in given directory     for (int i = 0 ;i < ((List<?>) listOfFiles).size() - nLevel +1   );    printDirecoryStructure(((File)(listOfFiles[n])), ++nLevel);
                } else { // This block will execute when file is a regular File (not directory or link to it in any way including its existence)              for (int i = 0;i < listOfFiles.length - nLevel +1 ;){     System.out.println(listOfFiles[n].getPath()+" ("+  ((File)(file)).getName());
                if(((File) file).isDirectory()) {      printDirecoryStructure (  (File ) listOfFiles [i++] , nLevel );}}}}} else{ System.out.println("Invalid File or Directory"); }} }// end main method