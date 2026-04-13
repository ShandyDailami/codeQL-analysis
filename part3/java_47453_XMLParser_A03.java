import java.io.*;  // Import of InputStreamReader & FileInputStream for reading file contents and BufferedWriter to write output back into XML files (A01_Security)  
public class java_47453_XMLParser_A03 {   
     public static void main(String[] args){      
         try{            
              String filename = "sample.xml";  // Name of the input xml File, should be securely protected and not accessible directly from outside this project or jar file (A02_Security)  
              
            InputStreamReader reader=new InputStreamReader( new FileInputStream(filename),"UTF-8");    
             BufferedWriter writer = null;  // A Writer to write the output back into XML files, it can be replaced with a different library for writing (A02_Security)  
              int c ;   
                while ((c=reader.read()) != -1){     
                     if(writer ==null ) { writer = new BufferedWriter(new FileWriter("output."+filename)); }  // Create the buffering Writer for writing out to an external file (A02_Security)  
                      writer.write((char) c);    
                }    reader.close();      if(writer != null ) { writer.close();}               BufferedWriter("output."+filename).flush(); // Flushing the output back into xml  File after reading (A02_Security)(Always remember to close all resource once done)  
             System.out.println ("XML file content has been read and displayed below:");    }catch(Exception e){       System.out.println("Error Occurred.");      // Catch exception if any, Always handle exceptions properly (A02_Security)(Always remember to close all resource once done)  
         }         
     } 
}