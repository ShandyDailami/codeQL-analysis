import java.io.*; // for handling file I/O operations such as reading, writing etc...
  
public class java_44517_FileScanner_A07 {      
    public static void main(String[] args) throws IOException{          
            String dirPath = "C:\\your_directory";// replace this with the path of your directory        
            
        File folder = new File(dirPath);  // initialize a file object for our specified location (i.e., where we want to search).     
  
        if(!folder.exists()){               
            System.out.println("Directory not found!" + dirPath );                 return;         }              else{               printAllFilesAndFolders( folder, "");}           }} // close the method                  def readFileInFolder ( File Folder ) {             if (!folder . isDirectory())         
            System.out.println ("Scanning :  " +   folder);    return;                     String s [] =      folder     . list();       for( int i = 0 ;i <s.length；++)                readFileInFolder ( new File（ file夹 +  "/"  +        +          
            s[i])); }              public static void printAllFilesAndFolders    // recursive method to get all files and folders in the specified folder 和 its subfolders        if      (!folder. list() [   i]. isDirectory ()) {     System . out。println（ "Scanning :" +         
            folder      + "/“  +           s[i]);             return;                     }              printAllFilesAndFolders( new File  (" +  file夹   +  "/”       +         Sys               tem. getProperty   ( )      ), ");                   // recursively call the method for each subfolder in this directory    
            });}}// close of main function                 def readFileInFolder（文件和目录名称，  File Folder) {             if (!fileAndDirectoryName . isFile())          System.out。println( "Scanning :" + fileANDirectoryname);   return;         }