import java.io.*; // Import required Java libraries here   
class java_43861_FileScanner_A08 {     
public static void main(String[] args) throws IOException{      
        String directoryPath = "/path/to/your";// Provide your own path or use system properties like 'System.getProperty("user.dir")' to get current dir 
         //For example: "C:/myFolder/"   
  
        File directory = new File(directoryPath);     
          
        if (directory.exists()) {    
            System.out.println("\nFile contents in the given path are:\n");      
              for (String filename : directory.list())  // iterate through all files and directories within this folder   
                  printContentOf(new File(filename));   // use method to display file content     
        } else {         
            System.out.println("The provided path does not exist.");    
       }}        
          
private static void  printContentOf (File f) throws IOException{              if (!f.isDirectory())    // only read files, ignore directories  
                  {                      FileReader fr = new FileReader(f);                     BufferedReader br =  new BufferedReader(fr);      String line;       while ((line=br.readLine()) != null)                   System.out.println (line + "\n");             }}          // end of printContentOf method