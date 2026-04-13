import org.xml.sax.SAXException;  // Import SAX Exception, which are the exceptions thrown by XML parsing methods such as parse() and setValidation(XmlReader) etc...   
   import javax.xml.parsers.*;     // Java provides a built-in parser called DOMParser for reading an XML document with its own API that is user friendly – SAX, Streaming or StAX are some other types of parsing methods by the same authors which provide different features and support more flexibility in handling documents
   import org.xml.sax.helpers.*;    // Import DocumentBuilderFactory for creating a default document instance (like DOMParser), also includes validation feature – SAX2, StAX etc...     
public class java_44736_XMLParser_A03 {    
       public static void main(String[] args) throws ParserConfigurationException{  
           try    //Try block to handle exceptions related to XML parsing. It is required while working with external APIs or databases – ie., parse(), setValidation() etc...     
            {       
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
               DBHandler myHandler= new DBHandler ();             //Custom handler to handle the XML data  
              SAXParserFactory spf =  SAXParserFactory.newInstance();    
                
              SAXParser saxp  =spf.newSAXParser(true,myHandler );   
               InputSource is = new InputSource (System.in);      //Reading from console – can be file or URL  
                saxp .parse(is ,null ) ;                            //Parsing the document    
            } catch ( SAXException e) {         
              System.out.println("SAX Exception Occurred: " +e );   
             }catch ( ParserConfigurationException pe){     
               System.out.println( “Parser Configuration exception caught :”+pe);       //Caught when the parser is not able to find a valid handler for our Document  
            } catch (IOException e) {                      
              throw new RuntimeException("I/O Exception Occurred: " +e );     //Catching I/o related exceptions – can be file or network-related     
             }       
       }}