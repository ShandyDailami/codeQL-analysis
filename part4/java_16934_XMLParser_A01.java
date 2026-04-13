import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.ArrayList;
import java.util.List;

public class java_16934_XMLParser_A01 extends DefaultHandler {
    private boolean isTagFound = false;
    private List<String> listOfData = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            isTagFound = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            isTagFound = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isTagFound) {
            listOfData.add(new String(ch, start, length));
        }
    }

    public List<String> getListOfData() {
        return listOfData;
    }
}

public class XMLParser {
    public static void main(String[] args) {
        String xmlData = "<?xml version=\"1.0\"?>\n" +
                "<students>\n" +
                "  <student>\n" +
                "    <id>1</id>\n" +
                "    <name>John Doe</name>\n" +
                "    <age>22</age>\n" +
                "  </student>\n" +
                "  <student>\n" +
                "    <id>2</id>\n" +
                "    <name>Jane Doe</name>\n" +
                "    <age>20</age>\n" +
                "  </student>\n" +
                "</students>";

        MySAXHandler mySAXHandler = new MySAXHandler();
        org.xml.sax.helpers.DefaultHandler defHandler = (org.xml.sax.helpers.DefaultHandler) mySAXHandler;
        org.xml.sax.helpers.XMLReaderFactory.newInstance().createXMLReader(
                new org.xml.sax.ContentHandler[]{defHandler}
        ).parse(new StringReader(xmlData));

        List<String> studentData = mySAXHandler.getListOfData();
        for (String data : studentData) {
            System.out.println(data);
        }
    }
}