import org.xml.sax.Attributes;   // SAX parser: Simple API for XML Parsing    
import javax.xml.parsers.*;      // ParseXML Java Library      
import java.io.*;                // I/O Stream Example           
public class java_53450_XMLParser_A03 {   
 public static void main(String args[]) throws Exception  {  
        try{              
             XMLParser();         
         }catch (Exception e){    
              System.out.println("XML Parsing failed with following exception: "+e);      
            //Handle the error properly here, for example by logging or throwing as appropriate in a real system   
           };  
  private static void XMLParser() throws ParserConfigurationException {     
        String inputFile = "/path/to/yourfile.xml";    
          Reader file  = new FileReader(inputFile);       // Read your xml into memory           
             SAXParserFactory spf = SAXParserFactory.newInstance();    /// Create a factory for the parser 
              SAXParser saxParser =  spf.newSAXParser(true, true );  
               MyHandler myHandler  = new MyHandler ();         // Define your custom handler     
                saxParser .parse(file ,myHandler ) ;        // Parse through XML document      
  }    
}    public static class MyHandler extends DefaultHandler {         
           private int nesting;   /// <--- Use this for tracking depth of tags.                     
              StringBuffer sbf   = new StringBuffer();         // Buffer to hold our string data           
             @Override        /** This method is called when start tag encounters */    public void startElement(String uri,  String localName ,    
                            String qName, Attributes atts)      {       nesting++;           sbf.append("start_tag"); // Print tags and attributes         
             System.out.println ("Start Element : " +qName+" at depth "+nesting);         for(int i = 0 ;  i < atts.getLength();i++)        {       String name =     atts.getQualifiedName(i),value=atts.getValue(i)}; sbf .append(" Attribute: [" +name  + " :" +  value+"]");   }   
             /** Called when end tag encounters */      public void endElement (String uri, String localName ,    
                            String qName ) { nesting-- ;sbf.append ("End_tag:" ); System.out.println((" End Element : " +qName+" at depth ")   +nesting); }   /** Called when text is encountered */      public void characters (char [] ch, int start,int length)  { sbf .append ("Text: "); String str= new String(ch ,start ,length ); System.out.println("Characters : " +str);}   
             /* The following methods are callbacks for the parser to provide */     public void endDocument ()   {      // This will print out all data once more document has been parsed       sbf .append ("End_document");  }            }; System.out.println(("XML Parsed : " +sbf ));
}