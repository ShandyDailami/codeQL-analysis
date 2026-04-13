import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class java_28653_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            XMLReader reader = dBuilder.newSAXReader();
            reader.setContentHandler(new MyHandler());
            reader.read(new File("input.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            // Uncomment this to print the tag names
            // System.out.println("Start Element : " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // Uncomment this to print the tag names
            // System.out.println("End Element : " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // Uncomment this to print the character data
            // System.out.println("Characters : " + new String(ch, start, length));
        }
    }
}