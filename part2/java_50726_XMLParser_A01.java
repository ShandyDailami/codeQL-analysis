import javax.xml.parsers.*;   // Import the required parser classes from JDK library   
// import java.io.*, for reading file using FileInputStream;    
 
public class java_50726_XMLParser_A01 {      
      public static void main(String[] args) throws ParserConfigurationException{       
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();   // Create a factory object   
            
	    try (FileInputStream fis  = new FileInputStream("sample1234567890/BooksXML_vilaineCoderStyleSheet-withNamespacesAndAttributesInsideTagsOnlyOneByUserInputed.xml")){  // Open the file    
               DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();   // Create a new document builder   
               
               System.out.println("With Namespace: ");          
        	            parse(dBuilder, fis);          } catch (IOException e) {                 showExceptionDetail(e)};  try{        withNamespaceParseAndPrintContentOnConsole ("sample1234567890/BooksXML_vilainecoderstylesheetsheet-withnamespaces.xml");}catch(XmlPullParserException ex){showExceptionDetail (ex); }    
      // End of main method        try { parse("SampleTextDocument", "sample1234567890/BooksXML_vilainecoderstylesheetsheet-withnamespaces.xml");} catch(XmlPullParserException ex) 	{ show Exception Detail (ex); }
      // End of code to parse XML file with namespace       try {parseAndPrintContentOnConsole("sample1234567890/BooksXML_vilainecoderstylesheetsheet-withnamespaces.xml");} catch(XmlPullParserException ex) 	{ show Exception Detail (ex); }
      // End of code to parse XML file without namespace       try {parseAndPrintContentOnConsole("sample1234567890/BooksXML_vilainecoderstylesheetsheet-withoutnamespaces.xml");} catch(XmlPullParserException ex) 	{ show Exception Detail (ex); }
      // End of code to parse XML file with namespacedata       try {parseAndPrintContentOnConsole("sample1234567890/BooksXML_vilainecoderstylesheetsheet-withnamespacesanddata.xml");} catch(XmlPullParserException ex) 	{ show Exception Detail (ex); }
     // End of code to parse XML file with broken access control       try {parseAndPrintContentOnConsole("sample1234567890/BooksXML_brokenAccessControl.xml");} catch(XmlPullParserException ex) 	{ show Exception Detail (ex); }
             System.out.println("\nEnd of Main Method\n ");    }}   // End if statement, and closing brace on the same line for clarity          protected static void parseAndPrintContentOnConsole    
       ...(snip...)...//cut here as it's not possible to continue this process due current length constraints       `