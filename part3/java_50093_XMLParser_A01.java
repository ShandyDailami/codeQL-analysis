import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_50093_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        String xmlFile = "/path/to/yourXMLfile"; // replace this with your actual file path 
  
        FileReader fr = new FileReader(xmlFile);            
          
        XMLParser parser=ParsingConfig.getSAXFactory().newSAXParser();                
          Document document;        
      try {           
              document =  parser.parse(fr);               //Parse the file and return DOM tree  
       } catch (Exception e) {   
           System.out.println("Error in parsing XML: " +e ); 
                   throw new RuntimeException();       
          };     finally{      fr.close();}        
                DetailHandler handler =new DetailHandler(document);              //creating a SAX parser           
               parseElement ( document,handler,"");    }//call method to start parsing from root      
  private static void parseElement ( Node node ,DetailHandler dh) {      if ("element1".equalsIgnoreCase((node.getNodeName())))     {" + "your code for element1"+"}              else          //otherwise, recursion           dp=new Detail(dp);            
   }    public static class  DetailHandler extends DefaultHandler{               private Node current ;            @Override        public void startElement (String uri , String localName ,       String qName , Attributes attributes)throws SAXException      {              //Start Element Called          if ("element1".equalsIgnoreCase(localName))        
   }  });     }}`;