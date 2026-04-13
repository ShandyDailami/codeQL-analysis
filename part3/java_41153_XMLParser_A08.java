import java.io.FileInputStream;
import java.io.InputStream;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_41153_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load XML document
            InputStream inputStream = new FileInputStream("sample.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyContentHandler());
            reader.parse(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler implements org.xml.sax.ContentHandler {
        public void startDocument() {}
        public void endDocument() {}
        public void startElement(String uri, String localName, String qName) {}
        public void endElement(String uri, String localName, String qName) {}
        public void characters(char[] chars, int start, int length) {
            // This method will be called for every character read.
            // Here, we are just printing the character data, but you could
            // modify this to perform your own security-sensitive operation here.
            System.out.println(new String(chars, start, length));
        }
        public void fatalError(String error) {}
        public void warning(String msg) {}
    }
}