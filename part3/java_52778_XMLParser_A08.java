import java.io.*; // Importing for Input and Output Streams, BufferedReader to read the files line-by-line...    
         import javax.xml.parsers.*;    //Import JAXP parsers..      
         
public class java_52778_XMLParser_A08 {  
  public static void main(String[] args) throws ParserConfigurationException, IOException{     
           File inputFile = new File("inputfilepath");    
	            DocumentBuilderFactory dbFactory = 
                    DocumentBuilderFactory.newInstance();    //Creating the document builder factory...        
                  DocumentBuilder dBuilder = 
                      dbFactory.newDocumentBuilder();      
		  
                   Document doc = dBuilder.parse( inputFile );     
             System.out.println("Root element : " +doc.getElements().getNamedItem("xml"));  //To print the root of XML document...        
              }   
}