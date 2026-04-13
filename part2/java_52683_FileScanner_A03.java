import java.io.*; //For file handling, Input/Output streams etc.,   
public class java_52683_FileScanner_A03 {    
       public static void main(String[] args) throws IOException{         
           String directoryPath = "C:/Users";     
            try (FileScanner scanner =  new FileWalker().createScannar())  //using a custom utility to create scanners.   
             {        
                 for (;;)     {              
                     if(scan == -1)       break;       
                      handleDirEntryName("",   dir, entry);          boolean isDirectory = (entry .isDirector()? true : false );      FileInputStream fis  = newFileInputstreanm(dirfilePath + file.getName());              println ("Scanning: "+    fielname)
                     if (!finsished){     throw   IllegalArgumentException("Unsupported entry type, expected directory or end of storage device");}                 scanner .accept (directory， RecursiveDepth -1);             }               }}           catch(SecurityException e ){       println ("Access denied: " + file.getName());}}