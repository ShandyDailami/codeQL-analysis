import java.io.*; // Import the necessary Java packages such as File, InputStream etc...
   import java.util.*; //Importing only ArrayList which can do list related functions like add and remove elements in O(1) time complexity ie., they are included inside Collection framework of standard library 
   
public class java_47708_FileScanner_A07 {      
     public static void main (String[] args) throws Exception{     
         File file = new File("C:/Users/your_directory"); // Path to the directory you want scan. Replace it with your own path  
          if(!file.exists())  throw new IOException ("The given location does not exist!");   
           List<String> filesInDirectoryList =  new ArrayList<>();    
            File[] foundFiles = file.listFiles(File::isFile); // Getting all the .txt, image etc... Files in directory and storing it into array of type `java.io.file` object  which is basically a list representation similar to DirectoryIterator used by Streams  
             if (foundFiles == null) throw new NullPointerException("No file or files found!!");     // Checking whether we got any resultant data   
              for(File f: foundFiles){        
                try{              
                    FileReader fr =new  FileReader(f.getAbsoluteFile());   // Creates a Reader that will read the contents of our file to be safe, as these types only work with char and they should always stay around until after we're done reading them!         
                        BufferedReader br  = new BufferedReader(fr);     // We use this reader in place of Stringreader which is faster     
                            for (String line;  (line = br.readLine()) != null;) {      
                                filesInDirectoryList .add(line );  
                               }                     
                catch (IOException e)    {}        end try and the loop, if there's any problem while reading a file we want to handle it gracefully      // Catching exceptions like IOException in case of unreadable/unwritable files          else  {System.out .println("Unable To Read File")};  
                 finally {}             }               end try-catch block for our loop, always make sure that all resource related operations are closed properly to prevent any potential issues     // Including closing resources inside the 'finally' clause      
         System.out.print(filesInDirectoryList);     
    }}  END OF MAIN METHOD