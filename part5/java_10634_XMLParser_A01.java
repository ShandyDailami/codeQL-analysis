import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_10634_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyXMLHandler());
            saxParser.parse(new File("path_to_your_file.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyXMLHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private StringBuilder sb;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        sb = new StringBuilder();

        if (qName.equals("person")) {
            bName = true;
            bAge = true;
        } else if (bName && qName.equals("name")) {
            bName = false;
        } else if (bName && qName.equals("age")) {
            bAge = false;
        } else if (bAge && qName.equals("age")) {
            bAge = false;
        } else {
            sb.append(qName);
            sb.append("=\"");
            sb.append(attributes.getValue(0));
            sb.append("\" ");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (bName && qName.equals("name")) {
            bName = false;
        } else if (bAge && qName.equals("age")) {
            bAge = false;
        } else {
            sb.append("/");
            sb.append(qName);
            sb.append("=\"");
            sb.append(sb.toString().substring(sb.toString().lastIndexOf("=\"") + 1));
            sb.append("\"");

            System.out.println(sb.toString());
        }
    }
}