import javax.xml.stream.*;
import java.io.FileInputStream;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;  // Importing StAX parser from Apache Xerces2 library for XML parsing purpose in Java only after installing it with your package manager (like apt-get on Ubuntu) or downloading the JAR file and adding to classpath
import com.sun.org.apache.xerces.internal.parsers.SAXParserImpl;  // Importing StAX parser from Apache Xerces2 library for XML parsing purpose in Java only after installing it with your package manager (like apt-get on Ubuntu) or downloading the JAR file and adding to classpath
import com.sun.org.apache.xerces.internal.util.SecurityManager;  // Importing Security Manager from Apache Xerces2 library for XML parsing purpose in Java only after installing it with your package manager (like apt-get on Ubuntu) or downloading the JAR file and adding to classpath
import java.net.*;   // Including URLConnection, URI & HTTPURLVariables classes required by SecurityManager  above imports
class java_50154_XMLParser_A03 {    public static void main(String[] args){     FileInputStream fis = new FileInputStream("inputfile");      SAXParserImpl spimpl=new SAXParserImpl();spimpl.setProperty("StAXSecurityLevel", "WARN_LEVEL2") ; SecurityManager securityMgr =  (org.xml.sax.security.helpers.SecuritySettingsImpl) 
( new org .apache.xerces.util.SecurityManagerHelper() ). getSAXSecurityManager(); spimpl.setSecurityContext((XMLStructure)new   URL("file:///") ); securityMgr.loadExternalEntity("http",""); SecurityManager sm = (org    .xml.sax.security.helpers 
..XmlSettingsImpl).getDefaultHandler(). setProperty( "Validation", Boolean.TRUE); spimpl= new SAXParserFactory()   default;