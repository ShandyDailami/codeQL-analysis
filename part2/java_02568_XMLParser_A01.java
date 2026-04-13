import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.InvalidParameterException;

public class java_02568_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_xml_file");
            parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parse(File file) throws Exception {
        try (InputStream input = new FileInputStream(file)) {
            javax.xml.parsers.SAXParserFactory factory = javax.xml.parsers.SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser parser = factory.newSAXParser(new javax.xml.transform.dom.DOMSource(input));
            MyHandler handler = new MyHandler();
            parser.parse(input, handler);
        } catch (Exception e) {
            throw new InvalidParameterException("Invalid XML file: " + file.getAbsolutePath(), e);
        }
    }

    private static class MyHandler extends javax.xml.parsers.SAXHandler {
        @Override
        public void startElement(String uri, String localName, String qName, javax.xml.parsers.Event evt) {
            System.out.println("<" + qName + ">");
        }

        @Override
        public void endElement(String uri, String localName, String qName, javax.xml.parsers.Event evt) {
            System.out.println("</" + qName + ">");
        }

        @Override
        public void characters(char[] ch, int start, int length, javax.xml.parsers.Event evt) {
            System.out.println(new String(ch, start, length));
        }
    }
}