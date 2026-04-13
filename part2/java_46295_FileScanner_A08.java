import java.io.*;

public class java_46295_FileScanner_A08 {
    public static void main(String[] args) throws IOException{
        String dirPath = "/path/to/directory"; // replace here the directory path you want to scan in your system, for example: C:/Users or D:\Documents  etc...  
        
        File fileScanner = new File (dirPath);   
    
       if(fileScanner.exists()){          
            searchFileInDirectory("", dirPath , "A08_IntegrityFailure");            
      }else{         
              System.out.println ("The given directory does not exist.");  //If the path is incorrect or it's a non-existing file then this message will show up   
       }}  
    
        private static void searchFileInDirectory(String indent, String dirPath , final String namePattern){     
         File[] files = null;             
          try {            
            //list of all the directories and subdirectories in directory 'dir'              
                if (indent.equals("")){                      
                      System.out.println(FileDescriptorChanger.getFormatedPathNameWithSeparatorAfter("/", dirPath)+"/*");                        }  else {                        
                    File f = new File (" " + indent  + "/" +  namePattern);              try   (DirectoryStream<Path> ds =  Files.newDirectoryStream( Paths . getFileSystem().getPath("."),namePattern))    //try with resources, so the Directory Stream will be closed after we're done using it    
                    {           System.out.println ("\n" + indent +  " files matching 'A08_IntegrityFailure': ");              for ( Path p : ds)                if (!p.toString().endsWith("."))   //this condition is to prevent directories and other types of file from being printed, just the regular .java or java source (.class ) will be listed   
                     {                                                 System.out.println( indent + "-"  + p);                    }  }}catch (Exception e)      {}           catch (FileNotFoundException fnfe){}          // we do not care about this exception   if you really want to handle it, replace the try-except blocks with a new block for each type of Exception   
        private static String getFormatedPathNameWithSeparatorAfter(String separator ,  final String s) {     return (s.substring(0,1).equals(separator)) ?   sep + " and more" : ""  + FileSystems .getDefault().getSeparator()+"" ; }
}