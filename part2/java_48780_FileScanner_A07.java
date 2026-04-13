import java.io.*; // Importing the File class, which is part of Java's I/O package  
public class java_48780_FileScanner_A07 {   
     public static void main(String args[]) throws IOException{     
          String directoryPath = "C:/Users";             
          
          System.out.println("Files in given directory:");      
                  
         File folder = new File(directoryPath);   // Creating a Folder object   
            
            if (folder.exists()) { 
                for (File file : folder.listFiles()){     //Iterating over all the files inside this specific path     
                    System.out.println("Name of Files: " +file.getName());      
                     }       
                 else{   
                      throw new Exception ("No such directory exists");  
                  }         
              }  catch (Exception e) {               //Handling the exception if any exist                      
                printStackTrace(e);                   
             }           
      }}