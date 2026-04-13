import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_39723_XMLParser_A08 extends DefaultHandler {
    boolean bName = false;
    boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            bName = true;
            bAge = true;
        } else if (bName && qName.equalsIgnoreCase("name")) {
            System.out.print("Name: ");
            bName = false;
        } else if (bName && qName.equalsIgnoreCase("age")) {
            System.out.print("Age: ");
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            System.out.println();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.print(new String(ch, start, length));
        } else if (bAge) {
            System.out.println();
            bAge = false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("students.xml"), myHandler);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}