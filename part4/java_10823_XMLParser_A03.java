import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;

public class java_10823_XMLParser_A03 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String currentTag = "";
    private String name = "";
    private String age = "";

    public static void main(String[] args) {
        String xmlFile = "src/sample.xml";
        XMLParserExample parser = new XMLParserExample();
        try {
            XMLParser xp = XMLLoader.getDefaultInstance().getSAXParser();
            xp.parse(new File(xmlFile), parser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentTag = qName;
        if ("person".equals(qName)) {
            bName = true;
            bAge = true;
        } else {
            if (bName) {
                if ("name".equals(currentTag)) {
                    bName = false;
                }
            }
            if (bAge) {
                if ("age".equals(currentTag)) {
                    bAge = false;
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("person".equals(qName)) {
            System.out.println("Name: " + name + ", Age: " + age);
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            name = new String(ch, start, length);
        } else if (bAge) {
            age = new String(ch, start, length);
        }
    }
}