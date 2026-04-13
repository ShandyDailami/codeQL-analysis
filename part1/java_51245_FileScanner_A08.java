import java.io.*; // Import necessary classes for file handling  
    
public class java_51245_FileScanner_A08 {   
        public static void main(String[] args) throws IOException{     
            File folder = new File(".");      
            
         /* Start from the current directory, then traverse all of its subfolders using a recursive strategy */ 
           scanDirectory(folder);  
     }// end Main    // begin static methods for file handling. All our work is done here in these method calls as they are intended to be used inside another function (in this case the main)         
      private static void scanDirectory(File folder){      
            File[] listOfFiles = folder.listFiles();  if (listOfFiles != null) {   // If there is a file/folder named 'this' in current directory, print out its name here     for (int i = 0;i < listOfFiles.length ; ++i){   
            System.out.println( ((File) listOfFiles[i]).getName() );  }   // If there is a file/folder named 'this' in current directory, print out its name here      if (listOfFiles != null ) {        for(int i = 0; i < listOfFiles.length ; ++i){
              scanDirectory((File) listOfFiles[i]);   } // recursive call to read all files and subfolders within current directory  }}// End of 'private static void' method       print out the name if file/folder named this in a specific folder here    end point at main function.    
}