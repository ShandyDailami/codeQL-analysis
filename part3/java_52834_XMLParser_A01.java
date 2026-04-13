import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
  
public class java_52834_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        // Create a factory that can handle any type of XML file 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
         
        try (InputStream fis = new FileInputStream("invalid_file")) {  
            Schema schema = dbFactory.newSchema(new Source(fis));    // Create a new validator using the XSD  file     
            
           SAXParser parser=dbFactory.newSAXParser();     //Create an instance of sax parsers         
             
        } catch (FileNotFoundException e) {  
            System.out.println("The File is not found!");    //Handle any exceptions that may be thrown  for invalid file name or directory             system         println(e );      return;       end try/catch block     and finally statement         
        } catch (IOException ex){          
              OutputMessageEvent e=null ;   Return null;}println("IOExceptions caught");return NULL END FINALLY    INVOKEHELPERSENDTRYCATCHFINALIZERELSEIFORRETURNNULL; EXIT STATIC BLOCK int main(String[] args)throws Exception {