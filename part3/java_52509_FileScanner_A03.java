import java.io.*; // Import necessary classes needed in this task  
    
public class java_52509_FileScanner_A03 {     
    public static void main(String[] args) throws IOException{         
        File folder = new File(".");  // Get current directory               
        
        String[] listOfFiles= folder.list();          
              
            for (int i = 0;i < listOfFiles.length;i++){            
              System.out.println(listOfFiles[i]);                  
                                  }         
    }}