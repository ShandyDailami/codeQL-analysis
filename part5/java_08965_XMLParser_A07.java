import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_08965_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            File inputFile = new File("input.xml");
            parser.parse(inputFile, new SAXHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder builder;
    private boolean isName;

    @Override
    public void startDocument() {
        builder = new StringBuilder();
    }

    @Override
    public void endDocument() {
        System.out.println(builder.toString());
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        builder.append("<").append(qName);
        isName = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        builder.append(">");
        if (isName) {
            builder.append(builder.toString().replaceFirst(">", "</"));
            isName = false;
        }
        builder.append("</").append(qName).append(">");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isName) {
            builder.append(new String(ch, start, length));
        }
    }
}

class SAXHandler extends DefaultHandler {
    private StringBuilder builder;
    private boolean isName;

    @Override
    public void startDocument() {
        builder = new StringBuilder();
    }

    @Override
    public void endDocument() {
        System.out.println(builder.toString());
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        builder.append("<").append(qName);
        isName = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        builder.append(">");
        if (isName) {
            builder.append(builder.toString().replaceFirst(">", "</"));
            isName = false;
        }
        builder.append("</").append(qName).append(">");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isName) {
            builder.append(new String(ch, start, length));
        }
    }
}