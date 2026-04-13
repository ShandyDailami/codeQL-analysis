import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_21697_XMLParser_A03 {
    public static void main(String[] args) {
        String fileName = "sample.xml";

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();

            SAXParserHandler handler = new SAXParserHandler();
            reader.setContentHandler(handler);

            reader.parse(fileName);

            System.out.println(handler.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXParserHandler extends DefaultHandler {
    private String result;

    @Override
    public void startDocument() {
        result = "";
    }

    @Override
    public void startElement(String uri, String localName, String qName) {
        result += "<" + qName + ">";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        result += new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        result += "</" + qName + ">";
    }

    public String getResult() {
        return result;
    }
}