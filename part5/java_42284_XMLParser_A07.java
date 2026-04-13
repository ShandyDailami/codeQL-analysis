import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.File;

public class java_42284_XMLParser_A07 {  
  public static void main(String[] args) throws ParserConfigurationException, SAXException{   
      //Creating instance of XMLReader    
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
           XmlFilterImpl filter =  new XmlFilterImpl("inputfile", "UTF-8");  /* Specifying input file */  
            Parser parser  =dbFactory .getParser(filter);        //Getting instance of XMLReader   
          FilterSource fs = new DocumentBuilderFactory().newFilteredReader(parser, filter );    
           SAXParser saxParser=SAXParser.factorydefault();  /* Creating a default implementation */  
            InputSource is  = null;     
             try{is =  new InputSource(fs);}          //Creates input source   
               catch (IOException e) {e.printStackTrace(); }       
              Document doc=  saxParser .parse(0,     /* Call parse method and returns document instance */  is );               
           System.out.println("XML Parsing Completed using SAX");   //Prints message on console   
      findSuspiciousActivities(doc);       }        public static void findSuspiciousActivities(Document doc){     /* Using DOM to traverse through XML */  try {           for (NodeList nl= doc.getElementsByTagName("*");nl.getLength() ;nl=nl,+0)     
            System.out.println((Element) nl).getQualifiedName());        }          catch(Exception e){e.printStackTrace();}}  //Catch block for exception handling    };     /* Main method */   public static void main (String args []) {       newMain .main (""); }}