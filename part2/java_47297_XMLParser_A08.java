import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import javax.xml.parsers.*;
public class java_47297_XMLParser_A08 {  
    public static void main(String[] args) throws Exception{ 
        SAXParserFactory factory = SAXParserFactory.newInstance();      // Create a new instance of the DefaultHandler         
         try (SAXParser saxParser =  factory.newSAXParser())       // Parse XML file with default handler and set it to our custom implementation  
            {   
             MyHandler myHandler = new MyHandler(); 
              File inputFile= new File("samplefile");       		// replace "mysample" by your xml-filename              		         	 			                  }           catch (ParsingException e)      // Catch parsing errors       return;     }}         public static class MyHandler extends DefaultHandler{   @Overridepublic void startDocument(org.xml.sax.SAXEvent event){System.out.println("Start of Document");}   
@Override 	public void endDocument(){ System.out.println ("End of document ");}}          // Your methods should be implemented here, then you can put your code in the body as indicated above using a try/catch block within this section and handle exceptions appropriately if needed (like return or throw). } catch(Exception $) { 
            e .printStackTrace(); System.exit(-1);}}}}}              @Override public void startElement(String uri, String localName ,String qName ){System.out.println("Start Element: "+qName );}      // Your methods should be implemented here       } catch (Exception $) { e .printStackTrace(); System.exit(-1);}}}}}