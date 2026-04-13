import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.net.URL;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class java_07324_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            String urlStr = "http://www.example.com/sample.xml";
            URL url = new URL(urlStr);
            InputStream inputStream = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser();

            MyHandler handler = new MyHandler();
            saxParser.parse(inputStream, handler);

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bAuthFailure = false;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            bAuthFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            if (bAuthFailure) {
                System.out.println("Authentication failure detected");
            } else {
                System.out.println("Authentication failure not detected");
            }
            bAuthFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bAuthFailure) {
            System.out.println("Authentication failure: " + new String(ch, start, length));
        }
    }
}