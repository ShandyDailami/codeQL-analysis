import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_07262_XMLParser_A01 extends DefaultHandler {

    private boolean bElement = false;
    private String sElement = "";

    public static void main(String[] args) {
        String xmlFile = "src/test.xml";
        new XmlParser(xmlFile);
    }

    public java_07262_XMLParser_A01(String xmlFile) {
        File xml = new File(xmlFile);
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(this);
            xr.parse(xml.getAbsolutePath());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName) {
        bElement = true;
        sElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        bElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bElement) {
            sElement += new String(ch, start, length);
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Names of XML elements: " + sElement);
    }
}