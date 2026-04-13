import java.io.*;
import java.util.*;
import java.security.*;
import java.xml.*;

public class java_11252_XMLParser_A01 {
    public static void main(String[] args) throws Exception {
        try {
            SecurityManager sm = new SecurityManager();
            sm.setAccessControl(new AccessControl() {
                public boolean grant(Subject subject, Object obj, Object context) {
                    if (subject.getPrincipal() == "user") {
                        return true;
                    }
                    return false;
                }
            });
            XMLParser parser = XML.createParser(
                new File("sample.xml"), sm, null);
            for (;;) {
                int event = parser.getEvent();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    String name = parser.getLocalName();
                    if (name.equals("record")) {
                        if (!parser.next()) {
                            throw new XMLStreamException();
                        }
                    } else if (name.equals("field")) {
                        if (!parser.next()) {
                            throw new XMLStreamException();
                        }
                    } else {
                        throw new XMLStreamException();
                    }
                } else if (event == XMLStreamConstants.END_ELEMENT) {
                    name = parser.getLocalName();
                    if (name.equals("record")) {
                        if (!parser.next()) {
                            throw new XMLStreamException();
                        }
                    } else {
                        throw new XMLStreamException();
                    }
                } else if (event == XMLStreamConstants.CHARACTERS) {
                    String text = parser.getText();
                    if (text.isEmpty()) {
                        throw new XMLStreamException();
                    }
                } else if (event == XMLStreamConstants.COMMENT) {
                    throw new XMLStreamException();
                } else if (event == XMLStreamConstants.DTD) {
                    throw new XMLStreamException();
                } else if (event == XMLStreamConstants.CDATA) {
                    throw new XMLStreamException();
                } else if (event == XMLStreamConstants.SPACE) {
                    throw new XMLStreamException();
                } else if (event == XMLStreamConstants.START_DOCUMENT) {
                    throw new XMLStreamException();
                } else if (event == XMLStreamConstants.END_DOCUMENT) {
                    throw new XMLStreamException();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}