import java.xml.*;

public class java_07415_XMLParser_A08 {
    public static void main(String[] args) {
        XMLReader reader = XML.createXMLReader();
        try {
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespaces", false);
            reader.setFeature("http://xml.org/sax/features/validation", true);
            reader.setFeature("http://xml.org/sax/features/validation", false);
            reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            reader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
            reader.setFeature("http://xml.org/sax/features/routing", false);
            reader.setFeature("http://xml.org/sax/features/security", true);
            reader.setFeature("http://xml.org/sax/features/rfc3352", true); // RFC 3352 basic parsing
            reader.setFeature("http://xml.org/sax/features/xml-version", true);
            reader.setFeature("http://xml.org/sax/features/stop-nodes", false);
            reader.setFeature("http://xml.org/sax/features/chunk-size", false);
            reader.setFeature("http://xml.org/sax/features/element-form-default", false);
            reader.setFeature("http://xml.org/sax/features/lexical-handler", false);
            reader.setFeature("http://xml.org/sax/features/external-subset", false);
            reader

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}