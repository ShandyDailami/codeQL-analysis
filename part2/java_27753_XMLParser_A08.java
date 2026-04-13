import java.security.NoSuchAlgorithmException;
import java.security.KeyStoreException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class java_27753_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            XmlParser parser = new XmlParser();
            parser.parse("input.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}

class XmlParser {
    public void parse(String file) throws SAXException, ParserConfigurationException, CertificateException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        // Here we will use a custom SAX parser, but we can also use the standard parser provided by the libraries.
        CustomSAXHandler handler = new CustomSAXHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, handler);
        parser.parse(file, handler);
    }
}

class CustomSAXHandler extends DefaultHandler {
    boolean bName;
    boolean bAge;
    boolean bCountry;

    String tempValue;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
            bCountry = true;
        } else if (bName && qName.equalsIgnoreCase("name")) {
            System.out.print("Name: ");
            bName = false;
        } else if (bName && qName.equalsIgnoreCase("age")) {
            System.out.print("Age: ");
            bAge = false;
        } else if (bAge && qName.equalsIgnoreCase("country")) {
            System.out.print("Country: ");
            bCountry = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName || bAge || bCountry) {
            System.out.print(new String(ch, start, length));
        }
        tempValue = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = false;
            bAge = false;
            bCountry = false;
        } else if (bName && qName.equalsIgnoreCase("name")) {
            System.out.println();
        } else if (bAge && qName.equalsIgnoreCase("age")) {
            System.out.println();
        } else if (bCountry && qName.equalsIgnoreCase("country")) {
            System.out.println();
        }
    }
}