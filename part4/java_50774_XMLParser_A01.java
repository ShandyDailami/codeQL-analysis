import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
public class java_50774_XMLParser_A01 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String inputFile = "src/inputfile"; // replace with your file location
            File xmlFile=new File(inputFile);        
                XMLReader reader;         
                    try {                    
                        Reader fileReader =  new FileReader(xmlFile) ; 
                            reader  =    XMLReader.getSAXReader();    
                                Handler handler =   new ContentHandlerImpl ( );       
                                    reader .setContentHandler ((Handler )handler);     
                                        // parse xmlfile                        
                                            reader.parse( fileReader);                  
                    } catch (FileNotFoundException e1) {        
                        System.out.println("The File was not found"); 
                            e1.printStackTrace();  
                                                  return;   
                                    }                    
        });         
}      // end of main method