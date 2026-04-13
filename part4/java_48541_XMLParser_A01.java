import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
  
public class java_48541_XMLParser_A01 {   
     public static void main(String[] args) throws ParserConfigurationException, IOException{       
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();         
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();          
            
         // parse the XML file           
         Document doc =dBuilder.parse("inputFile.xml");             
               
         XPath xpath = XPathFactory.newInstance().newXPath(); 
              
          String expression="/Users/userdata/*";       
                  
           NodeList nodeList =  (NodeList)xpath.evaluate(expression,doc ,XPathConstants.NODESET);  
            
         for (int temp =0;temp <nodeList.getLength();temp++){   	    	   		     	       			 									      	      //prints user names and password                       	 						          }                         .println("User Name : " + nodeList[i].getTextContent());                                  System.out.println(“Password:”+ nodeList[j].getNodeValue())
         ;  	    	   		     	       			 									      	      //closes the reader and file    };        }             catch (Exception e) {            console all exception details;              try{if (!doc.hasChildNodes() || doc.getFirstChild().getNodeName().equals("#text"))