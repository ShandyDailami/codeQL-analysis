import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class java_50908_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{  
        String fileName = "students-sample.xml";  // replace this with your xml filename      
        
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     
            SAXParserFactory spFactory = (SAXParserFactory)dbFactory;          
            
          try {               
              SpanningReader source = new File(fileName);       
              
              // Create a new instance of the parser 
                  SAXParser saxParser  =spFactory.newSAXParser(source);     
                  
            MyHandler myHandler= new MyHandler();   
            
           // Parsing elements  
                System.out.println("Parsing complete\n");        
              saxParser.parse(fileName,myHandler) ;       }  catch (IOException e1) {     
                      e1.printStackTrace();        }}          private static class MyHandler extends DefaultHandler{    @Override public void startElement   (String uri , String localname     , String qname           )throws SAXException         { System . out .println ("Start Element: " +localname); } 
@Override      public       void endElement(String uri,          String localName        , String QName) throws            SAXException{System.out.println("End element :"+QName );} @SuppressWarnings({           // suppressing warning on usages of the deprecated methods    "unchecked")
      public       void     characters(char[] ch, int start ,        int length)throws          SAXException {System . out.println ("In Element: " + new String (ch,start,length));}}}`  }   This code reads an xml file using a built in `SpanningReader', then uses the Sax parser to parse this XML data and print it when we find different elements within our document/file structure