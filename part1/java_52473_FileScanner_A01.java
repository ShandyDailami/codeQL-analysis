import java.io.*;  // File I/O support classes  

public class java_52473_FileScanner_A01 {   
     public static void main(String[] args) throws IOException{        
          String fileName = "example_file";      
          
          BufferedReader reader =  new BufferedReader (new FileReader("/" + fileName));  // reading from a specific location is risky, this should not be the case in an enterprise level application.   
                     if(reader == null) {  
                         throw new SecurityException ("Unable to read: "+fileName);//throws exception at runtime when reader can't establish due to invalid file path etc  }     
                  try{     // Try-Catch block for File operations is a must.       
                      while ((reader.read()) != -1) {      
                            System.out.print((char)(reader.read()));   });          catch (IOException e){            throw new SecurityException("Error reading file: " +fileName,e); }     //Catching the exception if it occurs at runtime  }}        finally{         reader.close();      try {            
                      FileWriter writer =new FileWriter(fileName ,true );           catch (IOException e)          throw new SecurityException("Error writing to file: " +fileName,e); } //Catching the exception if it occurs at runtime  }}        finally{         reader.close();   };}}