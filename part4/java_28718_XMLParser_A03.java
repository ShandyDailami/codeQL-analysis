import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_28718_XMLParser_A03 extends DefaultHandler {
    private StringBuilder data;
    private List<String> injections;
    
    public java_28718_XMLParser_A03() {
        this.data = new StringBuilder();
        this.injections = new ArrayList<>();
    }

    public List<String> getInjections() {
        return injections;
    }

    @Override
    public void startDocument() throws SAXException {
        injections = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("injection")) {
            injections.add(attributes.getValue("method"));
        }
        data.append(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        data.append(qName);
        if (qName.equalsIgnoreCase("injection")) {
            injections.add(data.toString());
            data.setLength(0);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        if (data.length() > 0) {
            injections.add(data.toString());
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        javax.xml.parsers.SAXParserFactory spf = SAXParserFactory.newInstance();
        MyXMLHandler xmh = new MyXMLHandler();
        SAXParser sp = spf.newSAXParser(null);
        sp.parse(Class.forName("xml.file").getResourceAsStream("injection.xml"), xmh);
        System.out.println(xmh.getInjections());
    }
}