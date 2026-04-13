import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Permission;
import java.security.SecurityManager;
import java.util.Iterator;
import java.util.Set;

import javax.xml.access.XmlAccess;
import javax.xml.access.XmlAccessException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_02563_XMLParser_A01 extends DefaultHandler {
    public static void main(String[] args) {
        try {
            SecurityManager sm = new SecurityManager() {
                public void checkPermission(Permission perm) throws SecurityException {
                    if (perm.getClass().getName().equals("java.lang.RuntimePermission")) {
                        if ("getSecurityManager".equals(perm.getName())) {
                            throw new SecurityException("Broken Access Control");
                        }
                    }
                }
            };
            System.setSecurityManager(sm);

            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(null);
            sp.setContentHandler(new XMLParserExample());
            sp.parse(new FileInputStream("example.xml"), new DummyHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (XmlAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End Element: " + localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}

class DummyHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            org.xml.sax.Attributes attributes) throws SAXException {
        // Do nothing
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // Do nothing
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Do nothing
    }
}