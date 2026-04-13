import javax.xml.parsers.*;
import org.w3c.dom.*;
//... other import statements if needed ... //  
public class java_53456_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String file = "sampleXMLFile124567890_AuditLogs.xml";  /* Provide your XML File Here */              
          
            //Create the factory object:   
             DocumentBuilderFactory dbFactory = 
                    DocumentBuilderFactory.newInstance();    
             
                try {  
                  //Specify that we want read-heavy (SAX) parsing, as opposed to 
                   //read/write heavy like DOM and XSLT transformations        
                     SAXParser saxParser = dbFactory.newSAXParser();     
                      MyHandler myHandler= new MyHandler();    
                       /*Pass the file name where you want parsed XML data*/  
                           saxParser.parse(file,myHandler);              } 
                  catch (FileNotFoundException e1) {                    System.out.println("The File Not Found");e1.printStackTrace();}                   //catch if there is a problem with the file          case SAXParseException: An error occurred while parsing XML document    printStackTrace()       } 
                  catch (IOException e2){System. out .println ("Problem Occurs IO Exception.."+e2);   e2.printStackTrace();}            //catch if there is a problem with the file and input/output operation             case DOMParseException: Problems parsing the document...  printStackTrace()      } catch (ParserConfigurationException pe) {              System .out .println ("Problem Occurs Parser Configuration Exception.." +pe);  
                  //catch if there is a problem with your xml configuration file.    pre.printStacktrace();}          }}                    };// end main method  private static class MyHandler implements SAXHandler{@Override public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {System .out .println ("<" +qName+ "> Start Element"); } @ Override
                  //public void endElement (stringuri , stringlocalname, string qNAME )throws saxexception{ System. out . println("End <"  + local name +  "/>  ");} …...//end of myhandler class }}`   */});