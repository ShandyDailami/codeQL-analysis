import java.io.*; // Import the necessary classes 
class java_48586_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{    
        FileScanner scan = new A08_IntegrityFailure();      
        
        System.out.println("Searching for integrity failure files in: " + getUserDir());     
            
        String currentDirectoryPath;  // Initialize the variable  
                                                   
        try {         
            File[] hiddenFiles = new java.io.File(getHiddenFolder()).listFiles();             
                                                                                
                for (int i = 0 ;i<hiddenFiles.length-1;++)     
                      System.out.println("Found the following integrity failure file: " +        
                         hiddenFiles[i].getName());          
        } catch(Exception e){                                                   // Catching any exception that may occur         
            if(!e.getMessage().contains('.'))                             else   throw new IOException ("Directory not found ->"+dirName,123);     
                                                                     };  }}// End of Main    method                  }      
}        `