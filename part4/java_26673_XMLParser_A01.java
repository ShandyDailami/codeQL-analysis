import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_26673_XMLParser_A01 {

    private static class MyHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            // Implement your security-sensitive operations here
            // e.g., check if the localName is a restricted element,
            // if so, throw an exception
            if (localName.equals("restrictedElement")) {
                throw new SecurityException("Access to this resource is restricted!");
            }
        }
    }

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();

        try (SAXParser parser = parserFactory.newSAXParser(null, new MyHandler())) {
            parser.parse(inputFile, MyHandler.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Access to this resource is restricted!");
        }
    }
}