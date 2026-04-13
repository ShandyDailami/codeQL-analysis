import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_52303_XMLParser_A03 { 
    public static void main(String args[]) throws ParserConfigurationException, SAXException{  
        String xmlInput = "<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget the meeting at 2:00 PM today. Hopefully we can meet around 3PM next week! Goodbye, Tove!";  
        XMLReader xr = XMLReaderFactory.createXMLReader();      
          
        // Create a new handler for each start event    
        XMLElementHandler eh =  new ElementHandler(xmlInput);   
        
        try{            
            while (xr.hasNext()){             
                int type= xr.getEventType();     
               if((type==XMLReader.START_ELEMENT)){                 
                   // Call the handler for start event    
                      eh = new ElementHandler(xmlInput);   }         else{       XMLReader.CHARS + "...";}}};  finally {xr .closeElement()});}             });           };            try{ XMLElementParser(); }} catch (Exception ex){ System,outprintln("Something went wrong in the parser: ",ex );}}}