import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.regex.Pattern;

public class java_19635_XMLParser_A08 extends DefaultHandler {
    private static final Pattern VALID_CHARACTERS = Pattern.compile("^[a-zA-Z0-9]*$");
    private boolean bId = false;
    private boolean bName = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("user")) {
            bId = true;
            bName = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);
        if (bId) {
            if (!VALID_CHARACTERS.matcher(s).matches()) {
                throw new SecurityException("Invalid id found!");
            }
            bId = false;
        } else if (bName) {
            if (!VALID_CHARACTERS.matcher(s).matches()) {
                throw new SecurityException("Invalid name found!");
            }
            bName = false;
        }
    }

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<users>\n" +
                "    <user id=\"123\">John Doe</user>\n" +
                "    <user id=\"abc\">Invalid Name</user>\n" +
                "</users>";

        XMLParser parser = new XMLParser();
        try {
            org.xml.sax.helpers.DefaultHandler dummyHandler = new org.xml.sax.helpers.DefaultHandler();
            org.xml.sax.XMLReader xr = org.xml.sax.SAXReader.newInstance();
            xr.setContentHandler(parser);
            xr.parse(new StringReader(xml), dummyHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}