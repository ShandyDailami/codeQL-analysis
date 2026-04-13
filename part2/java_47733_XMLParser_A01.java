import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // Import InputSource and OutputSource classes to read/write files using FileInputStream and FileOutputStream class java_47733_XMLParser_A01 void parseXML(){   
try {    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
        
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();   // Create a new document builder                
         
        InputSource is = new InputSource(new StringReader("<data><record>Data1 Data2... </item> < / record > "));    
                  
        Document doc  =dBuilder.parse(is);               
      
         doc.getDocumentElement().normalize();    // Normalise the document by adding missing nodes  and attributes to XML          
         
        NodeList nodeList =doc.getElementsByTagName("record");   // Get all <product> node elements     
                  
             for(int temp = 0;temp<nodeList.getLength();temp++){    
                 System.out.println("\n Record: " + (temp + 1));          
                  Node node = nodeList.item(temp);           
                         if(!(node instanceof Element))    // Checking whether the item is a element or not         
                          continue;  
                       
                    List<Element> dataElements =  ((Element) node).getChildNodes();  /// Get all child nodes of record, and we're assuming it has <item>  here.     You may need to modify this part according your actual XML structure    // Do something with the element or print out their text  
                                                                }     
        System.out.println("\n End Record...\n");  }} catch (Exception e) {e.printStackTrace();}};`![](https://i.imgur.com/fLRM1ni.png")]](http:/www.googleplus. com), Google+