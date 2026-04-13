import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_37944_XMLParser_A01 extends DefaultHandler {
    public static void main(String[] args) {
        try {
            File inputFile = new File("example.xml");
            long startTime = System.currentTimeMillis();

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(new InputStreamReader(new FileInputStream(inputFile)));
            parser.parse(new InputStreamReader(new FileInputStream(inputFile)), this);

            long endTime = System.currentTimeMillis();
            System.out.println("Time taken to parse XML: " + (endTime - startTime) + " milliseconds");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length);
        System.out.println("Character data: " + value);
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) {
        System.out.println("Start Prefix Mapping: " + prefix + " - " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix) {
        System.out.println("End Prefix Mapping: " + prefix);
    }
}