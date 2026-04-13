import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_52139_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        String inputFile = "inputfile"; //replace with your xml file path or url      
           XMLReader reader=null;    
            try     
             {         
                Reader file=new FileReader (inputFile);   
                 reader=  DocumentBuilderFactory.newInstance().newSAXParser().getXMLReader(); 
                  SAXHandler handler = new SAXHandler();   //custom class for handling xml data          
                   reader.setContentHandler(handler );     #setting Content Handler here           
                reader.parse(file);    }             catch (FileNotFoundException e) {e.printStackTrace();}     
               finally{reader=null;}         }}`;