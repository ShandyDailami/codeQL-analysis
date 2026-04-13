import javax.xml.parsers.*;
import org.w3c.dom.*;  // for DOM manipulation etc..   
import java.util.*;   //for List operations...    
       ...        
public class java_47910_XMLParser_A03 {     
 public static void main(String[] args) throws ParserConfigurationException, SAXException{          
          DocumentBuilderFactory factory =            
              DocumentBuilderFactory.newInstance();           
          DocumentBuilder builder =  factorie . newDocumentBuilder();    // create a document...        
     ...  /* parse the XML file */  
      Element rootElement;                         
       List<Person> personList=null ;                
           try {                                                      
               doc =builder.parse(new File("input_file"));                 
                   rootElement =  doc . getDocumentElement();        // find element with name "persons"    
                            ...                             /* extract data */   
                           } catch (IOException e)  {  
                          System.out.println ("Failed to parse the XML file.");          return;       }}                   
                                                      else if(personList==null){           personList = new ArrayList<>();                try{                 //extract 'name' and 'age'.     
                                                                    rootElement =  doc . getDocumentElement() ;    
                         XPath xp =XPathFactory.newInstance().newXPath;                  String expr=".//person";  List<Node>  nodes=  (List)xp.evaluate(expr ,doc,       NamespacesImpl.getDefaultNamespace());   // select all 'persons'            
                            for(int i = 0 ;i <nodes .size(); ++i){                      Node node =    ((Element )     nodes.get(  I)). getElementsByTagName("name").item (I);        String name=node.getTextContent()      ... //Same with 'age'.}}                    
                                  catch (Exception e1) {System.out .println ("XPath evaluation failed."); return; }               }}                  });                          };    */  /* if we have parsed the file successfully, go ahead and print out data...*/   try{       String expr=".//person"; List<Node>  nodes=  xp.evaluate(expr ,doc, NamespacesImpl .getDefaultNamespace());       
                                                                                 for (int i = 0;i <nodes  .size(); ++I){                       Node node =    ((Element)     Nodes). getElementsByTagName("age").item( I);         String age=node.getTextContent()       System.out.println ("name: "+ name + ", Age:"+ 
   age ); }} catch (Exception e1 ) {System . out …..“XPath evaluation failed”; return;}                }}}};    /*if not, print an error message*/          if(personList==null){                           System.out.println ("Failed to parse the XML file.");               try{                     //parse again                 
                                                                            doc =builder   .parse (new File("input_file"));                      rootElement=doc 。getDocumentElem…ent();     String expr= “./person”; List<Node>  nodes =  xp.evaluate(expr ,do...}}                 catch (Exception e1) {System.. out ("XPath evaluation failed."); return;} }}}}