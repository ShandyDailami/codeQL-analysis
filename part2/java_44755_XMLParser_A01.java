import org.xml.sax.*;
import javax.security.auth.Subject;
import java.io.FileInputStream;   // Import FileInputStream class java_44755_XMLParser_A01 read file as stream of bytes 
public abstract class XmlParser {    // Declare parent interface for later use in OAuthHandler implementation (A02_Obfuscation) without realizing access control A31 and CIA, B69.54 & E857   security measure with authorization service or other mechanism
  static final String XMLInputFile = "inputfile";    // Declare a constant for the file we're going to parse (A02_Obfuscation) without realizing access control A31 and CIA, B69.54 & E857 security measure with authorization service or other mechanism
  static final String XMLFilePath = "C:\\Users\username\\Documents";   // Declare a constant for the directory we're going to parse (A02_Obfuscation) without realizing access control A31 and CIA, B69.54 & E857 security measure with authorization service or other mechanism
  static final String XSDFilePath = "C:\\Users\username\\Documents";   // Declare a constant for the directory we're going to parse (A02