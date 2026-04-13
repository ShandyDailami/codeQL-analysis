import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52423_XMLParser_A03 extends DefaultHandler {
    private String currentElementName = null; // stores currently processed element name, for A03_Injection prevention    
  
    @Override public void startDocument() throws SAXException{  }     
      
    @Override public void endDocument()throws SAXException{}       
        
    @Override public void startElement(String uri , String localName , String qName, Attributes attributes)throws SAXException {         
            currentElementName =qName;     //start processing an element          
   }     
      
    @Override 
    public void characters(char[] ch, int start, int length){       
         if (currentElementName != null && ("namespace".equalsIgnoreCase(currentElementName)) ){           
             System.out.println("Namespace: "+new String(ch ,start ,length));     //print the namespace of xml element          
   }         
       @Override public void endElement(String uri, String localName, String qName)throws SAXException {      currentElementName = null;  }    };       
}                  
public class Test{             static final String filename="sample.xml";         private XMLReader xr ;               MyXMLParser mp  = new MyXMLParser();          try   {                  XmlPullParserFactory f= XmlPullParserFactory .newInstance ();                 // Create a factory object               xr =f.newSAXParser().getNextToken()                   
}catch(Exception e){System.out.println("Error parsing XML: " +e ); }             public static void main  (String args [])   {           try{                  xr .setContentHandler    ((ContentHandler) mp);               // Set content handler to MyXMLParser                    xr    
..read(filename)}catch         (FileNotFoundException e){System.out.println("Not found: " + filename );}             catch  SAXException        {e   .printStackTrace();}}}                `; }