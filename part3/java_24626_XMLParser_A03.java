// Package declaration
package com.santosh.xmlparser;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

// SAX Parser
public class java_24626_XMLParser_A03 {

    public static void main(String[] args) {

        // Create file for parsing
        File xmlFile = new File("src/com/santosh/xmlparser/books.xml");

        // Create SAX parser
        XMLReader parser = XMLReaderFactory.createXMLReader();

        // Create handler
        SAXHandler handler = new SAXHandler();

        // Parse XML file
        try {
            parser.setContentHandler(handler);
            parser.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}