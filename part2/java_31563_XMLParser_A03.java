import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_31563_XMLParser_A03 extends DefaultHandler {

    private StringBuilder data = new StringBuilder();
    private boolean bTag = false;
    private boolean bText = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        data.setLength(0);

        if (qName.equals("tag")) {
            bTag = true;
        } else if (qName.equals("text")) {
            bText = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bText) {
            data.append(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("tag") && bTag) {
            bTag = false;
            System.out.println("Tag: " + data.toString());
        } else if (qName.equals("text") && bText) {
            bText = false;
            System.out.println("Text: " + data.toString());
        }
    }
}

public class Test {

    public static void main(String[] args) {

        String fileName = "input.xml";

        XMLReader xr = SAXParser.newInstance().getSAXParser().getSAXReader();

        MySAXHandler sh = new MySAXHandler();

        xr.setContentHandler(sh);

        try {
            xr.parse(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}