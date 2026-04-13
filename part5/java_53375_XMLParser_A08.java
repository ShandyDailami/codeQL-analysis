import java.io.*; // For File I/O operation  
import javax.xml.parsers.*;  // Provides the API for parsing XML content into DOM tree structure (No external frameworks needed)   
import org.w3c.dom.*;     // Define Document interface and ReqDOMParser in Java, provides an easy way to access document elements  

public class java_53375_XMLParser_A08 { 
	 public static void main(String[] args){        
	        try{            
		        File inputFile = new File("src/main/resources/company.xml"); // replace with your file path     
			    parseEmployees(inputFile);  										// calling the function to read and print XML data    	      	 	    }  catch (Exception e) { System.out.println ("Failed parsing . . ");e.printStackTrace();}		         	       	}               						       															
			    public static void parseEmployees(File inputfile){   //define function to read and print XML data    									      	 	    try{        	                  
              DocumentBuilderFactory dbFactory =DocumentBuilderFactory .newInstance ();           
             DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();          			 		     	     								         	       	// Create a new parser   						  	} catch(ParserConfigurationException pce){System.out.println ("Failed configuration..");pce.printStackTrace() ; }    	 	catch (SAXException e) {e . printStackTrace ();}
}        //end of main method                                          		 	       			         	    })}});   }}// End unique Vanilla XMLParser example program in a Academic style