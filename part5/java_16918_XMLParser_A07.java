import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_16918_XMLParser_A07 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String currentElement = "";

    public static void main(String[] args) {
        String inputFile = "src/main/resources/input.xml";
        String outputFile = "src/main/resources/output.txt";

        try {
            File input = new File(inputFile);
            File output = new File(outputFile);

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            XmlParser handler = new XmlParser();
            parser.parse(input, handler);

            // Writing to a file is not necessary here but if you want to write the output to a file
            // FileWriter writer = new FileWriter(output);
            // handler.write(writer, "");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        if (localName.equals("person")) {
            bName = true;
            bAge = true;
        } else {
            if (bName) {
                if (localName.equals("name")) {
                    bName = false;
                }
            }

            if (bAge) {
                if (localName.equals("age")) {
                    bAge = false;
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            bName = false;
            bAge = false;
        }

        if (currentElement.equals("person")) {
            System.out.println("Name: " + localName);
            System.out.println("Age: " + localName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.print(new String(ch, start, length));
        }
    }
}