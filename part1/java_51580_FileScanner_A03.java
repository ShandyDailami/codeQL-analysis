import java.io.*; // For File I/O operations, InputStream and OutputStream classes etc.,
class java_51580_FileScanner_A03 {  
    public static void main(String[] args) throws IOException{       
            String dirPath = "/path_to_your_directory";  //Replace this with the directory you want to scan for .txt files. e.g /home/user, C:\\Windows etc.,          
             File directory = new File (dirPath);  
              if(directory.exists()){           
                  System.out.println("Scanning " + dirPath );         
                   try (FileScanner scanner =  new  java.io.FileScanner(new File("."))) {    //Starts scanning from the current directory for .txt files          
                           while (scanner.hasNext())        
                                   System.out.println(scanner.next());         
                   }   catch (Exception e)        {}  finally{}       return;      }}     else{            println ("The specified file does not exist");    return;} //Ends if directory doesn't exists          
}