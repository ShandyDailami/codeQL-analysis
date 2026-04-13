import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XSLTProcessor;
import org.xml.sax.parser.XSLTProcessorFactory;
import org.xml.sax.xmlreader.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_01647_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";
        String xsltFile = "example.xsl";

        File xmlFileObj = new File(xmlFile);
        File xsltFileObj = new File(xsltFile);

        try {
            parseXMLWithXSLT(xmlFileObj, xsltFileObj);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parseXMLWithXSLT(File xmlFile, File xsltFile) throws SAXException {
        XSLTProcessorFactory xsltProcessorFactory = SAXParserFactory.newInstance().getXSLTProcessorFactory();

        XSLTProcessor xsltProcessor = xsltProcessorFactory.newXSLTProcessor();

        xsltProcessor.setInput(xmlFile);
        xsltProcessor.setParameter("", "http://xml.apache.org/xsl/properties/disallow-namespaces");
        xsltProcessor.setParameter("", "http://xml.apache.org/xsl/properties/mandatory-namespaces");
        xsltProcessor.setParameter("", "http://xml.apache.org/xsl/properties/mandatory-property-names");

        xsltProcessor.setOutput(System.out);

        xsltProcessor.transformToTarget(xsltFile, "UTF-8");
    }

}