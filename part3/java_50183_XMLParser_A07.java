import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_50183_XMLParser_A07 {  
  public static void main(String[] args) throws ParserConfigurationException, IOException{   
     // Create a new factory for the XML file       
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
      
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();         
  
      /* parse using DOM parser */ 
      System.out.println("Parsing complete in directory : " + new File(".").getCanonicalPath());             
    // Read the XML file    	        		          			            					                	       	 	   				      	     								       						         ​   }} catch (Exception e) {  fprintf(stderr, “%s: %s.\n", argv[0], e->message); exit(-1); }}
      //parse the content of the file   	    		          			            					                	 	   				      	     								       						         ​   }}} catch (ParserConfigurationException pce) { System.out.println(pce.getMessage());  fprintf(stderr, "Usage: %s filename\n", argv[0]); exit(-1); }}
      try{           	    		          			            					                	 	   				      	     								       						         ​   }}} catch (Exception e) { System.out.println("Error in parsing the XML file");  fprintf(stderr, "Usage: %s filename\n", argv[0]); exit(-1); }}