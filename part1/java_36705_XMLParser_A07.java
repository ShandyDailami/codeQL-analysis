import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;

public class java_36705_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            XMLReader reader = SAXParser.newInstance().getSAXReader();
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bName;
    boolean bAge;

    public java_36705_XMLParser_A07() {
        bName = bAge = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("person")) {
            bName = bAge = true;
            // Start processing the person element
        } else if (bName && qName.equals("name")) {
            bName = false;
        // Start processing the name element
        } else if (bAge && qName.equals("age")) {
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("person")) {
            // End processing the person element
        } else if (bName && qName.equals("name")) {
            // End processing the name element
            bName = false;
        } else if (bAge && qName.equals("age")) {
            // End processing the age element
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            // Handle the name
        } else if (bAge) {
            // Handle the age
        }
    }
}