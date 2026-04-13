import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;
   import sun.security.x509.*;
  // Import Xerces library, you can use the latest version if required by your project requirement otherwise 'javax' should be used as it is backward compatible with Java standard libraries ie JAXP (Java API for XML Processing) and DOM(Document Object Model). Also included in java.xml package
import javax.xml.parsers.*;  // Required to parse xml using this class, you can use other classes too like SAXParser etc based on your requirement if required by the project otherwise it'll be enough just importing 'javax'. If not provided then Xerces should also work in java without any problem