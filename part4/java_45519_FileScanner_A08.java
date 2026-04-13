import java.io.*;       // Importing File I/O package     
class java_45519_FileScanner_A08 {         
        public static void main(String[] args) throws IOException  {               
            String directoryPath = "/path_to_yourdir";                   
            fileScanner("txt",directoryPath);                    
                   }                     
    /** This function scans the files in a given path for .xml extension */    
        public static void fileScanner(String ext, String dir) throws IOException {                      
             File directory = new File (dir );                  //Create object of this class         
              if (!directory.exists())                         //Checking whether Directory Exists or not        
                 throw  new RuntimeException ("Directory doesnt exist!");    else                          //If exists, proceed further      
                for (File file : directory.listFiles((dir1, name)->name.endsWith(ext)) ) {                   //Iterating through files in the specified Directory with a specific Extension         
                    if (!file.canRead())                         //Checking whether Files are readable or not          
                        throw new RuntimeException ("File is unreadble: " + file);       else                 //If File Can be Read, proceed further            System.out.println(path+"  -->  found!" );         }                 
        }}