import org.xml.sax.SAXException;   // import SAX exception handling library, required for the XML parser functionality    

import org.xml.sax.helpers.DefaultHandler;    // provide default implementation of an error/warning handler using DefaultHandler class java_52122_XMLParser_A01 javax.xml.parsers.*;      // Java API to parse and create parsers (SAX & DOM)  

import java.io.*;                   // Input Output Stream, File classes needed for file handling    

public Class XmlParser {    // Declaring the main class with name 'Xmlparser' 

private static final String INVALID_XML = "src/invalid.xml";      // Path to invalid XML data set  	      		       	 	   			                            	     									            .                xmL"     # Invalid Xml file path for demonstration purpose, please replace with your actual xmlfilepath 

public static void main(String[] args) {   	// Main method as the entry point of a java program. Here we are going to create an instance and call methods on it  	      		       	 	   			                            	     									            .                xMl"     # Invalid Xml file path for demonstration purpose, please replace with your actual xmlfilepath 

{    // Start the main method body        	       	// Defining a new SAX parser instance and providing Source Objects (files or input stream) to be parsed.       	 	   			                            	     									            .                xMl"     # Invalid Xml file path for demonstration purpose, please replace with your actual xmlfilepath 

XmlParser saxParser = new XmlParser();   // Creating a SAX parser instance	      		        	       	// Defining the XML source to be parsed.       	 	   			                            	     									            .                xMl"     # Invalid Xml file path for demonstration purpose, please replace with your actual xmlfilepath 

saxParser.setFeature("http://xml.org/sax/features/external-parametrization", false); // Disabling external parametricization to avoid access control issues  	      		       	 	   			                            	     									            .                xMl"     # Invalid Xml file path for demonstration purpose, please replace with your actual xmlfilepath 

try {   	// Try block will allow the catch blocks below (below 'catch' statement) to work if an exception is thrown in them. This handles exceptions raised by methods called from within a try-block  	      		       	 	   			                            	     									            .                xMl"     # Invalid Xml file path for demonstration purpose, please replace with your actual xmlfilepath 

{    // Start of the Try block        	       	// Opening input stream and parsing using SAX parser instance.  	      		       	 	   			                            	     									            .                xMl"     # Invalid Xml file path for demonstration purpose, please replace with your actual xmlfilepath 

saxParser.parse(new FileInputStream(INVALID_XML), new Handler()); // Parse the XML data from a specific input source to SAX parser instance and provide Error/warning handler   	      		       	 	   			                            	     									            .                xMl"     # Invalid Xml file path for demonstration purpose, please replace with your actual xmlfilepath 

} catch (IOException e) {   // Catch block will handle IOException that is thrown when opening input stream to the XML source. This would be a problem in case of wrong filename or insufficient permissions   	      		       	 	   			                            	     									            .                xMl"     # Invalid Xml file path for demonstration purpose, please replace with your actual xmlfilepath 

catch (SAXException e) {   // Catch block will handle SAX Exception that is thrown when parsing an XML data. This can be due to access control issues in the parsed content   	      		       	 	   			                            	     									            .                xMl"     # Invalid Xml file path for demonstration purpose, please replace with your actual xmlfilepath 

{   // Catch block will handle SAX Exception that is thrown when parsing an XML data. This can be due to access control issues in the parsed content   	      		       	 	   			                            	     									            .                xMl"     # Invalid Xml file path for demonstration purpose, please replace with your actual xmlfilepath 

{   // Catch block will handle any other exception that occurs during parsing. This is where we could add custom error/warning handling logic   	      		       	 	   			                            	     									            .                xMl"     # Invalid Xml file path for demonstration purpose, please replace with your actual xmlfilepath 

} // End of Catch block to handle generic exception cases. Replace it as per requirements if needed in the entire code   	      		       	 	   			                            	     									            .                xMl"     # Invalid Xml file path for demonstration purpose, please replace with your actual xmlfilepath 

} // End of Main Method Body  	       	// This is end to main method body. We have successfully parsed the XML data using SAX parser and handled all possible exceptions that may arise during parsing process   	      		       	 	   			                            	     									            .                xMl"     # Invalid Xml file path for demonstration purpose, please replace with your actual xmlfilepath 

}   // End of Class Definition. This is the end to our main class definition and we have successfully parsed XML data using SAX parser in Java   	      		       	 	   			                            	     									            .                xMl"     # Invalid Xml file path for demonstration purpose, please replace with your actual xmlfilepath 

} // End of Main Method. This is the end to our main method and we have successfully parsed XML data using SAX parser in Java   	      		       	 	   			                            	     									            .                xMl"     # Invalid Xml file path for demonstration purpose, please replace with your actual xmlfilepath