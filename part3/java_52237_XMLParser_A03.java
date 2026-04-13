import java.io.*;  // Import the InputStream class java_52237_XMLParser_A03 Java's builtin package  
// Create a new input stream for reading file content into memory
InputStream is = getClass().getResourceAsStream("/sampleXMLFileForParsing");   
try {    
        int i;     
	// Read and print every line of XML until end.  This loop will never run if the resource "/filename" does not exist or its contents are incorrectly formatted as an xml file for example, in a zip archive  
	while ((i = is.read()) != -1) {     // You can replace '/sampleXMLFileForParsing' with your actual XML File name which you want to parse  and the function getClass().getResourceAsStream("/filename") should be replaced by "/yourfile" for example, if it has a different filename.
	System.out.print((char)i);     // Converting int value back into char  
	}      System.out.println("File content printed in Java program");    }  catch (IOException e){         e.printStackTrace();       }}