// Import necessary classes from java library   
import javax.xml.parsers.*;  
import org.w3c.dom.*;  
import org.xml.sax.*;  
    
public class java_46297_XMLParser_A03 {  // Define a public main method for the program to execute on     
      
           /* The parseDocument function parses an XML document and extract data from it */   
        static void Parse(String file) throws ParserConfigurationException, SAXException{  
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     // Create a factory for our DTD/XML documents      
            
           /* Builder is used to process an XML document represented as DOM tree */   
        	DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder(); 
  		     
            System.out.println("Parsing the input file: " + file);     // print a message in console for now (just testing)         
             /* parse from an XML file and store result in DOM tree */         Document document = dBuilder .parse(new File(file)); 
              doSomethingWithDataInDocument(document.getElementsByTagName("A"));   }     // call method to process our data using DO SOMETHING WITH DATA IN DECENT FORMAT      public static void DoSometingWIthDOmElement (NodeList n) { 
        for (int i = 0; i <n.getLength(); ++i ){   doSomethingWithDataInDOMNode( n.item(i));    }     // call method to process our data using DO SOMETHING WITH DATA IN DECENT FORMAT      public static void DoSometingWIthDOmElement ( Node node){ 
            System .outprintln ("Parsed XML File");          return;         }}        /* main function */    // define a 'main' method for the program to execute on     public static void Main(String args[]) {      try{   Parse("A03_Injection.xml") ; } catch (Exception e){ System .outprintln ("Error parsing XML: " +e); }}