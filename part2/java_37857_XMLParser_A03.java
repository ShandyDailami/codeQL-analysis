import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_37857_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        parseXml(xmlFile);
    }

    private static void parseXml(File xmlFile) {
        XMLReader reader;
        DefaultHandler handler = new DefaultHandler();

        try {
            reader = XMLReaderFactory.createXMLReader(handler);
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespaces", false);
            reader.setFeature("http://xml.org/sax/features/validation", false);
            reader.setFeature("http://xml.org/sax/features/external-parametrized-queries", false);

            reader.setFeature("http://xml.org/sax/features/namespaces", false);
            reader.parse(xmlFile.toString());

            System.out.println("Element Names:");
            handler.startElement("", "", "note", "");
            handler.startElement("", "", "name", "");
            handler.characters("", 0, handler.getCharacterEncoding());
            System.out.println(handler.getCharacterEncoding());
            handler.endElement("", "", "name");
            handler.endElement("", "", "note");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}