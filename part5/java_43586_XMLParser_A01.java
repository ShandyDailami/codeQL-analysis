import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_43586_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    	
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();         
        		      			 									     						  	 								   	   	     	       							 }          
                                                            @Override                                        public void startElement(String uri, String localName, String qName) throws SAXException {                  	            	if (qName .equalsIgnoreCase ("employee")){                  employee = new Employee();              		 	}            else if (qName.equalsIgnoreCase("id") )    	{        	 	    System.out.println("\n ID :");          	      }          ...