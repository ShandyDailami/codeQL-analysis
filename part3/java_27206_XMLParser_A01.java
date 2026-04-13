import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

public class java_27206_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load XML file
            File xmlFile = new File("broken_access_control.xml");
            FileReader fileReader = new FileReader(xmlFile);

            // Create a SAX parser
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new Properties());

            // Create a SAX Handler
            MyHandler myHandler = new MyHandler();
            saxParser.parse(fileReader, myHandler);

            // Close FileReader
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements SAXHandler {
    private boolean accessControl = false;
    private StringBuffer buffer = new StringBuffer();

    public boolean handleStartElement(String uri, String localName, String qName, Attributes attributes) {
        // If we find a tag related to access control, set accessControl to true
        if (qName.equalsIgnoreCase("access")) {
            accessControl = true;
        }
        return accessControl;
    }

    public boolean handleEndElement(String uri, String localName, String qName) {
        // If we are at the end of an element and access control is set to true, print the content of the element
        if (qName.equalsIgnoreCase("access")) {
            accessControl = false;
            System.out.println("Access control for: " + buffer.toString());
            buffer.setLength(0);
        }
        return accessControl;
    }

    public void characters(char[] ch, int start, int length) {
        // Append characters to the buffer
        buffer.append(ch, start, length);
    }
}