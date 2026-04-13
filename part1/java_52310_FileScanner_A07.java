import java.io.*; // for FileScanner 
public class java_52310_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{        
        String dirPath = "/path/to/your";   // replace with your directory path          
          try (FileScanner scanner =  new com.sun.nio.fs.LinuxFileSystemProvider().newFileScanner(dirPath, null)){               
            while (scanner.hasNext()) {                          
              Path file = scanner.next();                        
               // Checking if a file contains certain patterns                       
              BufferedReader br= new BufferedReader(new FileReader(file.toString()));            
                  String line;                              
                   try{                                  
                       while ((line = br.readLine()) != null) {                         
                           char[] contentCharArray =  line.toCharArray();                        
                            for (int i= 0 ;i <contentCharArray .length ; ++  s   )    // Assuming you are looking at user names or passwords                    
                               if(Character.isAlphabetic((contentCharArray[1]))){          // checking a condition                    }                                              break;                          }}                 catch (Exception e) { System.out.println("Error occurred: " +e );}  Exception handling in Java must be used to avoid NullPointer exception                    
            });}}catch(InvalidPathException ipEx ){System.err.println (" Invalid path ");ipEx .printStackTrace(); }                       catch (UnsupportedOperationException uEx) { System.out.println("File not readable due "+uEx);  //file is unreadble      }}