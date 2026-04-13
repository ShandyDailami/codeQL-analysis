import java.io.*; // Import of necessary classes for handling files and directories (File)  
public class java_47204_FileScanner_A03 {    
    public static void main(String[] args){        
        String directory = "/path/to/directory";            
            try{                
                File dir = new File(directory);                    
                    if(!dir.exists() || !dir.isDirectory())  // Checking whether the path exists and is a valid Directory                         {                      System.out.println("The specified file does not exist."); return; }                  String[] filesInDir =  dir .list();                            for (String filename :filesInDir)                       if(filename==null || new File("/path/to/"+filename).length() == 0){System.out.print("\nFile Not found: " + filename);}else{ System.out.println("Found file: \""+ 
    /* Add your code here to print each valid and non-hidden (not deleted or inaccessible) .txt */filefilename+"\"");}}}                   catch(Exception e){   // Catching exceptions if they occur                          System.err.printlne("\nAn error occurred." +e); }}