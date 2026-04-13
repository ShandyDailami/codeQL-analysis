import java.io.*; // Importing necessary libraries 
  
public class java_51338_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{       
            File file = new File("path_to_yourfile");     
            
           try (FileReader fr = new FileReader(file); BufferedReader br =  new BufferedReader(fr))  //Using Try with resources to ensure closing of streams.   
                {      
                    String line;       
                       while((line=br.readLine())!=null)    
                        System.out.println (line );        
                           }   catch (Exception e){     
                            throw new RuntimeException(e);  //Catching any exception that may occur during execution   
                                })         
                          {        System.err .println("Error Occurred while reading the file");     };      
                      });