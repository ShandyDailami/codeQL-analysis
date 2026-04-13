import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_35667_XMLParser_A08 extends DefaultHandler {
    private Map<String, String> map = new HashMap<>();

    public void startElement(String uri, String localName, String qName, Map<String, String> map) {
        this.map = map;
    }

    public void characters(char[] ch, int start, int length) {
        if (map.containsKey(this.map.keySet().iterator().next())) {
            map.put(localName, new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XMLParser());
            reader.parse(xmlFile);

            for (Map.Entry<String, String> entry : new XMLParser().map.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}