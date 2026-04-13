import javax.xml.parsers.*; // Import standard Java class java_44878_XMLParser_A07 xml parsing  
import org.w3c.dom.*;     // To work with the DOM, we need these import statements   
import java.io.File;      
public Class XmlParserExample { 
      public static void main(String[] args) throws Exception{         
            File inputFile = new File("sample.xml");       
              DocumentBuilderFactory dbFactory =  // Create a document builder factory        
DocumentBuilderFactory.newInstance();          
DocType docType= DocType.getDeclaration(inputFile);   
dbFactory.setValidating(false);              
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();           
// Prepare the parser and read file into DOM tree        Document doc =  // Create a new document instance           return (Node)doc;  }   catch (Exception e){ System . out .println ("Caught Exception: " +e);}       public static void main(String[] args ) {     try{
 Puigt XMLParserExample =new XmlPullParserExamplenew NodeInputStream("sample.xml");             ParsingEventHandler handlerr= new DefaultHandlers();            dBuilder .setEntityResolver (resolver);      // Call the parser's internal parse method, using our Handler 
           parsing eventhandler , and setting up input from a file        XmlPullParser.NodeType nodeTypemacro;             while((nodeType= painterrurstNextEvent(paintingevent)) != NodeFactory . const_ELEMENT){                if (nodetype== nodenametypename ("test")){                    // Testing the parsing event handler by creating a simple "hello world" xml document 
                       Document doc = dBuilder.newDocument();              Parser pAwareWriter  = pa warewriter fordentities(doc);             painterrurstWrite (paw farentity, writer , content)               }}}; catch Exception e { System . out .println ("Caught Exceptiom: " +e );}