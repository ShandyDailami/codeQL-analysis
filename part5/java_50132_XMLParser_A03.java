import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_50132_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{ 
        String xmlFile = "resources/input.xml"; // Path to your XML file here    
          try (Stream<?> stream = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/%s".equals(xmlFile) ? "/input.xml" : xmlFile))) { 
              DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
               DocumentBuilder builder =  factory.newDocumentBuilder();   
                // parse the input file into a DOM tree    
                 Document doc =  builder.parse(stream);       
                  NodeList nodeList=doc.getElementsByTagName("*"); 
                   for (int temp=0;temp<nodeList.getLength();temp++) {        
                    System.out.println(((Element)nodeList.item(temp)).getTagName());     // prints out all element names   } });    }}`}))))).replace('\n', '');  }) .substringAfter("