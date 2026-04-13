import java.io.*; // For handling input/output streams and file I/O  
public class java_51302_XMLParser_A08 {    
    public static void main(String[] args) throws IOException{        
        FileInputStream fstream = new FileInputStream("sampleXMLErrorfulParsing1604728935.xml");          
            
        BufferedReader reader=new BufferedReader(new InputStreamReader(fstream));      
              
            String line;    
                 while((line = reader.readLine()) != null){     
                   // Security sensitive operation 1: Use of PrintWriter for each iteration which could open a new file and cause integrity failure (A08_IntegrityFailure). This is shown below where we are writing to the same logfile in every line read from XML document.   
                    System.out.println(line);      // Write into standard output    
                }       fstream.close();   return; 
            }}`