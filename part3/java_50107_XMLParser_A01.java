import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_50107_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, IOException{  
        // Parse the XML file using standard library (DOM and SAX parsing are not allowed in this context). 
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
         DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();      
         
         try(FileReader reader = new FileReader("sample.xml")){   //read XML from file   
             Document document =  dBuilder.parse(reader);      //Parse the content into DOM  object              
             
            getElementValue(document,"/books/book"));     //Call function to print element value using XPath expression ("/books/element") on main node           }   catch (Exception e){       System.out.println("Parsing failed");    }}         
         public static void  getElementValue(Document doc, String SelectXpath) {      Document  doc2=doc;//assign document to a new variable        try{              XPathFactory xpf = XPathFactory.newInstance();            XPath xp =xpf .newXPath();                //Create an instance of the default object         Node n=  (Node ) xp.evaluate(SelectXpath,doc2 ,XPathConstants.NODE);         
             if (n != null) {           System.out.println("Value is :"+ ((Element)(n)).getElementsByTagName("title").item(0).getTextContent());} else{System.out.println ("No MATCH");}}      }       catch  (XPathExpressionException e )  
         {{e .printStackTrace(); }}        //Catch Xpath exception for handling exceptions          System.exit(-1);    };     finally {            try             {@SuppressWarnings("unused") Document new_doc= dBuilder .newDocument(null, "sample.xml"); } catch (Exception e) 
         {{e   .printStackTrace();}}; }} //Always close the document at end to avoid resource leaks    };     System.out.println ("End of program!");}          @SuppressWarnings("unused") private static void printDocument( Document doc ) { try             {@SuppressWarnings({"rawtypes", "unchecked"}) Iterator it =doc .getElementsByTagName ( "*" ).iterator();while 
         (it.hasNext())           System.out.print ("\n节点名称：" + ((Element)it.next()).getNodeName());} catch(Exception e){e   . printStackTrace()}}; }    }; //Print all node names in document at end of program  }}