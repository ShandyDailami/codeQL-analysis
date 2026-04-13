import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_06412_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            XMLReader parser = XMLReaderFactory.createXMLReader();
            MyHandler handler = new MyHandler();
            parser.setContentHandler(handler);
            parser.parse(new File("input.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean isAuthFailure = false;
    private boolean isFailedAuth = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("AuthFailure".equals(qName)) {
            isAuthFailure = true;
        } else if ("FailedAuth".equals(qName)) {
            isFailedAuth = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (isAuthFailure) {
            System.out.println("AuthFailure event detected.");
            isAuthFailure = false;
        } else if (isFailedAuth) {
            System.out.println("FailedAuth event detected.");
            isFailedAuth = false;
        }
    }
}