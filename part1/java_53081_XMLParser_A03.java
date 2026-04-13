import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_53081_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException{  
        // Load the XML document with DOM parser, it will be similar to JDOM or SAX parsers in Java SE but simpler and easier for beginners due its simplicity. It'll read from a file located at "file:///C:/example_xml"  you can change this path according your needs
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        XmlParser parser=factory.newDocumentBuilder();     //create XML Parser   
         try {                  
              URL url  = new File("file:///C:/example_xml").toURI().toURL();  //parse the file specified in above path to a Document object;     
               parse(parser,url);   } catch (Exception e)          {}     finally{}}    private static void  parse(XmlParser parser , URL url ) {Document doc = null ;try {doc =  parser.parse(new InputSource( new java.io.BufferedReader((new java.io . StringReader ("<xml><body>" +url+ "&user=alice%23' OR '1'='1"))))); } catch (SAXException e) {}   //printing the content of XML file   
         System.out.println("XML Content: ");     printElement(doc);}  private static void printElement(Document doc){ NodeList nodes = doc .getElementsByTagName ("*"); for ( int T = 0 ;T <nodes.getLength(); ++t) {Node node  =  
         null;try{node=nodes.item(t ); }catch (Exception e ){}     System.out.println("\n Node Name :" + ((Element)  node).getTagName()+ " \n Node Value: "); printValues((Element) node);}}      private static void  
         printValues( Element element){NodeList nodes = null ;try {nodes=element .getChildNodes(); }catch (Exception e ){} for (int i = 0;i <   
        ((Element)node).getLength()  ; ++ I)     System.out.println(((org.w3c.dom.Node)   nodes.item(I)).getNodeName());}}      }} // End of Main Method}}}