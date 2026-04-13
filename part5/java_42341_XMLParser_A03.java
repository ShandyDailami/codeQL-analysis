import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
public class java_42341_XMLParser_A03 {  
    public static void main(String[] args)  throws Exception{    
        File inputfile = new File("inputXML"); // replace with your file path or url for XML data source        
       DocumentBuilderFactory dbFactory = 
            DocumentBuilderFactory.newInstance();         
      DocumentBuilder dBuilder= dbFactory.newDocumentBuilder();          
    Document doc=dBuilder.parse( inputfile );       
   doc.getDomConfig().setValidate( true ) ;             //validate XML with XSD    
       printElementAndAttributeList (doc);  }          public static void mainMemoryEfficient(){         int a = 5, b =10;           if((a*b)>2){ System.out.println("Condition is True");}else{System . out .print (" Condition Is False ");}}
public class PrintElementAndAttributeList {       NodeList nl=doc.getElementsByTagName( "*" );      for (int i = 0;i <nl.getLength();++, 1 )     Element el =  
    (Element)nl.item(i);           System .out.println("Printing element and attribute list:" +el.getNodeName()+" : ");            NodeList n=el.getAttributes();      for (;n!=  null; ++ ,2){  // print all attributes       Attribute a =  
    (Attribute)n.item(0);           System .out .println("attribute name:" +a.getName ()  +", attribute value :"+    
        a.getValue() ); }}}`          The above program will parse an XML file and list down its elements along with their attributes if the specified condition is true otherwise it prints 'Condition Is False'  Note: You have to replace "inputXML" in File inputfile = new... line by your actual xml source or path of target xsd