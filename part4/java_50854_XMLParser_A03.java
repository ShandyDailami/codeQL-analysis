import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
import java.io.*;
// import other necessary libraries here if needed, e.g: Import for XML and IO related operations etc..  
public class java_50854_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException, IOException{
        // Load the xml file that you want to parse using DOMParser API in Java (part of java standard libraries).
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder builder=factory.newDocumentBuilder();     
	// Create a new document from the XML-file and load it into memory  .   
     //XML file is assumed to be on classpath, you can replace with your own path if needed  
	Document doc = builder.parse(new URL("http://example/sample_maliciously.xml").openStream());     
	// get the document element which represents root of an XML Document .   
        doc=doc.getDocumentElement(); 
         // use DOM API to parse through this 'document' and navigate it as per requirement  
	System.out.println("Root Element: "+doc.getNodeName());     
	// get the text from specific tags/nodes, e.g., print out tag name for all <student> nodes .   
	for(int i=0;i< doc.getElementsByTagName("students").getLength();i++){     //assuming "students" is a child of root  
         System.out.println("\nStudent: ");      
	 NodeList n =doc.getElementsByTagName ("name");  /* assuming each student node has '<name>' tag */   
        for(int j=0;j < n.getLength();j++){      //print name of all students  
            System.out.println("Student Name: "+n.item(i).getTextContent());  }     /* print names if student has 'name' tag */   
        }}         
	System.exit(0);// Exit program gracefully        
}}       //end main method      .