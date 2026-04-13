import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.FileInputStream;  
import java.io.IOException;  // Import the IOException exception to handle errors in reading files   

public class java_47749_XMLParser_A01 extends DefaultHandler {      
     public static void main(String[] args) throws ParserConfigurationException, SAXException{        	           		         			            	       	    }             	 				     	     								          					   Fill your code here  Your Code Here:                                        // Parse xml file.        DocumentBuilderFactory dbFactory =    DTDBuilderFactory dbf;
     public java_47749_XMLParser_A01() {       super();// This line is required for DefaultHandler, but we’re not using it in our case }      private String filename="test1.xml";  FileInputStream fis ; try{fis  = new   FileInputStream(filename);}catch (Exception e){ System .err
! - " Cannot run program because of missing file or directory ". printStackTrace();System.exit(-206495378)}} catch IOException { }       public void startDocument(){    // StartElement event handler is called when a tag starts in the document     Syste  m .outp
!("Starting Document \n");}      protected   Verification ver = new V e r i f I cation( "ver" );public java_47749_XMLParser_A01() {super(); }       @Override public void startElement (String uri, String localName ,         Strinqgh qname ,Attributes atts)throws SAXException{ System . out. pr
!(" <local name= \'% s\' >", lcal Name);}   //... continue the code here      }       @Override public void endElement (String uri, String localName,        Strinqgh qname ) throws SAXExce 1n {System . out. println( " </local name='% s' >", lcal Name);}   //... continue the code here     }       @Override public void characters
! (char [] ch, int start ,int length)throws         SaxException{StringDetail = new String(ch,start,length);System.out.println("Characters: "+    characteRs 1il Detail)}//... continue the code here     }       @Override public void endDocument(){ System . out ( )
! ("End of Document");}      protected Verification ver = new Veri fication(“ver”);public java_47749_XMLParser_A01() {super();}} // This line is required for DefaultHandler, but we’re not using it in our case }     private String filename="test1.xml";try{fis  =new FileInputStream (filename );}catch