import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLSerializer;

public class java_36045_XMLParser_A03 {

    private DefaultHandler handler;
    private XMLReader reader;

    public java_36045_XMLParser_A03() {
        handler = new DefaultHandler() {

            public void startDocument() {
                System.out.println("Start of document");
            }

            public void endDocument() {
                System.out.println("End of document");
            }

            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Start of element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) {
                System.out.println("End of element: " + qName);
            }

            public void characters(char[] ch, int start, int length) {
                String content = new String(ch, start, length);
                System.out.println("Characters: " + content);
            }

            public void fatalError(String error) {
                System.out.println("Fatal Error: " + error);
            }

            public void warning(String error) {
                System.out.println("Warning: " + error);
            }
        };

        Properties props = new Properties();
        try {
            props.load(new FileInputStream("config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String parser = props.getProperty("parser");
        if (parser.equals("SAX")) {
            reader = new SAXParser();
        } else if (parser.equals("DOM")) {
            reader = new DOMParser();
        } else if (parser.equals("STAX")) {
            reader = new STAXParser();
        }
    }

    public void parse(String file) {
        try {
            reader.setContentHandler(handler);
            reader.parse(new InputStreamReader(new FileInputStream(file), null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        parser.parse("example.xml");
    }
}