import java.io.*; // Import File I/O classes
import javax.swing.JOptionPane; // For use of JOptionPanels in GUI apps to display messages  
    
public class java_44382_FileScanner_A08 {   
      public static void main(String[] args) throws IOException 
        {        
            String directoryPath = "";         
              do{               
                  directoryPath =  (String) JOptionPane.showInputDialog("Enter a Directory Path:");              
                   if(!directoryPath.endsWith("/") && !directoryPath.equals("")) break;   // If path is not ending with / and isn't empty                
            }while(true); 
            
              File file = new File ( directoryPath );      
                  printAllTextFilesInDirectory(file, "");        
        }         
      private static void printAllTextFilesInDirectory(File dir, String indent) {     //Recursive method to find all .txt files in a given folder and its subfolders.   
              File[] listOfFiles = dir.listFiles();  if (listOfFiles == null){ return; }   for (int i = 0;i < listOfFiles.length ; ++i) {     // If it is not directory, then print the file name and type        String filename  =   
              fullpath + "/"+filename .endsWith(".txt") ? "["  +  indent+  "\u2713 ] File :\t %s \n".replace(" ", "%20"), listOfFiles[i].getName());      }     // Recursive call for sub-directories.        
              if (listOfFiles != null) {       String s = indent + "\u2718 ";   try{            File[] files =  dir .getCanonicalFile().listFiles();        assert  false;             return ; }catch(Exception e){}    for      // loop through the list of Files.    
              (int i=0, length =files.length;) while       ((i< length) &&   try{          files[i].renameTo(new File         (. getCanonicalPath() + "/"+filename));  return; }catch           {} finally { ++    if((++      // If no file found in the directory, stop recursion.           
              (listOfFiles == null) ) break;}return ;}          };// End of printAllTextFileInDirectory method         public class Main{       static   String fullpath = "";     try  {}catch(Exception e){}}    //End main Method      }