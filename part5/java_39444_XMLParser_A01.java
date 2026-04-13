import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_39444_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml"); // specify your input file here
        parse(inputFile);
    }

    private static void parse(File inputFile) {
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            reader.setFeature("http://xml.org/sax/features/validation", false); // disable validation
            reader.setFeature("http://xml.org/sax/features/external-general-entities", false); // disable external general entities
            reader.setFeature("http://xml.org/sax/features/external-parameter-entities", false); // disable external parameter entities
            reader.setFeature("http://xml.org/sax/features/rng-supported", false); // disable RNG (Root Namespace)

            // add a ContentHandler to handle the parsed data
            reader.setContentHandler(new MyContentHandler());
            // parse the XML file
            reader.parse(inputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            // ensure resources are released
            if (reader != null) {
                reader.getParser().getThreadDefaultFactory().newThread(new Runnable() {
                    public void run() {
                        try {
                            reader.parse(inputFile.getAbsolutePath());
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (SAXException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }
    }
}