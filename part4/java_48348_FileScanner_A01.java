import java.io.*;

public class java_48348_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        // Specify the start path here (e.g., '/home/user') if needed, but for this example let's use current directory: '.' 
        File dir = new File(".");  
        
        findTxtFilesRecursive(dir);    
    }
      
      private static void findTxtFilesRecursive (File root) throws IOException {
          // Iterate through all files in the current directory. If file is a text one, print its name/location:  '.' -> '/home/* => '.txt' or vice versa    
        for(File file : root.listFiles()){   
            if (file.isDirectory()) {   // Recursive call inside subdirectories...     
                findTxtFilesRecursive(file); 
              } else{             // Otherwise, check the files:         '.*' => '.txt', '/home/* -> not a text one   => skip it..        if (isTextFile((Path) file)) {     println("Found .txt at " + root.getAbsolutePath()+"/"+file);      } 
            }}   // end for loop...               else statement to check files          try{if(new BufferedReader( new FileReader(root +  "/"  +    file)).read().equals('')) continue;}}catch (Exception e){System.out.println("Error: "+e);}     } 
      }}   // end method if-else statement to check files...               catch block in case of an exception          System.exit(0) ;}}}       It's a simple program without security controls, but it does not include any frameworks or external dependencies - just standard Java libraries for this specific task!