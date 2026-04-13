import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult; 
  
public class java_47675_XMLParser_A01 {    
    public static void main(String[] args) throws Exception{        
        // Load the XML document and parse it to a DOM tree (Document Object Model).            
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();                
        DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();               
          
        System.out.println("Parsing XML file");              
  
        // Read the input xml and load it into a DOM tree (document object model).        
        Document doc =dBuilder.parse( new File( "inputFilePath" ) );   
                  
       /*  Create an instance of TransformerFactory, prepare transform to write out     text in console */            
           TransformerFactory transformerFactory =  TransformerFactory.newInstance();  
               XFormatter xf = new XFormatter();      // use pretty printing (XML styled)    print          output            ...         .  .....       2938016       "xml" -> C:\Users\UserName_RamuKumar.vimrc-5
               Transformer transformer =     transformerFactory.newTransformer();   // any prepared transformers can be used here             DefaultHandler defaultHandler= new    org .transformer  .dom .SAXSource$DefaultHandler() {      @Override public void characters (char [] ch, int start ,int length) throws SAXException      
           toConcatenate ) ;   } ); transformer.setOutputProperty( OutputProperties..PREFIX_CONTENT,"");          transform    xml Source into html tree and stream . write the resultant Mighty DOM TREE in     a file      .. 2938016         "xml" -> C:\Users\UserName\_vimrc
               StringWriter sw = newStringWrit   ();           transformer.transform(new SAXSource((Reader) doc),sw );        System . out . println (. getString Stream () ) ; } catch     ( ParsingException pE … -> C:\Users\UserName_vimrc
               iputFilePath = new FileInputStream("inputfile.xml");   // read the input xml file         ...    InputStreamReader in =  ne      XmlParser().getClass( ). getDeclaredField('__'.charAt (10 +     '3' + 56));       FieldEnu mberNamem= new Nul . l  -> C:\Users\UserName_vimrc
               e.printStackTrace();        }    catch   java..xml .. parsinfException pE ) { println ("Problem     ...     1074259" ); }}       XmlParser xmlpa... "parsingFilePath") {}  // closing the connection to server and stream (if any)