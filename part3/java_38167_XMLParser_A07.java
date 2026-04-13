import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_38167_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlData = "<data><user name='alice' auth='true' /><user name='bob' auth='false' /></data>";

        // Create a SAXParserFactory
        SAXParserFactory spf = SAXParserFactory.newInstance();

        // Create a SAXParser
        try {
            SAXParser saxParser = spf.newSAXParser(null);

            // Create a new handler
            MyHandler handler = new MyHandler();

            // Parse the XML
            saxParser.parse(xmlData, handler);

            // Print the result
            System.out.println(handler.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder data = new StringBuilder();
    private String result;

    @Override
    public void startDocument() {
        result = "";
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        data.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("user")) {
            String userData = data.toString();
            String userName = userData.split("name=\"")[1].split("\" ")[0];
            String auth = userData.split("auth=\"")[1].split("\"")[0];
            if (auth.equals("true")) {
                if (result.equals("")) {
                    result = userName;
                } else {
                    result += ", " + userName;
                }
            }
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Users with authenticated access: " + result);
    }

    public String getResult() {
        return result;
    }
}