import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // Import Input/Output stream classes to handle file operations, etc...    
public class java_50094_XMLParser_A08 {    public static void main(String[] args) throws ParserConfigurationException , SAXException 
{        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();     
// parse your xml file   // replace the filename with yours     DTD Input: FileInputStream fis;    String System.out.println("Parsing complete in dir " +dirname);  try {fis = new FileInputStream(filename) ; Document doc=dBuilder .parse(fis)} catch (IOException e){e.printStackTrace()}
try{Document dom =  dBuilder.parse(new InputSource(new StringReader("<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>"))); 
dom.getDomConfig().setValidating(true); // Enable validation   dom.getDomConfig() .setNamespaceAware( true );// Set to allow namespaces in the xml document    printNode(dom.getElementsByTagName("*")); }catch (SAXException e) {e.printStackTrace();}
}}  private static void printNode( Node node ){   for( int i = 0; i < node.getChildNodes().getLength(); i++ ){ $_ $$node .getChildNodes() [i].normalize()); System.out.*; } if (节点是元素){打印其标签名称和值：System out printerrintln("<" + 属性 ">"); }}catch( Exception e) {e printStackTrace();}
}}}`    // Your filename and DTD structure here.. replace the 'filename' with your xml file, same goes for XML declaration if needed.   } catch (Exception ex){ System out .println("Problem parsing data: " +ex );}}