import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_48993_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String xmlFile = "sample_file"; // replace with your file name and extension           
          XMLReader xr = XMLReaderFactory.createNonValidatingReader(new FileInputStream(xmlFile));    
           while (xr.hasNext()){                     
               int event;            
               try{                      
                   event=xlr_next();                    // This is where the real work happens                        
                 }catch (SAXException e) { 
                     System.out.println("XML Parsing Error: " +e);    return;}                     
            if(event==HAvent){                          
                break;                              else{                                         Handler h=new Hander();                   xr_setFeature((byte)Features,h)}                  Xmlreader featureHandler = new xmlReader(){                         @Override public void startElement (String uri , String localName   atribute... ) {}}          if(event==HAvent){                             break;                                                    }                            }}