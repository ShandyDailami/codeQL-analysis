import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_41877_XMLParser_A01 {

    public static void main(String[] args) {
        String inputFilePath = "input.xml";
        String outputFilePath = "output.xml";

        try {
            File inputFile = new File(inputFilePath);
            File outputFile = new File(outputFilePath);

            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new CustomEntityResolver());

            XmlParserHandler handler = new XmlParserHandler();
            reader.setContentHandler(handler);

            reader.parse(inputFile);

            // Write parsed data to new XML file
            // ...

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}