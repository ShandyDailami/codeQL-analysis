import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;   // To use File class java_52956_XMLParser_A01 javax.xml.parsers.*;     // For SAX parser     
public class XMLParser{   
          public static void main(String[] args){        	      		
             try {               	       	   	     			                      									                    	 		       						                           }                  catch (Exception e)  {}                    for (;;);}                   if (!file.exists())   System.out.println("File not found!"), exitProgram();}}            void parse(String fileName){        	     try {      	       	    Parser parser = new SAXParser();     		           DefaultHandler dh=new DefaultHandler(){public 	 	void startDocument(){} public   	     
void endDocument () {} // ... and so on}}{                  XmlReader reader = 

parser.getXmlReader(fileName,dh);reader .read();}} catch (Exception e) {e.printStackTrace(); }          }}                     void exitProgram(){ System.out.println("Exiting..."),System.exit(-1)}                 File file = new 						File ("D:/testXML/books.xml");parse(file,null);}}}