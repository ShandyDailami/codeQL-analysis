import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_52814_XMLParser_A01 {  
    public static void main(String args[]) throws ParserConfigurationException, IOException{    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();            
       // disable entities & external styles for better security here         
		//dbFactory.setValidate(false);  
		  /* Call loadFile() method to parse the xml file */   
	        readXMLfile("A01_BrokenAccessControl/src/main/java/datafiles/" + "sampleData");            
       }     
     static void readXMLfile (String filename) throws ParserConfigurationException, IOException {             
            Document doc = dBuilder.parse(new File(filename));                  //Parse the xml file         
           /* Accessing data from parsed XML document */   
                NodeList nodeList=doc.getElementsByTagName("SampleData"); 	// Get all <sample> tags      
			for (int temp = 0; temp <nodeList.getLength();temp++) {	   // Iterate through each tag           	 			    					      }        						    }}              	}             if(dBuilder !=null ){ dBuilder .detachNode((Element) node);} 
                Node List = doc.getFirstChild();                        	// Get the first child of xml file                 		if (List == null){System.out.println("No Data found"); } else { System.out.print(dtoString());}}   }}    try{ if (!doc.hasAttributes()) throw new Exception (" " +
                ");  // Accessing and printing attributes in XML document */     Node N = doc .getFirstChild();      while (N != null){         /* Print all the node names under root element*/	 System.out.print( ((Element)    N). getTagName() );          } else {System..println("Does not have attribute");}}}