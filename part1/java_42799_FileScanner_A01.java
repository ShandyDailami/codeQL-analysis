import java.io.*;  // Import Java I/O Classes  
public class java_42799_FileScanner_A01 {   
     public static void main(String[] args) throws IOException{     
           String directory = "/path_to_directory";      
            try (FileScanner fscan= new FileFinder().newInstance()) {       
                // Use 'f' to access the list of found files  
                   for (;;)     {         
                      File[] foundFiles=  fscan.find(  directory,    null);                  if((foundFiles==null)|| (foundFiles.length ==0))            return;             System.out .println ("No file in " +directory+" !");        exit ;         }           for   (File singlefile :     foundfiles){
                   // print out information about each of the files         
                    long size =singlefile. length();    Date lastmodified= new  java util date(      File . LastModified (/ Single file)) );              System.out       .println ("Name: " +   singleFile.....+" Size : %d bytes".formatted (size));           }           
             }}     catch        (# possible exception if directory not accessible) {                     throw new IOException("Couldn't open this  Directory");               // End of Try Block                return;       });      }; end method main and finally block can be defined in try or switch blocks, it will prevent the program from crashing.