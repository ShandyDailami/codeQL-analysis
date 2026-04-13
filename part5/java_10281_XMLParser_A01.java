import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_10281_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File file = new File("example.xml");
            InputStream inputStream = new FileInputStream(file);
            
            // Create a SAX parser
            XMLReader reader = XMLReaderFactory.createXMLReader();
            
            // Create a SAX handler
            MyHandler handler = new MyHandler();
            
            // Parse the XML file
            reader.setContentHandler(handler);
            reader.parse(new InputSource(inputStream));
            
            // Close the input stream
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.ContentHandler {
    @Override
    public void startDocument() {
        System.out.println("Start of Document");
    }
    
    @Override
    public void endDocument() {
        System.out.println("End of Document");
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start of Element: " + qName);
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of Element: " + qName);
    }
    
    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }
    
    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) {
        System.out.println("Ignorable Whitespace: " + new String(ch, start, length));
    }
    
    @Override
    public void processingInstruction(String target, String data) {
        System.out.println("Processing Instruction: " + target + ", " + data);
    }
    
    @Override
    public void comment(char[] ch, int start, int length) {
        System.out.println("Comment: " + new String(ch, start, length));
    }
    
    @Override
    public void endPrefixMapping(String prefix) {
        System.out.println("End Prefix Mapping: " + prefix);
    }
}