import java.io.*; // Import InputStream, File etc from Java (Standard) library  
public class java_46107_FileScanner_A08 {   
     public static void main(String args[]){        
          String directoryPath = "/path/to/directory";  /* Insert your target Directory here */      
           try{            
                printFilesInDirectory(new File(directoryPath)); // Call method for printing the files in a given path           
               }catch (Exception e) {                            
                    System.out.println("Error: " +e);                    
              }   
        }  
         private static void  printFilesInDirectory(File directory){    
             File[] listOfFiles = directory.listFiles(); // List all files in a given Directory     
               if (listOfFiles != null) {                 
                    for (int i = 0; i < listOfFiles.length ;i++ ){           
                         printInfoAboutFile(listOfFiles[i]);                  
                     } 
                }else {                               // If no files found in the directory                      
                 System.out.println("No file or folder at " +directory);  
              }   
         }      private static void printInfoAboutFile ( File f){       
             if(f.isDirectory() ){                           // Checking whether a part of path is Directory                     
                  System.out.println("Folder:  "+f.getName());         
               }else {                                         
                    try{                                         // For file reading and printing information    
                         FileInputStream fis = new FileInputStream(f);  
                          BufferedReader br =new BufferedReader (new InputStreamReader(fis));     
                           String line;                 
                            while ((line=br.readLine()) != null) {          // Reading file content   
                                 System.out.println("File Content: " + line);    
                              } 
                          br.close();   fis.close();                     
                       }catch (Exception e){                       
                           System.out.println(e+" : File not found");        
                       }     
                }   
        }} // End of Main Class and Method Declaration         `