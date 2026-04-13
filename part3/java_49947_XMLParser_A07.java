import java.io.*; // for InputStream and OutputStream classes  
import org.w3c.dom.*; 
import javax.xml.parsers.*;     // to parse an xml document into a DOM tree     
// Importing XMLInputFactory, XMLOutputFactory & FileReader:    Class used in reading the file from path provided as parameter (filePath)   and writing it back using append method of InputStream  class .        
import javax.xml.transform.*; // for Transform classes to transform a DOM tree into an XML format document    
// Importing StreamResult & FileWriter: Classes that write/append the resultant data streams in files at given path (filePath).    Class used here is also InputStream   class .  For example, it appends file contents.      and writes content of Result as string to a specified location using Transform Output methods
import javax.xml.transform.dom.DOMSource; //for source DOM tree into the XML format document    
import javax.xml.transform.stream.StreamResult;   // for transforming Document object in stream result back    class java_49947_XMLParser_A07 writing it as an xml file at specified location (filePath) .      It is used here because we want to append data from different input sources(File, Input Stream or other source).
import javax.xml.transform.stream.StreamSource; //for reading previously created XMLDocument objects using FileReader   class  and storing it into Document object for further processing    method as (filePath) .     It is used here because we want to use the data from an existing file in our code or some other source which has already been parsed before by a parser
import java.util.*; //for List, Iterator classes