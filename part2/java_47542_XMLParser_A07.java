import org.w3c.dom.*;   //DOM operations (not security)      
import javax.xml.parsers.*;//XMLParser interface in JDK10 and above version          

public class java_47542_XMLParser_A07 {           
          public static void main(String[] args){              
              try{               
                  DocumentBuilderFactory dbFactory =   //DOM operations (not security)                
                      DocumentBuilderFactory.newInstance();                  
                        
                  DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();// DOM operation not required at all in this case                   
                         
                  org.w3c.dom.Element docElem; 
                           //DOM operations (not security)                
                      docElem =dBuilder.parse("sampleFileURL").getDocumentElement();   //parsing the XML document, replace "yourxmlfile" with file location                    
                          .normalize();//for normalizing all elements in case of errors                  
                  printElement(docElem);          
              }catch (Exception e){                    System.out.println("Error parsing xml");             //handling exception                      };   }}  Catch Exception here as we can't make sure the file location is valid and replace "sampleFileURL" with real path of XML document or URL pointing to it if available
                                                            
     static void printElement(Element elem) {        /*not security sensitive*/      //print all nodes recursively            try{               System.out.println("------------------------");                     }catch (Exception e){}  DocumentBuilderFactory dbFactor = null;                    XMLParser parser=null;}                if ((dbFactor==null))
             docElem  =elem ;                        /*not security sensitive*/                   printNode(docElem);}}                 catch (Exception ex) {System.out.println("parse error");}                  }catch  //providing exception to handle all errors in the code */   try{printElement((Document) elem );       
     static void printNode(Node node){                /*not security sensitive*/               System.out.println("\t : "+node.getNodeName());                    if (node.hasChildNodes() ) {for  each children              //Print all the nodes recursively            try{                     Node next =    null;
                  while((next=(element) .iterNext()))   printElement ((Document) node); }}}catch /*providing exception to handle error in this block*/ (Exception ex){System.out.println("printNode Error");}                   }} catch  // providing the Exception here for handling any errors */