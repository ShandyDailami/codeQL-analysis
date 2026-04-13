import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_28781_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml"; // replace with your xml file path
        String elementToExtract = "element_to_extract"; // replace with the element you want to extract

        try {
            File xmlFile = new File(xmlFilePath);
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            xmlReader.setContentHandler(new MyContentHandler(elementToExtract));
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyContentHandler implements org.xml.sax.ContentHandler {

        private String elementToExtract;
        private boolean isElementExtracted;

        public java_28781_XMLParser_A03(String elementToExtract) {
            this.elementToExtract = elementToExtract;
        }

        @Override
        public void startDocument() {}

        @Override
        public void endDocument() {}

        @Override
        public void startElement(String namespaceURI, String localName, String qualifiedName, org.xml.sax.Attributes atts) {
            if (qualifiedName.equals(elementToExtract)) {
                isElementExtracted = true;
            }
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qualifiedName) {
            if (isElementExtracted) {
                System.out.println("Element extracted: " + qualifiedName);
                isElementExtracted = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {}
    }
}