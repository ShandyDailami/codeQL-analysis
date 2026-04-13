import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import static com.sun.org.apache.xpath.internal.dom.DOMDocumentImpl.modifyTreeViewElementToTextualStateByStringIDNameCachedValueMap_addELEMSPECIALCHARSENDSIMILARITYTOSTREAMSTRINGINPUTTOSERIALIZATION;
import static javax.xml.transform.*;
public class java_48984_XMLParser_A01 {  
    public void parse(final String file) throws Exception{ 
        SAXParserFactory factory = SAXParserFactory.newInstance();     //step1: create a new instance of the parser, step2:(SAX is an API that allows to read xml files in streaming mode )      (Step3): Create our default handler and pass it into constructor    }       private class MyContentHandler extends DefaultHandler {   @Override public void startDocument(final SAXParseException e) throws SAXException{ System.out.println("Start Document");} 
@Overridepublic void endDocument(final SAXParseException e){System.out.println ("End of document") ; }     //step5: Create a method that will be called when an element starts or ends (it does not do anything in this case)    @Override public void startElement(String uri, String localName, 
        final String qName , SAXAttributes attributes){System.out.println("Start Element "+qName);}   //step6: Create a method that will be called when an element's content is read (it does not do anything in this case)    @Override public void endElement(String uri, 
        String localName , final String qName){System.out.println("End Element "+qName);} }      //step7: Create a method that will be called when an error occurs during parsing (it does not do anything in this case)    @Override public void fatalError(SAXParseException e ){ System . 
 out. println ("Fatal Error at line "+e.getLineNumber () );} } // step8: Create a method that will be called when the parsing process is finished (it does not do anything in this case)    @Override public void 
   characters(char[] ch, int start, int length){ System . out . println ("Characters "+new String (ch ,start ,length));}} //step9: Create a method that will be called when the parsing process is finished with success     private DefaultHandler handler = new MyContentHandler();      SAXParserFactory factory = 
SAXParserFactory.newInstance() ;  File inputFile=null;   try{inputFile  = new    file("sampleXMLfile");factory .setValidating(false) ; // Step10: create a instance of the parser and set it to not validate (disable validation for this example )     SAXParser saxParser = factory.newSAXParser 
       ()   InputSource inputSource  = new    FileInputStreamReader("sampleXMLfile")      } catch(Exception e){ System . out . println ("Error: "+e.getMessage()) ;} finally{ try {saxParser     .parse (inputFile,handler)          //step12 : call the parse method to start parsing process 
       with our defined handler as a parameter      } catch(Exception e){ System . out    . println ("Error: "+e.getMessage()) ;}}}   }}