import java.io.*; // For FileStream and IOException    
class java_52301_FileScanner_A03 {  
    public static void main(String[] args) throws Exception{     
        String directoryPath = "/path/to/directory";         
        
        try (FileStream fileStream =  new FileInputStream(new File(directoryPath)))  {           
             int data;              // Reading byte input from the files.          
               while((data=fileStream.read()) !=  -1)   }                    catch (IOException e){                printStackTrace();}}                      }}