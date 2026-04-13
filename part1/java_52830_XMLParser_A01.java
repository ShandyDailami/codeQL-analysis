import java.io.*;  // Import InputStream and OutputStream classes  
import javax.xml.parsers.*;  // The XML parser API   
import org.w3c.dom.*;  // W3C DOM (the standard API)     
import org.xml.sax.*;  // SAX (Simple API for XML)      
    
public class java_52830_XMLParser_A01 {  
         public static void main(String[] args){       
             try{           
                 // Read the xml file          
                 DocumentBuilderFactory dbFactory =   
                     DocumentBuilderFactory.newInstance();         
                 
                 DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();             
                                                     
                InputSource src  = new   InputSource(new StringReader("<data><student name='John' age='21'/></data>"));        // input string          
                                                                    
               /* parse using the built-in DOM parser */         
                 Document doc = dBuilder.parse(src);               
                  ContentHandler chandler =  new MyContentHandler(); 
                   doc.getElements().iterator() ;    printElement (doc, "");   }              catch (Exception e){      System.out.println("Parsing failed.....");        e.printStackTrace();     }}          @SuppressWarnings({"rawtypes", "unchecked"})            public static void 
               printElement(Node node , String indent) {           // method to display the XML tree              for (int i = 0; i <   nodes .getLength() ;i ++ ){             Element element =   
                   (Element)nodes.item(i);                      System.out.print(" ");                       if  ("student".equalsIgnoreCase((element).getAttribute("name"))){                    String value="Value is : "+  ((Text)   node ).getText();System . out     .println     
                  indent +value ; }                         printElement( element.getFirstChild(),indent +  "\t");  }}        @SuppressWarnings({"rawtypes",    "'unchecked'"})            public static void main (String[] args) { XmlParser   xml  = new     XmlP