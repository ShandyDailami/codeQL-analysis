import java.io.*; // Import necessary classes: File, FilenameFilter etc..  
public class java_45359_FileScanner_A01 {   
     public static void main(String[] args) throws IOException{     
          String dir = "/path/to/directory";       // Specify the directory path here; 
          
         fileInDirectoryUsingRecursive(dir);       
     }             
               
   /** Recursively traverses a given Directory and prints its contents */   
             public static void fileInDirectoryUsingRecursive (String dir) throws IOException {       // Define the method. 
                  File directory = new File(dir);         
                   if (!directory.exists())        {         // If there is no such path, exit from function:  
                       System.out.println("Invalid Path");      return;    }             else{            boolean usingRecursiveMethod=true ;  bool flag_txtfile =false;               File[] listOfFiles =  directory .listFiles( file -> { if (flag_txtfile)     {       // If it's a text files then
                          String name = file.getName();         return ((name.endsWith("TXT") ||   name.endsWith ("txt")) ?  true : false); } else           {            flag_txtfile=true;          if ( !( "." .equalsIgnoreCase     () ) &&      (!isDirectory    (.path))){
                          String filename = file.getName();        return ((filename.matches("^[a-zA-Z0-9]+( [a-zA-Z0-9 ]+)*$") ? true : false); } else           {               flag_txtfile=false;          if (!isDirectory ( .path)){
                          String filename = file.getName();         return ((filename   == null ||     ("."  === "" ) && ! isHidden( ))) ;      }} });       // Return the boolean result of method call:        }}));                 System.out.println("Finished scanning");}}}}}`!