import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
  
public class java_51286_XMLParser_A08 {   
     public static void main(String[] args) throws ParserConfigurationException, SAXException{         
           XMLReader reader = null;  //declaration and initialization      
      try {                   
            String filename="yourfilepath";                 
             File inputFile  = new File(filename);        
              Reader fileReader =  new FileReader(inputFile);       
               DocumentBuilderFactory dbFactory  =  DocumentBuilderFactory.newInstance();          
                DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();         
                 reader=dBuilder.newSAXParser().getXMLReader();            //create SAX parser      
              HandlerClass hc =  new HandlerClass ();    
                  reader.setContentHandler(hc );   
                   ReaderWriter rw = null;               
                         FileOutFile out  =   OutCreateDecisionFactory .newInstance ("utf-8" ,rw,fileReader) ;             //providing output file name                      writer         
                     XMLWriter xwriter =  new  xmlwriterss (out );       write(reader);      }               catch (Exception e){                    System.err.println("Parsing failed..." +e);    };        finally{                   if ( reader != null )                reader .getDocumentHandler().detach();}}            
     //handler class which will parse xml            public static void write(XMLReader  ar) throws SAXException {              XMLStreamConstants id;         try           while   (!ar.isStartElement()){               int type =    ar.getEventType ();                   switch      (type ){ case       START_ELEMENT:     System . out . println (" Start Element : " +       
                      //name= ao  ); break ;                       default         +         }}}                 @Override public void startElement(String   uri, String localName ,    Strin name) throws SAXException {System.out..println("local-start"+  )}     }}`}})