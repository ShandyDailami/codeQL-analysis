import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_44964_XMLParser_A03 {  
    public static void main(String args[]) throws ParserConfigurationException, SAXException{      
        String url = "http://www.w3schools.com/xml/books.xml";  //replace this URL with your own xml file    
        
        XMLReader reader;  
          try {   
            Reader in= new InputStreamReader(new FileInputStream("src/"+url),"UTF-8");     
             reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();      
              ParserHandler handler =  new ParserHandler();     //create the parserhandler  
               reader.setContentHandler(handler);   
            }catch (FileNotFoundException e) {  fprintf (stderr, "Doh! Unable to open file '%s'\n", url); return; };      catch (IOException e){fprintf (stderr, "%s\n","Could not read the XML");return;}     //check for any kind of exceptions  
          reader.parse(in);    }  fprintf (_stderr,"Ending parsing at line %ld\n",reader .getCurrentLineNumber());} public class ParserHandler extends DefaultHandler {       @Override protected void startElement (String uri, String localname,      String qName, Attributes attributes) throws SAXException{  
                    System.out.println("Start element: "+qName);}}  //Prints all the XML tags while parsing     end of your code    }