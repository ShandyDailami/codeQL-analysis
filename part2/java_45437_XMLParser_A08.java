import javax.xml.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;   //exception handling for SAX parser, remove if using built-in parsing methods    
public class java_45437_XMLParser_A08 {   
private Document document = null;  /*Document is a container of XML content*/     
       public void parse(String file) throws ParserConfigurationException{        
           try            
            //1. Load the input xml from given source by creating an instance of InputSource               
               Source src=new StreamSource( new java.io.File(file));             
                   document = DocumentBuilderFactory.newInstance().newDocumentBuilder()   .parse(src);          }  catch (SAXException e) {e.printStackTrace();}        //2 & a try-catch block to handle exceptions    */      finally{if(!document.getDomConfig().getValidateSchemaSource()) document.setValidate(true)};
       public void closeDocument() throws SAXException  /*close the Document using XMLReader, ensure it's closed at end of parsing*/ {         if (null != null)          try{if(!document .hasStarted())           throw new IllegalStateException("The document has not been started.");     
    //3. create a reader from source and set to read the whole Document               xmlreader = document   .getXMLReader();                /*close it */xmlreader 
    = null;          } catch (IllegalStateException e) {e.printStackTrace()}        }}         public static void main(String[] args){try{new MyXMLParser().parse("inputFile"); new    MyXMLParser   () . closeDocument();}}catch     //4 & a try-catch block to handle exceptions  (SAXExceptions, java Exceptions) {e.printStackTrace()}