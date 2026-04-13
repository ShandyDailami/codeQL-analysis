import java.io.*; // Import necessary classes from Java IO package   
class java_49050_FileScanner_A08 {    
      static void scanDirectory(File dir) throws Exception{      
          FileScanner fscan = new MyDirFinder();        
             for (final Path file: Files.walk(Paths.get(dir.toString())))           //Walk through all files in directory and subdirectories   
                 if (!Files.isDirectory(file))                      //If it is a regular File       
                     fscan.processFile((String) file);             //Process the found .txt Files      
      }    
   public static void main (final String[] args){                  
         try {                                  
              scanDirectory(new File("./testDir"));              
          } catch (Exception e ){                        
            System.out.println ("An error occurred while scanning directory!");                //Handle any exception   
             e . printStackTrace();                   
        }} 
}