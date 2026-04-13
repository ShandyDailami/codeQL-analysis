import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_36745_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            File xmlFile = new File("path/to/your/file.xml");
            saxParser.parse(xmlFile, new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    System.out.println("Start element: " + qName);
                }

                @Override
                public void endElement(String uri, String localName, String qName)
                        throws SAXException {
                    System.out.println("End element: " + qName);
                }

                @Override
                public void characters(char[] ch, int start, int length)
                        throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}