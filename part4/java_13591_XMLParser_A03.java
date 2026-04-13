import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_13591_XMLParser_A03 extends DefaultHandler {
    private List<String> data = new ArrayList<>();
    private StringBuffer buffer = new StringBuffer();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String value = buffer.toString().trim();
        if (!"value".equals(qName) && !"".equals(value)) {
            data.add(value);
        }
    }

    public List<String> getData() {
        return data;
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        // Your XML data here
        String xmlData = "<root><value>value1</value><value>value2</value></root>";
        org.xml.sax.InputSource is = new org.xml.sax.InputSource(new StringReader(xmlData));
        try {
            javax.xml.parsers.SAXParserFactory spf = SAXParserFactory.newInstance();
            org.xml.parsers.SAXParser sp = spf.newSAXParser(is);
            sp.setContentHandler(parser);
            sp.parse(is, false); //false means to validate the content
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> data = parser.getData();
        System.out.println(data); // Prints all values
    }
}