import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_45546_XMLParser_A01 {   
   public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        String fileName = "inputFile"; // Provide the name of your input xml here 
         
         Factory factory = null ;    
              
            try      {             
                factory =  XMLReaderFactory.newInstance();   
                     } catch (SAXException e1)   {       System.out.println( "Could not create SAX reader" ); return;  }       
                  switch (factory){          case XmlReader:             default : break ;         //default is needed to access the methods of XML Reader            try{                 xmlreader = factory .getXmlReader();      jsonwriter=   null;}catch(Exception e ) {System.out.println("Error in creating "+e); return; }break 
          case StAX:           default : break ;         //default is needed to access the methods of XML Reader       try{             xmlreader = factory .getXmlReader();      jsonwriter=null;}catch(Exception e ) {System.out.println("Error in creating "+e); return; }break 
          case SAX:            default : break ;         //default is needed to access the methods of XML Reader       try{             xmlreader = factory .getXmlReader();      jsonwriter=null;}catch(Exception e ) {System.out.println("Error in creating "+e); return; }break 
          case DOM:            default : break ;         //default is needed to access the methods of XML Reader       try{             xmlreader = factory .getXmlReader();      jsonwriter=null;}catch(Exception e ) {System.out.println("Error in creating "+e); return; }break 
          case Stream:           default : break ;         //default is needed to access the methods of XML Reader       try{             xmlreader = factory .getXmlReader();      jsonwriter=null;}catch(Exception e ) {System.out.println("Error in creating "+e); return; }break 
            };          if (xmlreader == null)   System.exit(-1);     else    // Set our default handler       xmlreader.setContentHandler((DefaultHandler)(new YourCustomSAXHandler()));      try {         for( ; !xmlreader .getCurrentEvent().equals(XMLStreamConstants._END_DOCUMENT ) 
        && (! ( new InputSource(fileName).receiveCharacterData()).matches("<\\?.*?\\?>") ); xmlreader.next(); } catch    // Catch any exceptions and print the stack trace         { e .printStackTrace() ; return; };   System.out 
        .println("\n\tXML Read Complete");     break;}          public class YourCustomSAXHandler extends DefaultHandler{@Overridepublic void startDocument( ) throws SAXException      // Here we can put our business logic like print XML structure, error handling etc       { super    .startDocument(); return; } @ Override 
        Public endElement (String uri , String localName ,   String qName)throws     SAXException{ Super.EndElement(uri,localName,qname);return;}@Overridepublic void startPrefixMapping      // Here we can put our business logic like print XML structure    public any exceptions and return the stack trace to parent class       {Super .startPrefixedmapping   (String uri , String local name )throws SAXException{super.StartprefixMappiing(uri,localname);return; } @Overridepublic voidendElement      // Here we can put our business logic like print XML structure    public any exceptions and return the stack trace to parent class       {Super .Endelement   (String uri , String local name )throws SAXException{super.EnDElement(uri,localname);return; }}