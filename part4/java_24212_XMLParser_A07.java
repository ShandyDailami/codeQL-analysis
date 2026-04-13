import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_24212_XMLParser_A07 extends DefaultHandler {
    private boolean bAuthor;
    private String elementValue;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("author")) {
            bAuthor = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bAuthor) {
            elementValue = new String(ch, start, length);
            bAuthor = false;
        }
    }

    public static void main(String[] args) {
        File inputFile = new File("authors.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyXMLHandler handler = new MyXMLHandler();
            parser.parse(inputFile, handler);

            System.out.println("Author names: " + handler.getAuthorNames());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    // getter for author names
    public String getAuthorNames() {
        return this.authorNames;
    }
}