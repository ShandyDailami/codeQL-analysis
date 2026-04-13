import java.io.*;  // Import FileReader class java_43513_XMLParser_A01 read from xml file, InputStreamReader for reading a string as input stream etc., we need this too  
public class XmlParser {    
    public static void main(String[] args) throws Exception{        
        String filename = "samplexmlfile";      
          try (FileReader reader = new FileReader("C:\\temp"+filename + ".txt"))      // Use standard library to read the file          
            {             
                int c;            
                  while ((c=reader.read()) != 1)               {{                
                    System.out.print((char) (byte & 0x7F));         }                   try       {} catch(Exception e){}                      finally{}        }}   // Use standard library to handle exception     });      readEnd:;}}           );    }          reader = new FileReader("C:\temp"+filename + ".txt");