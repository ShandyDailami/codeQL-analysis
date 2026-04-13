import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XercesSAXParser;
import org.xml.sax.xmlreader.XMLRPCReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class java_16401_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "malicious.xml"; // replace with your file
        File file = new File(xmlFile);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        XMLParser parser;
        try {
            parser = new XercesSAXParser();
        } catch (SAXException e) {
            e.printStackTrace();
            return;
        }

        DefaultHandler handler = new DefaultHandler();
        try {
            parser.parse(new InputSource(fis), handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}