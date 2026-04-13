import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_19358_XMLParser_A08 extends DefaultHandler {

    private boolean parsingElement = false;
    private boolean parsingText = false;

    public java_19358_XMLParser_A08() {
        super();
    }

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        if (!xmlFile.exists()) {
            throw new InvalidParameterException("File does not exist");
        }
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            MinimalistXMLParser handler = new MinimalistXMLParser();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, java.util.Properties attributes) {
        parsingElement = true;
        parsingText = false;
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        parsingElement = false;
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (parsingElement && parsingText) {
            System.out.println("Text: " + new String(ch, start, length));
        }
    }
}