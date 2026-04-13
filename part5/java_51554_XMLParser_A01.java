import org.xml.sax.SAXException;   //for SAX parser library to handle XML documents (Input) 

import javax.xml.parsers.*;     // for DOM and other parsing libraries, we use JAXP API which is part of standard java SDK package   

import org.w3c.dom.*;           // used by the SAX handler   to represent a document tree (Output) 

import javax.xml.transform.stream.StreamSource;     //used for Source and XSLT transformations in XML documents or files using an STREAM-based transformation, which supports both memory streams as well file based inputs/outputs by providing the URL of any source InputDocument Stream   (Input)

import javax.xml.transform.*;          //for TransformFactory class java_51554_XMLParser_A01 create a XSLT processor for transforming XML text in and out -> Output    used with an STREAM-based transformation, which supports both memory streams as well file based inputs/outputs by providing the URL of any source InputDocument Stream   (Input)

import javax.xml.transform.dom.DOMSource;     //used for Source XML documents to be transformed  -> Output    used with an STREAM-based transformation, which supports both memory streams as well file based inputs/outputs by providing the URL of any source InputDocument Stream   (Input)

import javax.xml.transform.stream.StreamResult;     //used for Resulting document after applying transformations -> Output    used with an STREAM-based transformation, which supports both memory streams as well file based inputs/outputs by providing the URL of any source InputDocument Stream   (Input)

import java.io.*;                //Used to read and write files in Java         for FileReader or Buffered Reader classes  etc .        used with an STREAM-based transformation, which supports both memory streams as well file based inputs/outputs by providing the URL of any source InputDocument Stream   (Input)

import java.util.*;           //used to use List data structure and other utility methods in Java     for reading a list from xml -> Output    used with an STREAM-based transformation, which supports both memory streams as well file based inputs/outputs by providing the URL of any source InputDocument Stream   (Input)

import java.util.regex.*;      //for using Regular Expressions  like Pattern and Matcher classes to match usernames against certain patterns -> Output    used with an STREAM-based transformation, which supports both memory streams as well file based inputs/outputs by providing the URL of any source InputDocument Stream   (Input)