import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_32987_XMLParser_A01 extends DefaultHandler {
    private boolean isUser = false;
    private boolean isRole = false;
    private StringBuilder data = new StringBuilder();

    public boolean getIsUser() {
        return isUser;
    }

    public boolean getIsRole() {
        return isRole;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        data.setLength(0);

        if (qName.equalsIgnoreCase("user")) {
            isUser = true;
        } else if (qName.equalsIgnoreCase("role")) {
            isRole = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(ch, start, length);
    }

    public static void main(String[] args) {
        String xml = "<?xml version='1.0' encoding='UTF-8'?>" +
                "<root>" +
                "<user>Admin</user>" +
                "<role>admin</role>" +
                "</root>";

        BrokenAccessControlSAXHandler handler = new BrokenAccessControlSAXHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(new InputSource(new StringReader(xml)));
            parser.parse(xml, handler);

            if (handler.getIsUser()) {
                System.out.println("User: " + handler.data.toString());
            } else if (handler.getIsRole()) {
                System.out.println("Role: " + handler.data.toString());
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}