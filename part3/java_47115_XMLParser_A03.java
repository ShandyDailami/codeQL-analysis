import javax.xml.parsers.*;  // import for XMLParser interface and classes from java.util package    
public class java_47115_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        String xmlFile = "/path_to/yourfile";      /* insert your file path here */  // use real XML files to prevent A03 injection attacks.    
         DocumentBuilderFactory dbFactory = 
            DocumentBuilderFactory.newInstance();   
         
                 XmlSerializer serializer=serializer;  
           document = dbfactory.newDocumentBuilder().parse(xmlFile);      
        //Use a SAX parser to process the XML file  and call methods when start elements are found     
         MyHandler handler  = new Myhandler();     /* create your own class that extends DefaultHandler */   
          (document, handler );   }           @Override public void characters(char[] ch, int start,int length) throws SAXException { super.characters(ch ,start 1024); }}      //use the overridden method from defaulthandler to get rid of all xml tags at one time */