import java.beans.XMLEncoder;   // JAXP's Encoder class java_42733_XMLParser_A03 javax.xml.parsers.*;     // Java parser classes     
import org.w3c.dom.Document;      
import org.apache.commons.lang3.StringEscapeUtils; 
public class Main {         
private static final String[] injectionList = {"password", "username"};  
static void removeSensitiveData(Node node) throws Exception{     // Recursive function   
for (int i=0 ;i<node.getChildNodes().getLength();++ )             
if ("text".equalsIgnoreCase(((Element) 
node).getTagName()) {      
String text = ((Text)  
 node ).getTextContent() ;     // Retrieve the Text       
// Remove Sensitive Data from Items    in Injection List     
for ( String s : injectionList ){                 
if (-1 !=text.indexOf(s)){                    
System.out.println("Found sensitive data "+ text);   }  else break;       // If no match, exit the loop        
}        if(-1!=text.indexOf('\n')) {                  
break;}                for (int j = 0 ;j<node.getChildNodes().getLength();++ )     
removeSensitiveData( node .getChildNodes()  [i] );     // Recursion          }    else continue;   }}// Continue to next Node      
}             public static void main(String args[]){         try {        DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();      FactoryResolver resolver=factory.getNamespaceResolver() ;  resolved .addNamespace("a", "http://apache.org/xml");    // Adding namespace to it    
resolver .addNamespace("b","http://www.beanshell.com/ns/bsf/1.0");      Factory registry = factory.getRegistry();       XMLReader reader=registry.newSAXReader( );         removeSensitiveData (reader   .getDocumentElement()); }} 
catch { System.out.println ("Caught an exception while parsing the document.");} } // End of Main method    });}}}}}`    ^_(_)| |/ _. _ __ \\ V /\n'__\\_\\_ `._ `/\t \'_ x __   , . '\r '.  '/.