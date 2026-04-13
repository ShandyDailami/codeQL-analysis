import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_43651_XMLParser_A08 {
    public static void main(String[] args) throws Exception{  
        // Check if files exist and can be read otherwise exit program 
        for (int i = 0; i < args.length; i++){    
            File file = new File(args[i]);      
             if (!file.exists() || !file.canRead()) {   
                 System.out.println("File not found or can't be read: " + file); 
                 return;   }          // If the above condition is true then exit from program     
        }}     for (int i = 0;i<args.length ;i++){       String xmlfile= args[i];    try{         SAXParserFactory spf =SAXParserFactory.newInstance();             SAXParser sp  =spf.newSAXParser( new DTDValidator());        XMLReader xr=  sp.getXMLReader();      System.out.println(" Parsing Complete...");     // Read the xml file   
         Reader rd =null;  try{rd= new InputStreamReader ( new FileInputStream(xmlfile));}catch (Exception e) {System.err.println ("Failure in creating reader"); return;}      xr.setContentHandler((SAXHandler)new SAXHandler());     // Start parsing xml file   
         System.out.print(" Parsing " + xmlfile );          sp.parse(rd, 1);   } catch (Exception e){        System.err.println ("Failure in the parse operation"); return;}}// end of try-catch block for reading and parser exception handling`      // Catch any errors while parsing
}           private static class SAXHandler implements sax.ContentHandler {  @Override public void startDocument(){System.out.print("Start Document\n") ; }@ Overridepublic void endDocument()    {}         System. out .println( " End of XML File" );   //Print the document ends
        protected virtualvoid StartElement (String namespaceURI, String localName , 
      string qualifiedName)throws SAXException{System .out.. println ("Start Element : ") ; }@ Override public void endElement    () throws     S A X Exception { System. out .println(" End of an element" );} @Overridepublic   virtualvoid characters (char [] ch, int start , 
      int length)throws SAXException{System.. println ("Characters : " + new String(ch,start ,length));}}`//SAXHandler class end //XML parser code ends here. For security-sensitive operations related to A08_IntegrityFailure in this context use only standard Java libraries and do not import any third party framework