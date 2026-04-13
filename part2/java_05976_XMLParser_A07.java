import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_05976_XMLParser_A07 {
    public static void main(String[] args) {
        String inputFile = "input.xml";
        String outputFile = "output.txt";
        parseXML(inputFile, outputFile);
    }

    private static void parseXML(String inputFile, String outputFile) {
        File input = new File(inputFile);
        File output = new File(outputFile);

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(input, new MyHandler(output));
            parser.parse(input, DefaultHandler.NULL_HANDLER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private FileWriter writer;

        public java_05976_XMLParser_A07(File outputFile) {
            try {
                writer = new FileWriter(outputFile, true); // Append to file
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("user")) {
                String username = attributes.getValue("username");
                String password = attributes.getValue("password");
                try {
                    writer.write("Username: " + username + ", Password: " + password + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}