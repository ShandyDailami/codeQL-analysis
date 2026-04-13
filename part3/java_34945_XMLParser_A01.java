import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_34945_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            parseXML("books.xml");
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parseXML(String fileName) throws IOException, SAXException {
        File file = new File(fileName);
        SAXHandler handler = new SAXHandler();
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(handler);
        reader.parse(file);
    }
}

class SAXHandler extends DefaultHandler {

    private boolean bookList = false;
    private boolean book = false;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals("Books")) {
            bookList = true;
        } else if (bookList && qName.equals("Book")) {
            book = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (book && qName.equals("Book")) {
            book = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (book) {
            System.out.println(new String(ch, start, length));
        }
    }
}