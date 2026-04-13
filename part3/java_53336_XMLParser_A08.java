import org.w3c.dom.*;
import javax.xml.parsers.*;
public class java_53336_XMLParser_A08 { 
    public static void parse(String file) throws ParserConfigurationException , IOException{  
        // Create a new factory for DOM parsing using the W3C standard mode    
           DocumentBuilderFactory dbFactory =      
              DocumentBuilderFactory.newInstance();        
          DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();     
           
          /* parse an XML file into the tree constructed by this builder */       
             Document doc =  dBuilder.parse(file);  
              
           // print out node and attribute information from parsing   
              printNodeInfo(doc, null);    
       }  @SuppressWarnings("unused")      private static void printNodeInfo (Document document , Node node) {         if (node ==null ){          return;        else   //printing all the nodes information and attributes of a element.                System .out .println ("Start Element : " +      
              ((Element)node).getTagName());  for(int i = 0 ;i<((NamedNodeMap) node).getLength();++i){               printNodeInfo (document ,     ((NamedNodeMap )      document    ).item(   i));         }        System .out.println ("End Element : " +node.getTagName()); 
              if(!Modifier.isStatic(((Element)(node)).getMethod().getReturnType().getDeclaringClass())){          //check whether it is a class method or not      
                  for (int i = 0;i< ((Constructor) node).getNumberOfParameters() ; ++i){                System .out      .println ("Parameter : " +((Invocation)    `node   ).getMethod(). getName    ()+" -> type='"       +  //printing all the parameters information.
                  (Class )  ((Constructor)( node).getParameterTypes()) [ i].getName());       }            for      while(true){               System .out             .println ("Catch : " +   document          .createElement    (' Catch'). getTextContent () );                 break;              }}     catch        {
                try{                  //catch block information.                    if (((Block)node).getNumChildren() > 0 )  system      out         .println("Start Block: "); printNodeInfo(document, ((Block)( node)).       childNodes(). nextSibling());                   System             ..println ("End   Blcok : " +     document          .createElement (' Catch'). getTextContent () ); } catch (Exception e){
                  //catch block handling exception information.                    system out         println("Caught Exception: ");    throwableTree(e).printStackTrace();}}                   return;                 }}  };