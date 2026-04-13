import java.beans.XMLDecoder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

public class java_17933_XMLParser_A01 {
    private static final Logger logger = Logger.getLogger(XMLParser.class.getName());

    public void parseXML(String xmlFilePath) {
        try {
            URL url = new File(xmlFilePath).toURI().toURL();
            XMLDecoder decoder = new XMLDecoder(url.openStream());
            while (!Thread.currentThread().isInterrupted()) {
                String xml = (String) decoder.readObject();
                logger.info("Parsed XML: " + xml);
            }
            decoder.close();
        } catch (Exception e) {
            logger.severe("Failed to parse XML due to " + e.getMessage());
            // Handle the exception properly in a real application.
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parseXML("/path/to/xml/file");
    }
}