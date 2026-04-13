import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

public class java_07173_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a new instance of the XMLReader
            XMLReader reader = XMLReader.newInstance();
            
            // Create a new instance of the InputSource
            InputSource is = new FileInputSource(new File("input.xml"));
            
            // Set the InputSource to the XMLReader
            reader.setContentHandler(new ContentHandler() {
                public void startDocument() {}
                public void endDocument() {}
                public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes atts) {}
                public void endElement(String namespaceURI, String localName, String qualifiedName) {}
                public void characters(char[] ch, int start, int length) {
                    String content = new String(ch, start, length);
                    System.out.println("Characters: " + content);
                }
                public void ignorableWhitespace(char[] ch, int start, int length) {}
                public void processingInstruction(String target, String instructions) {}
                public void endPrefixMapping(String prefix) {}
            });
            
            // Parse the XML
            reader.parse(is);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}