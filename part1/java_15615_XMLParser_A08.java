import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_15615_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReader.newInstance();
            File inputFile = new File("input.xml");
            FileInputStream fis = new FileInputStream(inputFile);
            InputSource is = new InputSource(fis);
            reader.setContentHandler(new ContentHandler() {
                public void startDocument() {}
                public void endDocument() {}
                public void startElement(String uri, String localName, String qName) {
                    System.out.println("Start element: " + qName);
                }
                public void endElement(String uri, String localName, String qName) {
                    System.out.println("End element: " + qName);
                }
                public void characters(char[] ch, int start, int length) {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
                public void startPrefixMapping(String prefix, String uri) {}
                public void endPrefixMapping(String prefix) {}
            });
            reader.parse(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}