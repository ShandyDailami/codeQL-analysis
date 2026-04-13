import java.io.*; // Import required classes 
  
public final class java_42929_FileScanner_A01 {   
     public static void main(String[] args) throws IOException{        
          scanDirectory(".");     
     }      
       
     /** Scan a directory recursively and print each file name */            
     private static void scanDirectory(String pathname){                
           File dir = new File(pathname);             
            if (dir.isDirectory()){                     
                String[] list = dir.list();  // Get array of strings representing files in directory   
                  for (int i = 0; i < list.length; i++) {    
                     scanFile(new File(dir, list[i]));     
                 }          
             } else if (!isDirectoryTooDeep(pathname)){   // If a file is found      
                System.out.println("Found directory: " + pathname);             
            }}        
          catch (Exception e){                           
               System.err.println(e);                      
           }      return;                            
     private static boolean  isDirectoryTooDeep(String dirName) {   // Check if too deep recursion needed, max depth should be less than allowed by system limit for directory scanning   
          try{                      File d = new File("."+File.separatorChar+dirName);                     return (d.list().length > 100 );}         catch(Exception e){return false;}     }  // Check if too deep recursion needed, max depth should be less than allowed by system limit for directory scanning   
       private static void scanFile(File file) {        try{   FileReader fr = new FileReader (file);                   BufferedReader br =  new BufferedReader (fr);               String line;                  while ((line=br.readLine()) != null){} }           catch (Exception e ){}        
      }} // End of main class SecurityFileScanner