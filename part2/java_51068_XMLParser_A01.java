import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_51068_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();            
        DocumentBuilder builder = factory.newDocumentBuilder();      
             
        // Parse the XML file     
        Document doc = builder.parse("inputFilePath");         
                  
        printElement(doc, "root/child1", null);  --> to display 'A' and then for next line move towards second level indentation: below root > child2      
                                                                     (it is a simple example)        
    }  
          
    static void printElement(Document doc , String elementName, String tabulation){                 
        Element elem = doc.getElementsByTagName("element").item(0);  --> replace 'element' with actual xml tag name     
          if (tabulation == null) {              
            System.out.print(elem.getTextContent());          
         } else{                
             for(int i = 1;i<= tabulationLevels ; ++j){  
                tabs += "\n";  --> replace 'tabs' with actual string to print indentation levels, here we are printing spaces by default (it is a simple example)    
              }    System.out .println(elem.getTextContent());      
        if(!ELEMENTS_NAMEs_.isEmpty()){             --->  Here for next level of parsing replace 'elementsNames' with actual xml tag name and also define j in the beginning  (it is a simple example)    
              printElementData_(doc,tabulation+"elementName");         }   else{                  Print.print(elem.)}        --> Finally here we are printing brackets for next line       end of code block                     
      }}