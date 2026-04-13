import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_11978_XMLParser_A07 extends DefaultHandler {
    private List<String> userList = new ArrayList<>();
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("user")) {
            // security sensitive operation related to A07_AuthFailure
            if(userList.size() > 5) {
                System.out.println("AuthFailure: Too many users: " + userList);
            } else {
                System.out.println("AuthFailure: Normal operation: " + userList);
            }
            userList.clear(); // reset the list
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(currentElement != null && currentElement.equals("user")) {
            userList.add(new String(ch, start, length));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // use a SAXParser to parse an XML file
        // the file is in the classpath
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null);
        MySAXHandler handler = new MySAXHandler();
        try {
            saxParser.parse(Main.class.getResourceAsStream("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}