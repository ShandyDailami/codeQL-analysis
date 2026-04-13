import java.io.*; // Import necessary classes for handling directories, paths etc... in Java
public class java_52838_FileScanner_A01 {  
    public static void main(String[] args){        
        String directoryPath = "C:\\Users";      
           File folder = new File(directoryPath); 
            printAllFilesInDirectory(folder ,0 );     
     }         
 // Helper method to list all files in a given Directory  
    static void printAllFilesInDirectory (File dir, int indent) {             
         String padding="";       while (padding.length() <indent )  padding+=  "-- ";           File[] files =dir .listFiles();        if(files != null){          for(int i = 0;i<files.length ; ++i   ):    // If current item is a file, print it out            
         System.out.println (padding + "-"+ "File Name: -> :\t Path:->  "\""  + files[i].getPath() +  "\", Absolute File Location:\t-> \""+ 
files[ i ].getAbsolutePath ()   + '"'); end if; // If current item is a directory, then recurse into it.             System.out.println (padding + "-"  + "Folder: ->  :\t Path:->  "\""  =  dir .getName() + 
         "\", Absolute File Location:\t-> \""+  files[i].getAbsolutePath ()+ '"'); printAllFilesInDirectory(files [ i ], indent  ); end if; // If current item is not a file nor directory, then do nothing.     }    }}` END OF CODE