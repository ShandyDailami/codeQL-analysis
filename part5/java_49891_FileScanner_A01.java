import java.io.*; // Import necessary classes from the language package  
    
public class java_49891_FileScanner_A01 {   
       public static void main(String args[]) throws IOException{     
             File file = new File("C:\\Users\\YourFolderName");       
             
           if (file.exists()) 
            for (File listFile : Objects.requireNonNull(file).listFiles()){     // For checking directory and getting a List of Files in the folder  
                System.out.println("Inside try block: File Name is " +     
                                           listFile .getName());   
             }  else {       
                 System.out.println("There are no files");      
            }}     catch (Exception e){         // Catch exception if any  
                printStackTrace();         
                  });}}`;