import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XSLTProcessor;
import org.xml.sax.parser.XSLTProcessorFactory;
import org.xml.sax.parser.InputSource;

public class java_34728_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a new instance of the XSLTProcessorFactory
            XSLTProcessorFactory xsltFactory = XSLTProcessorFactory.newInstance();

            // Create a new XSLTProcessor
            XSLTProcessor xsltProcessor = xsltFactory.newXSLT();

            // Load the XSLT file
            xsltProcessor.load(Main.class.getResourceAsStream("/xslt.xslt"));

            // Use the XSLTProcessor's transform method
            // to print out the result
            System.out.println(xsltProcessor.transformToString(new InputSource(new FileInputStream("input.xml"))));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (DigestException e) {
            e.printStackTrace();
        }
    }

    public static class MyHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            // TODO Auto-generated method stub
            super.startElement(uri, localName, qName, attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // TODO Auto-generated method stub
            super.endElement(uri, localName, qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // TODO Auto-generated method stub
            super.characters(ch, start, length);
        }

    }

}