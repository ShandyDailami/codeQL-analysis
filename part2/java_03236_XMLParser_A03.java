import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;

public class java_03236_XMLParser_A03 {
    public static void main(String[] args) {
        SAXDriver driver = new SAXDriver();
        XMLReader reader = null;

        try {
            reader = XMLReaderFactory.createXMLReader();
            MyContentHandler handler = new MyContentHandler();
            reader.setContentHandler(handler);
            driver.parse(args[0], handler);

            System.out.println("Parsed: " + handler.getDocumentTitle());
            System.out.println("Author: " + handler.getDocumentAuthor());
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    private String documentTitle;
    private String documentAuthor;

    public void startDocument() throws SAXException {
        documentTitle = "";
        documentAuthor = "";
    }

    public void endDocument() throws SAXException {
        System.out.println("Document Title: " + documentTitle);
        System.out.println("Document Author: " + documentAuthor);
    }

    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        if ("document".equals(qName)) {
            documentTitle = "";
            documentAuthor = "";
        } else if ("title".equals(qName)) {
            documentTitle = "";
        } else if ("author".equals(qName)) {
            documentAuthor = "";
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // Do nothing
    }

    public void characters(char[] chars, int start, int length)
            throws SAXException {
        String content = new String(chars, start, length);

        if ("title".equals(qName)) {
            documentTitle = content;
        } else if ("author".equals(qName)) {
            documentAuthor = content;
        }
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public String getDocumentAuthor() {
        return documentAuthor;
    }
}