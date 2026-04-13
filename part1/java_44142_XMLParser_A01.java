import javax.xml.parsers.*; // for DOMParser, SAXParser etc..
// import org.w3c.dom.*;   Not required here because we're not calling any method on the Document object returned by these parsers   
public class java_44142_XMLParser_A01 { 
     public static void main(String[] args) throws ParserConfigurationException, SAXException{            
         String fileName = "sample.xml"; // sample XML File name (replace this with your own).  
         
        DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();   
	     DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder(); 
	       
		 DOMParser parser;        
	      try{              
                 parser =(DOMParser)dBuilder.newDOMParser();               
                  // set XML file name and read it             
                 parser.setDocumentBuildersCompatibility(
                      DocumentBuildersCompatibility.XML_BIG_LIKE);         
		 	parser.getNamespaceSupport().getDeclaredNamespace("test","http://www/example");           
               }catch (DOMException e1){           // exception handling for DOM related issues       
                 System.out.println(e1.getMessage());                     
                  return;                };     try{                   parser.setFeature(   "http://xml.org/sax/features/namespaces",true);         }catch (DOMException e2){             // exception handling for DOM related issues        println("Cannot set features");return;}  finally {parser .getDomConfig().setValidatingMode(false );}         
	       try{                 parser.parse ("sample.xml"           ),     System.out.println("\nSAX Parsing..."); }catch (IOException e){             // exception handling for IO related issues        println("Cannot parse the document");return;}   finally {parser .getDomConfig().setValidatingMode(false );}           
         try{               parser =dBuilder  .newDOMParser();           System.out.println("\nDefault Parsing..."); }catch (SAXException e){             // exception handling for SAX related issues        println("Cannot parse the document");return;}   finally {parser.getDomConfig().setValidatingMode(false );}           
     }}