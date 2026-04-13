import org.apache.tinkerpop.graph.*; Graph
import org.apache.tinkerpop.gremlin.java.GremlinServer;   // TinkerPop Server Interface    
        import org.apache.tinkerpop.gremlin.java.driver.DSEngine;  // Driver for the Gremlin server     
import jdom.*; Document; XMLStreamException, SAXException;    // JDOM libraries to parse an xml file  
public class java_53651_XMLParser_A07 {    
// Define a graph variable         
Graph g = null ;      
GremlinServer s  = new GremlinServer("localhost", 8182);      // Apache TinkerPop server settings.           
DSEngine engine=s.driverEnforcer();  
public java_53651_XMLParser_A07() {     super () ;    }         
// Create the graph on a local gremlin instance         public void createGraph ( ) throws IOException, InterruptedException  {             g = new SimpleStringVertexLabelAwareGraph<>(engine);                Gremlin Server configuration.               // Use TinkerPop's Java API to open and close connections       
public static Document parseXMLFileToJDOMElement()throws SAXException,IOException{     return JDOMParser().parse("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" + " <person><name>John Smith  <age>25   <city>New York    </person>>"); }    public static void main (String args [ ] ) throws Exception {             SocialNetwork sn = newSocial Network  ;        Sn.createGraph( );         JDOMElement element=parseXMLFileToJDOMElement();       // Add a node to the graph     g .addV('Person').
`