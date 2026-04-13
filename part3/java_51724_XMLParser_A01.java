//import necessary libraries (security-sensitive operations and standard JDK) 
 import java.io.*; //File I/O  
 import javax.xml.parsers.*; //XML Parsing Library   
 public class java_51724_XMLParser_A01 {    
      static void parse(String filename){        
           try{            
               File xmlfile = new File (filename);             
               `enter code here`// Parse XML file into DOM  
                   DocumentBuilderFactory dbFactory = 
                       DocumentBuilderFactory.newInstance();  //create a factory object   
                   `enter code here `DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();    
                  /* create an instance of the parser */     
                 'xmlParser' xmlparser =dBuilder .newDocument();  
                  ``// parse document to remove namespaces            
                //read XML content and write it using DOM style parsing       `enter code here `   
               }catch (ParserConfigurationException pce){           System.out.println("Problem configuring parser " +pce);       return;         }          catch(SAXException se) {  /*exception handling for SAX */      Console.err .println ("Problem parsing the document\n"+se );        return ;   
               //catch block to handle exceptions  
                System.out.println("Parsing XML file " + filename);     }      `enter code here `  void main (String [] args){         String xmlfile =“C:/wamp/www//sample.xml”;      parse(xmlfile );    // call method Parse on an example .XML document         
            }}