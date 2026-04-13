import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_39784_XMLParser_A01 extends DefaultHandler {
    private int depth;
    private StringBuilder data;

    public java_39784_XMLParser_A01() {
        depth = 0;
        data = new StringBuilder();
    }

    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        depth++;
        data.append(repeat(' ', depth * 4));
        data.append(qName);
        System.out.println(data.toString());
        data.setLength(0);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        depth--;
        data.append(repeat(' ', depth * 4));
        data.append("-> " + qName);
        System.out.println(data.toString());
        data.setLength(0);
   
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        data.append(ch, start, length);
    }

    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal Error: " + error);
    }

    private static char repeat(char c, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(c);
        }
        return sb.charAt(0);
    }

    public static void main(String[] args) throws IOException, SAXException {
        File inputFile = new File("input.xml");
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new XMLParser());
        reader.parse(inputFile);
    }
}