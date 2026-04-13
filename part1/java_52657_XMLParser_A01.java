import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
  
public class java_52657_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String url = "http://example.com/books.xml"; //replace with your URL          
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
              
        try {            
            DocumentBuilder builder =  factory.newDocumentBuilder();                        
            Document doc =builder.parse(new URL(url).openStream());                     
                   
            NodeList books =doc.getElementsByTagName("book");              //replace 'tag' with your actual tag name                 
               for (int i=0;i<books.getLength();i++) {                
                Element bookElement =  (Element) books.item(i);            
                   String title  =   bookElement.getElementsByTagName("title").item(0).getTextContent();        //replace 'tag' with your actual tag name                 
                    System.out.println ("Title : " + title );                }       }} catch (MalformedURLException mue) {             e1.printStackTrace();               try{                 DocumentBuilder builder =  factory .newDocumentBuilder() ;                         Document doc =builder  .parse( new URL("http://example/books.xml").openStream())              )                   
            System.out.println ("Parsed XML content: " +doc );}} catch (ParserConfigurationException pce){             e2.printStackTrace();               }catch (SAXException se) {                // Handle any SAX exception  }}        try{                 DocumentBuilderFactory factory =DocumentBuilderFactory .newInstance() ;                    
            System.out.println ("Parsing with Document Builder Factory");                   for(int i=0;i<15;i++){                      String name=  doc .getElementsByTagName("name").item (i).getTextContent();                       Address add =doc  .getElementsByTagName("addresses"). item(j) getElementbyId ("street" + )                }} catch {