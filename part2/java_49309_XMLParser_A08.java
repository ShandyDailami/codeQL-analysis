import java.io.*;   // for File, InputStream and OutputStream   
import org.xml.sax.*;  // provides SAX API (Simple API for XML)    
import org.xml.sax.helpers.XMLReaderFactory;  //SAX Helper classes     

public class java_49309_XMLParser_A08 {  
       public static void main(String[] args){   
           try{            
               File inputFile=new File("inputfile");               
              SAXParser saxParser = SAXParserFactory.newInstance().createSAXParser();  // create the parser     
		saxParser.setProperty("http://xml.org/sax/extensions", "true");  
               XMLReader xmlReader=saxParser.getXMLReader();   
              MyContentHandler mycontenthandler = new MyContentHandler ();    
             saxParser.parse(inputFile,mycontenthandler );  // parse the input file using content handler     	      		       	   	       	     	} catch (Exception e) {   }          finally{}}                      System . out . println (" End of Program");}    private static class MyContentHandler extends DefaultHandler    
	{public void startDocument(){System.out.println("Start Document ");  }}           public void endDocument()     	      	       	  {{System.out.println ( "End Of File" );}}             @Override   //startElement method                    	public void startElement(String uri, String localName,   
				String qName , Attributes attributes )    	     	{ System . out  . println (" Start Element: " +qName);}              	      	}public void endElement (String uri,            Strin lname   gnerated by SAX) {System.out     	.println("End of element :"+lname );}}             public   
				void characters(char ch[], int start,int length){ System . out  . println ("Characters: " +new String (ch ,start,length));}              	}public void fatalError(String error)      	   {System.out.println("Fatal Error :"+error);}}