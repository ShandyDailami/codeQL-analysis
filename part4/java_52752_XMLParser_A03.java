import javax.xml.stream.*;
import javax.xml.namespace.*;
 
public class java_52752_XMLParser_A03 {  
    public static void main(String[] args) throws Exception{    
        String xmlFile = "sample.xml";       //path to your file        
         
        try (XMLStreamReader reader =  XMLStreamConstants.createXMLEventReader())      {            
            int event;          
              while ((event=reader.nextEvent()) !=  XMLStreamConstants.END_DOCUMENT){                 
                    switch(event)                  
                        case XMLStreamConstants.START_ELEMENT:               
                             String elementName = reader.getLocalName();  // gets the name of start xml tag                     
                              if (elementName .equals("student")) {           
                                  int id=Integer.parseInt((reader.getElementText()));   // parse student's ID                   
                                      System.out.println(id);                           
                                } else       break;                                     case XMLStreamConstants.END_ELEMENT:             if (!elementName .equals("student"))        continue;}                };                  }}                   finally {XMLSystem.clearStack();}}                 XMLEventFactory.newInstance().getXMLEncoder(StandardCharsets.UTF_8).encode((XMLStreamWriter) System.out, document);}}}