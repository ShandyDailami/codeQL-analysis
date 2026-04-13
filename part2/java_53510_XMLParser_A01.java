import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.FileInputStream;   // Import FileInputStream class java_53510_XMLParser_A01 read file as a stream    
public class Main { 
    public static void main(String[] args) throws Exception{
        XMLReader reader = null;       // Creating an instance of the SAX parser named Reader        
          try                 (FileInputStream fis=new FileInputStream("sample.xml"))   // creating a file input stream for our xml document 
            {   
              reader  =SAXParserFactory.newInstance().newSAXParser();     // create XMLReader object, with the new SAX parser instance      
                  HandlerClass handler = new HandlerClass ();         //Creating an Instance of MyHandler class to handle xml parsing 
                   Reader =reader;                    reader .setContentHandler(handler );    setEncoding("UTF-8");     }   catch (Exception e) { System.out.println ("Problems while reading the file.");}       finally {}               try{ XMLReaderFactory xr=XMLReaderFactory.*; newInstance().createXHTMLReader();reader =xr; reader .setContentHandler(handler ); setEncoding("UTF-8"); }catch  (Exception e){System. out. println ("Problems while creating the Xml Reader.")}
            // Reading a file as XML and processing it using SAXParser, an event model for parsing xml documents         `       reader .parse(new InputSource( new StreamSource("samplexsd")))  }catch (Exception e){ System.out..println ("Problems while validating the document with XSD.") };
        }}