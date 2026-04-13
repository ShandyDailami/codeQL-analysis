import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_51536_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        String file = "/path/to/yourfile"; // Replace this with your actual XML File Path 
        
      try {    
          DocumentBuilderFactory dbFactory =  DocumentBuilderFactory.newInstance();  
          SAXParserFactory spFactory = (SAXParserFactory) dbFactory;   
          
          SpreadsheetMode mode  = new SpreadsheetMode(); // Custom class to handle the data parsing operation 
          XMLReader myReader=spFactory.newSAXParser().getXMLReader(mode);  
        
          System.out.println("Starting parse");    
          /* When using external frameworks like Spring or Hibernate, you should use these method calls in place of the "main" and below */ 
           // DocumentBuilderFactory builderFactory = ...;   
            //SAXParser saxParser=builderFactory.newSAXParser();  
             myReader.setContentHandler(mode);     
          /* Parse your XML file here, this will start parsing operation after creating SAX parser object */ 
           int parseCount = 0 ;      
         while (myReader.hasNext()) {     //starting a loop to process the xml document   
              try{   myReader .next(); }      catch(Exception e){e.printStackTrace();}         
              ++parseCount;                   if((parseCount % 10) == 0 ) System.out.println("Parsed "+ parseCount +"th element");     // print each parsed xml node  
            }}catch (FileNotFoundException fnfe) {    stdErrPrint ("Input File not found: "  + file);fnfe .printStackTrace();}      catch(SAXException saxe){saxe.printStackTrace() ; }       finally{System.out.println("Finished parse")  }}