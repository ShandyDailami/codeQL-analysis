import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // Import Input/Output Stream classes to handle file operations   
public class java_43292_XMLParser_A03 {    
 public static void main(String[] args) throws ParserConfigurationException, IOException  {        
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();         
       DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();               
        // Parse the document   (with error handling to deal with malformed XML input etc.)     
           try{            
               InputSource src =  new StringInputSource(new String("<note>\n"+     "    <to>Tove</to>\n"+ 	"     <from>Jani</from>\n 	    \t <heading>Reminder</heading>\n  	  <body>Don't forget me this weekend!</body>\n   		   </note>"));
               Document doc = dBuilder.parse(src);              //Get the document element       	       	     	 			     } catch (SAXException e) {e.printStackTrace();}  }}     	catch   IOException{};         
                System.out.println("Root Element :" +doc.getDocumentElement().getNodeName());}}   		           return;       try                  						{XMLReader xr = dBuilder .newSAXParser ().getXMLReader () ;        //Read the contents of XML file    	xr.setContentHandler( new ContentHandlers() ); }  catch   SAXException{ e,printStackTrace();}
            finally {doc=null;}       return;}}                   private static class    ContentHandlers extends DefaultHandler     	{public void startDocument ( )throws SAXException        {System . out.println("Start of document");         }}     public  boolean endElement(String uri , String localName,  	String namespaceURL) throws SAXException{ System.out.println ("End Element: " +    localName); return true;}}public void startPrefixMapping (String prefix,\
>\>  String  url )throws      SAXException {System . out     . println("Start Prefix :"+prefix );} public   boolean endPrefixMapping(        	String prefix) throws          \tSAXExceptioN{ System.out    .println ("End of Prefix Mapping: " +        private void characters (char [] ch, int start ,     	int length )throws SAXException {System    
>\>  . out. println("Characters :"+ new String(ch,start,length));}}}`catch   exception{e    .printStackTrace();}  catch Exception e {} }}          finally{} return;}}};