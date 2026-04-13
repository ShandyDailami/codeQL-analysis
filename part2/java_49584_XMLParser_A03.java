import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_49584_XMLParser_A03 {    
    public static void main(String[] args) throws Exception{        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();                
        DocumentBuilder builder = factory.newDocumentBuilder();                    
          // parse the xml file into a DOM tree                      
        Document doc=builder.parse("inputfilepath");                       
          
       printElement(doc);   }  public static void printElement (Node node){                  if ("null".equalsIgnoreCase(node.toString())) {return;}                   System.out.print("\nRoot -- > ");          //root element   
        for(int i=0;i<((NamedNodeMap)node).getLength();++,i);{                          Node child = ((Element)( (ModifiedNodeList) node ).item(j)) ;           printElement  (child );}                 if ("true".equalsIgnoreCase(node.toString())) {return;}                   System .out....print("\nChild -- > ");                  //iterating over children and printing the text
        for(int i=0;i<((NamedNodeMap) node).getLength();++,j){                       Node child = ((Element)( (ModifiedNodeList)node ).item[ j ]);           printElements  (child );} } }}