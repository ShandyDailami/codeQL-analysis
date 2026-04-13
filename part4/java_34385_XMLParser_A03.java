import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_34385_XMLParser_A03 extends DefaultHandler {

    private List<String> names;
    private List<String> locations;
    private List<String> titles;
    private String lastElement;

    public java_34385_XMLParser_A03() {
        names = new ArrayList<>();
        locations = new ArrayList<>();
        titles = new ArrayList<>();
    }

    @Override
    public void startDocument() throws SAXException {
        names = new ArrayList<>();
        locations = new ArrayList<>();
        titles = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("book")) {
            System.out.println("Title: " + titles.get(titles.size() - 1));
            System.out.println("Location: " + locations.get(locations.size() - 1));
            System.out.println("Name: " + names.get(names.size() - 1));
            titles.remove(titles.size() - 1);
            locations.remove(locations.size() - 1);
            names.remove(names.size() - 1);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement.equals("name")) {
            names.add(new String(ch, start, length));
        } else if (lastElement.equals("location")) {
            locations.add(new String(ch, start, length));
        } else if (lastElement.equals("title")) {
            titles.add(new String(ch, start, length));
        }
    }

    public static void main(String[] args) throws Exception {
        MySAXHandler handler = new MySAXHandler();
        org.xml.sax.SAXParserFactory factory = org.xml.sax.SAXParserFactory.newInstance();
        org.xml.sax.SAXParser parser = factory.newSAXParser(null);
        parser.setContentHandler(handler);
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("books.xml"), true);
    }
}