import java.io.*; // Import necessary Java packages like IOException etc...
class java_49643_FileScanner_A03 {  
    public static void main(String[] args) throws Exception{    
        File file = new File(".");// This will get the current directory, you can replace it with other directories as well (e.g., '/home/user') 
         // '.' is used to represent currently running program's working dir or location in which we want our files and folders listing happen;   
        listFiles(file);    
   }      
      static void listFiles(File file) {          
          File[] hiddenFiles = file.listFiles((dir, name) -> (new File(dir, name)).getName().startsWith("."));  // This filters out files starting with .        
              if(hiddenFiles != null){            
                  for(File f : hiddenFiles ){                
                      System.out.println("\nFound a file: " +f);         
                       FileReader reader = new FileReader (f) ;   
                          BufferedReader br =  new BufferedReader(reader );     // Reading from the files is done using buffering readers for performance improvements      
                         String line;          
                        while((line=br.readLine()) !=  null){             
                            System.out.println("Content of file: "+line);         }          br.close(); reader.close() ;      // Ensure to close all resource once they are not needed     }}else{            println ("No hidden files in this directory.");}       };  });