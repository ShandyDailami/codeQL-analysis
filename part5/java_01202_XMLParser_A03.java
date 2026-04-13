import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class java_01202_XMLParser_A03 extends DefaultHandler {

    private static final String ALLOWED_TAGS[] = {"book", "author", "year"};

    private List<String> bookList;
    private String currentElement;
    private int currentIndex;

    public java_01202_XMLParser_A03(List<String> bookList) {
        this.bookList = bookList;
        currentIndex = -1;
    }

    public void parse(String fileName) {
        SAXReader reader = XMLReaderFactory.createSAXReader();
        reader.setContentHandler(this);

        try {
            reader.parse(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        if (isAllowed(qualifiedName)) {
            currentElement = qualifiedName;
            currentIndex = bookList.indexOf(qualifiedName);
        } else {
            System.out.println("WARNING: Ignoring element " + qualifiedName + " as not in allowed tags list.");
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals(ALLOWED_TAGS[0]) && bookList.contains(currentElement)) {
            bookList.set(currentIndex, new String(ch, start, length));
        } else if (currentElement.equals(ALLOWED_TAGS[1]) && (currentIndex + 1) < bookList.size()) {
            bookList.set(currentIndex + 1, new String(ch, start, length));
        } else if (currentElement.equals(ALLOWED_TAGS[2]) && (currentIndex + 2) < bookList.size()) {
            bookList.set(currentIndex + 2, new String(ch, start, length));
        }
    }

    private boolean isAllowed(String elementName) {
        for (String allowedElement : ALLOWED_TAGS) {
            if (elementName.equals(allowedElement)) {
                return true;
            }
        }
        return false;
    }
}