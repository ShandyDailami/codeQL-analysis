import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_24956_XMLParser_A03 extends DefaultHandler {

    private List<String> dataList = new ArrayList<>();
    private StringBuilder currentElementContent;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of the document.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of the document.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of the element: " + qName);
        currentElementContent = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of the element: " + qName);
        dataList.add(currentElementContent.toString());
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
        currentElementContent.append(new String(ch, start, length));
    }
}