import java.io.File;
import java.util.Iterator;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

public class java_11554_XMLParser_A01 extends DefaultHandler {
    private String lastElement;

    public static void main(String[] args) {
        try {
            SAXHelper sax = new SAXHelper();
            sax.setDefaultHandler(new SecurityChecker());
            sax.parse(new File("broken-access-control.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (lastElement.equals("permission") && (qName == "allow" || qName == "deny")) {
            System.out.println("Broken access control found in " + qName + " element.");
        }
        lastElement = "";
    }
}