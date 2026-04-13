import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.XMLReader;

import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;

public class java_38085_XMLParser_A08 extends DefaultHandler {
    private List<String> elementList;
    private String currentElement;
    private String currentElementContent;

    public java_38085_XMLParser_A08() {
        elementList = new ArrayList<>();
    }

    public void startElement(String uri, String localName, String qName,
            org.xml.sax.Attributes attributes) throws SAXException {
        currentElement = qName;
        currentElementContent = "";
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        elementList.add(qName);
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        currentElementContent += new String(ch, start, length);
    }

    public static void main(String[] args) {
        try {
            NamespacePrefixMapper prefixMapper = new NamespacePrefixMapper() {
                public String getPreferredPrefix(String ns, String localName) {
                    return "ns";
                }
                public boolean hasLengthPrefix(String prefix) {
                    return false;
                }
            };
            XMLReader reader = XMLReaderFactory.createXMLReader(prefixMapper);
            reader.setContentHandler(new XMLParser());
            reader.parse(new File("input.xml"));

            for (String element : XMLParser.this.elementList) {
                System.out.println(element);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}