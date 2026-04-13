import javax.xml.parsers.*;
import org.xml.sax.*;
 
public class java_51127_XMLParser_A07 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String xmlFile = "src/main/resources/sample_file.xml"; // change this with your XML file path in resources folder of project or absolute location on hard drive 
        
            DocumentBuilderFactory dbFactory = 
                DocumentBuilderFactory.newInstance();  
            
           SAXParser parser=dbFactory.newSAXParser();    
     
        MyHandler myHandler = new MyHandler();    //creating handler object for handling the xml data;      
         
         try { 
            /*Parse XML file using built-in methods of DocumentBuilder*/  	          
             SAXParser saxParser= dbFactory.newSAXParser();    		             
                     System.out.println(saxParser);     			   	   	       	     										}catch (Exception e){System.err.println("Parsing failed --> Ex: " +e );}  // catch exception if any;  	       }                private class MyHandler extends DefaultHandler{ public void startDocument(){ System . out . println(“Start of Document”); }}