import java.io.*;   // For FileInputStream and InputStreamReader
import org.xml.sax.*;    // Import SAX API (Simple API for XML)
import javax.xml.parsers.*;      // To parse the xml file using DOM parser, JAXP is required 

public class java_44666_XMLParser_A08 {  
     public static void main(String args[]){          
          try{              
              FileInputStream fis = new FileInputStream("inputfilepath");    // Input stream to read XML data from a source                  
	       SAXParserFactory saxpf=SAXParserFactory.newInstance(); 
     	      SAXParser sp=saxpf.newSAXParser();  
    	        MyHandler mh = new MyHandler ();          
              // parse the xml file using DOM parser           
               sp.parse(fis,mh );    //invoke handler for start element      	        	   		         			     	     									  } catch (Exception e) { System.out.println("Error parsing XML "+e); }}   cathc Exception{System out println ("An error occurred" + $_exception)}