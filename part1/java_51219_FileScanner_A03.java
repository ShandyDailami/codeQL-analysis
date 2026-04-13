import java.io.*; // Import the necessary classes from package 'java'  
class java_51219_FileScanner_A03 {    
    public static void main(String[] args) throws IOException{     
        File file = new File(".");          
        
        findTxtFilesRecursive(file, "*.txt");      
    } 
            
    private static boolean isFileUnderSixHundredMB() {   //This function checks if the size of a given Java .java files (here) exceeds or equal to six hundred MB. Adjust as necessary for your needs            return false;     /* Assuming it's less than currently being used */ }     
            
    private static void findTxtFilesRecursive(File file, String searchPattern){         //This function recursively finds files with the given 'search pattern'.  The default is to look in a directory and its sub-directories for any .java or other extension. Modify as necessary*/       }    
}