import java.io.*; // Import necessary Java packages  
public class java_52840_FileScanner_A01 {    
    public static void main(String[] args){       
         try{           
             File directory = new File("C:/YourDirectory");     
              String[] listOfFiles=directory.list();         
               if (listOfFiles != null)  // Ensure there are files in the given path          
                   for (final String file : listOfFiles){    
                        System.out.println(file);            }             }}catch(Exception e){                 catch (Exception e) {                    throw new RuntimeException("Failed to read directory" + d,e)}              // end try and catch block  };                printStackTrace();          if(!directory.canRead() || !dirOrFile.isDirectory())