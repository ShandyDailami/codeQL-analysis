import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
  
public class java_50177_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{ 
        // Load the XML file using DOM parser (This is recommended way in JAXP for parsing xml files.)          
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
         DocumentBuilder builder =  factory.newDocumentBuilder();   
         
         String path="src/example1.xml";  //Path of your XML file here .     
                   
        System.out.println("Parsing complete in directory : " +path );      
                 
           try {           
             Document doc = builder.parse(new File(path));   
              
              printElementListWithIndentation(doc,0);   //Prints all elements under root node         
        } catch (SAXException e) {     
                System.out.println("Parsing failed - the document is not well-formed.");        
                  try {    
                        DocumentBuilderFactory builderfactory = BuilderFactory.newInstance();   
                         int error_line_number=0;  //Error line number while parsing xml      
                     DOMParser parser  = (DOMParser)builderfactory .newDOMParser(null);  
                      
                      System.out.println("Parsing failed - could not find the document element.");     }                  catch (Exception e1){          println ("Couldn't instantiate DocumentBuilder: " +e );            return;      }}  //prints line number       except SAXParseException {  
        System . out.println("Line Number :"+ error_line_number);                                                       }     try{         XMLReader reader =Documentbuilder factory.. newXMLreader (null,Handler) ;    println ("Couldn't create an instance of Document builder."); return;  }} catch(Exception e){   System . out.println("Error occurred in parse: "+e );}} //Ends parsing try-catch
      }     private static voidprintElementListWithIndentation (Node node, int indent) {    if (!node instanceof Element ){return;  }} else { NodeList children =   ((Element)((org.w3c.dom .Node))).getElementsByTagName("*"); for      each    
          } // Ends print element list with Indetation method            indent++;}//Print node name and its value           if (indent==0) {System.out..println((node ).getTextContent());}else{for(int i=1;i<indents ;    int c = 0);   for 
          } // Ends print element list with Indetation method            indent++;}//Print node name and its value      }}catch (Exception e) { System.out .println ("Error occurred in parse: "+e );}}     end of main function}`;