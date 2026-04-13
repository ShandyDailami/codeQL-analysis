import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class java_09964_XMLParser_A03 {

    public static void main(String[] args) {
        parseXMLWithSax();
        parseXMLWithJdom();
    }

    private static void parseXMLWithSax() {
        SAXReader saxReader = new SAXReader();

        try {
            File inputFile = new File("input.xml");
            XMLReader xmlReader = saxReader.build(inputFile);

            xmlReader.setValidation(true);
            xmlReader.setErrorHandler(new MySAXErrorHandler());

            xmlReader.parse(new File("input.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXMLWithJdom() {
        SAXBuilder saxBuilder = new SAXBuilder();

        try {
            File inputFile = new File("input.xml");
            Document document = saxBuilder.build(inputFile);

            Format format = new Format("    ", true);
            XMLOutputter xmlOutputter = new XMLOutputter(format);
            FileWriter writer = new FileWriter("output.xml");

            xmlOutputter.output(document, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MySAXErrorHandler extends DefaultHandler {
        public void warning(SAXParseException e) {
            // Handle warnings
        }

        public void error(SAXParseException e) {
            // Handle errors
        }

        public void fatalError(SAXParseException e) {
            // Handle fatal errors
        }
    }
}