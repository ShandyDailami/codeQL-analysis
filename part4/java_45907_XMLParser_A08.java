import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_45907_XMLParser_A08 {  
    public static void main(String[] args) throws SAXException{    
        XMLReader reader = XMLReaderFactory.createXMLReader();  //Create a new xmlreader object      
        
        HandlerClass hc=new HandlerClass();      //Your handler class should implement the ISAXHandler interface  
                                                  //Handles start and end tags of an element in document   
          reader.setContentHandler(hc);     //Set contenthandler to your handerclass      
          
        try{                       //Call parse method from xmlreader object     
            reader.parse("testfile_A08integrityfailure");  //Parse a file or pass inputstream here        
                                                   }catch (Exception e){             System.out.println(e);}   });     }}`