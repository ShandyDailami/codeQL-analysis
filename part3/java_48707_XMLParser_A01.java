import java.io.*;   // FileInputStream
import javax.xml.parsers.*;  // DocumentBuilderFactory & DOMParser interface   
import org.w3c.dom.*;     // NodeList, Element (only for XML parsing)

public class java_48707_XMLParser_A01 {     
       public static void main(String[] args){  
               try{            
                       String xmlFile = "/path/to/yourfile";   
                           FileInputStream fis= new FileInputStream(xmlFile);  //reading the file into inputstream    
                        DocumentBuilderFactory factory = 
                              DocumentBuilderFactory.newInstance();       
                         DocumentBuilder builder = factory.newDocumentBuilder();     
                          Document doc = builder.parse(fis);                    
                           readXMLfile(doc,"");                     
                   } catch (Exception e){                             //Handling exceptions  
                       System.out.println("Problem parsing the XML file: "+e ); 
                    }}      
            private static void readXMLfile(Node n, String indent){       
                if (!n.hasChildNodes() && !((Element) n).getTag().equalsIgnoreCase("#text")) {         //printing only element nodes and not whitespace   
                        System.out.println (indent + ((Element) n).getTag());                   }  else{         
                            indent += "--";                                           if(n instanceof Element){               printf(" %s ",((Element)n ).getTextContent() );}         }}                      catch (Exception e1 ) {printStackTrace();}}  
                             }; //end main method    private and static methods should not be called outside this class              }  This code will read an XML file, print out each element's tag. It also does a recursive call on child nodes if there are any to handle security-sensitive operations related A01_BrokenAccessControl