import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_23345_XMLParser_A07 {

    public static class SimpleHandler extends DefaultHandler {
            private String name;
            private int age;

            @Override
            public void startElement(String uri, String localName, String qName,
                                     javax.xml.namespace.QName qNs, org.xml.sax.Attributes attributes)
                    throws SAXException {
                if (qNs != null) {
                    if (qNs.getLocalPart().equals("person")) {
                        name = "";
                    }
                }
                else {
                    if (localName.equals("name")) {
                        name = "";
                    }
                    else if (localName.equals("age")) {
                        age = 0;
                    }
               }}}

            @Override
            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
                if (localName.equals("name")) {
                    System.out.println("Name: " + name);
                } else if (localName.equals("age")) {
                    System.out.println("Age: " + age);
                }
            }

            @Override
            public void characters(char[] ch, int start, int length)
                    throws SAXException {
                if (name != null) {
                    name = new String(ch, start, length);
                } else if (ch != null) {
                    age = Integer.parseInt(new String(ch, start, length));
                }
            }
        }

    public static void main(String[] args) throws IOException, SAXException {
        File xmlFile = new File("people.xml");
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();

        xmlReader.setContentHandler(new SimpleHandler());
        xmlReader.parse(xmlFile);
    }
}