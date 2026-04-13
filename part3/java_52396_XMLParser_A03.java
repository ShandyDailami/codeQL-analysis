import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;
public class java_52396_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String xmlFile = "sample.xml"; // replace with your file path and name here         
        
            File inputFile =  new File(xmlFile);     
             if (!inputFile.exists()){ 
                 System.out.println("Input XML file not found!");                 
               return;   }   
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();      
            try {         
                SAXParser saxParser =  saxParserFactory.newSAXParser( new InputSource(new FileInputStream(inputFile)) );             
             // create an instance of the handler that will receive parsed information  and call parse() method when startElement is called (for example)              
            MyHandler myHandler = new MyHandler();     
                saxParser.parse( inputFile,myHandler);    }       catch (IOException e){         System.out.println("Unable to read the file " +inputFile+". Make sure you have the required permissions and try again");     return;   }}  //catch block for handling exceptions         
public class MyHandler extends DefaultHandler {      @Override public void startDocument() {}@Override public void endDocument(){System.out.println("End of XML Document reached.");}    /* implement other necessary methods like: */       protected void startElement(String uri, String localName,  //declare types for parameters in the method declaration        
                                                     String qName , Attributes attributes) throws SAXException{ System.out.print ("Start element : " +qName); }     @Override public void endElement (String uri, String localName,   /* implement other necessary methods like: */       
      protected void characters(char[] ch, int start,int length){System.out.println("Characters in XML Data:"+new String(ch,start,length));}}  //printing the data read from xml file on console}    }