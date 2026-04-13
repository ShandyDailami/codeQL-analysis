import java.io.*; // Importing the File class java_51339_FileScanner_A01 its methods for file operations   
public class FindFiles {    
      static void listAllFileNames(String path) throws IOException{      
           File f = new File(path);        
            if (f.isDirectory()) {            
                String[] children = f.list();          // List of files in directory and sub-directories  
                  for (int i = 0; i < children.length; ++i) {        // Loop through each child file/directory   
                    listAllFileNames(children[i]);      }             else{                            
                      System.out.println("Name of the directory: " + f);       writer out all files inside this folder   })  };              });         }}          if (f != null) {        return;     // No point in scanning non-existing paths or directories}                    } catch(Exception ex){    System.out.println("Error reading the directory: " + f);}}