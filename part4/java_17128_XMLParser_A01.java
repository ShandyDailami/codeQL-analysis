import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_17128_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        String namespace = "http://www.w3.org/2001/XMLSchema-instance";

        parseXMLFile(xmlFile, namespace);
    }

    private static void parseXMLFile(File xmlFile, String namespace) {
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setNamespaceAware(true);
            xmlReader.setValidation(true);
            xmlReader.setEntityResolver(new NamespaceEntityResolver(namespace));

            xmlReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            xmlReader.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
            xmlReader.setFeature("http://xml.org/sax/features/rcdata-sections", false);
            xmlReader.setFeature("http://xml.org/sax/features/c14n-last-first", false);
            xmlReader.setFeature("http://xml.org/sax/features/c14n-ignorable-whitespace", false);
            xmlReader.setFeature("http://xml.org/sax/features/c14n-process-namespaces", false);

            xmlReader.readArchive(namespace + xmlFile.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}