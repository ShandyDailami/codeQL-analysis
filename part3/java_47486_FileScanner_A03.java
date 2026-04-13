import java.io.*; // for handling files & directories;  

public class java_47486_FileScanner_A03 {    
    public static void main(String[] args) throws IOException{         
        File file = new File("path/toYourFile");     
         if (file.exists()){ 
             try(BufferedReader br =  new BufferedReader(new FileReader(file)))   // using a 'try-with resource' to ensure the reader is closed after use, even in case of an exception         
                 while ((br.readLine()) != null) {    // read line from file     
                     String data = br.readLine();     // reading all content into one string       
                      System.out.println(data);       // print the contents        
                  }  
             catch (IOException e){ 
                 throw new FileSystemException("I/O error while trying to read file",e,file );    // handle I/O exception and recoverable files     
              }    
        }} else {           System.out.println( "The specified file does not exist.");   return;         }         
  }       finally{             if (br != null){ br.close();}                try{fileWriter = new FileWriter("path/toYourFile", true); // opening the writer at end of each line      for appending text    }}               catch(IOException e) {System.out.println ("An error has occurred while trying to write into file.");}}