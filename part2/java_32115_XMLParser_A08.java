import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class java_32115_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Read the XML file
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);
            reader.parse(new File("input.xml"));

            // Write the processed data to an output file
            FileWriter writer = new FileWriter("output.xml");
            writer.write(handler.getProcessedData());
            writer.close();
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends org.xml.sax.helpers.DefaultHandler {
    private StringBuilder processedData;

    public java_32115_XMLParser_A08() {
        this.processedData = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        processedData.append("Processed: ").append(qName);
    }

    public String getProcessedData() {
        return processedData.toString();
    }
}