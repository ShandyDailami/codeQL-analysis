import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_14252_XMLParser_A08 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        }
        if (bName && qName.equalsIgnoreCase("name")) {
            System.out.println("Name: " + attributes.getValue(""));
            bName = false;
        }
        if (bAge && qName.equalsIgnoreCase("age")) {
            System.out.println("Age: " + attributes.getValue(""));
            bAge = false;
        }
    }

    public static void main(String[] args) throws Exception {
        String fileName = "people.xml";
        File file = new File(fileName);
        InputStream inputStream = new FileInputStream(file);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saaxParserFactory.newSAXParser(new InputSource(inputStream));

        MySAXHandler mySAXHandler = new MySAXHandler();
        saxParser.setContentHandler(mySAXHandler);

        saxParser.parse(new InputSource(new StringReader(fileName)));
    }
}