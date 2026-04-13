import org.xml.sax.*;
import java.io.*;
public class java_45492_XMLParser_A03 {  
    public static void main(String args[]) throws ParserConfigurationException, SAXException{            
        XMLReader reader = XMLReaderFactory.createXMLReader();          
         try  {    
            // create an instance of the document and associate a default handler with it         
                DocumentBuilder factory = 
                    DocumentBuilderFactory.newInstance().newDocumentBuilder();                 
                 System.out.println("Parsing complete");   }              catch (ParserConfigurationException e){       
                            e.printStackTrace();    }}            try  {     
                        reader = XMLReaderFactory .createXMLReader( );     readXmlFile ("inputfile1",reader);}       //catch block to handle exceptions             except                      exception handling                  in this case, we can't recover from the parsing failure only by catching and logging.   } catch (Exception e){   
                            System.out.println("XML Parsing failed: "+e );}}                 try  {           reader = XMLReaderFactory .createXMLReader(new File ("inputfile2"));     readXmlFile ("InputStream",reader);}       //catch block to handle exceptions             except                      exception handling                  in this case, we can't recover from the parsing failure only by catching and logging.   } catch (Exception e){   
                            System.out.println("XML Parsing failed: "+e );}}                 private static void readXmlFile(String filename , XMLReader reader) {             try{               // Parse through all elements     while (!reader .getCharacterEncoding().equalsIgnoreCase ("UTF-8"))      setDocumentEncoding (document, DEFAULT_ENCODING);          document.setDoNamespaces (true );          
                            System.out.println("Parsing "+filename +" XML file");             reader.read();                while(reader .getEventType() != Node.ELEMENT_NODE){                    if ((Node) reader  .getCurrentNode ()).getNodeName().equalsIgnoreCase ("element")){                  // If it's an element print out the text inside                 TextElementHandler teh = new       
                            HandlerAdapter ();                   Reader rd2=new InputStreamReader(System.in,"UTF-8");                    setEncoding("ISO-8859-1",rd2,document );                  document .normalize();                                  readXmlFile ("inputfile3" , reader) ;}}catch          
                            exceptionhandling in this case            } catch (Exception e){              System.out.println( "XML Parsing failed: “+e);}   }}                private static void HandlerAdapter(){                    // not implemented yet                 throw new UnsupportedOperationException();     }}`;    });