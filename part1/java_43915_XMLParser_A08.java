public class java_43915_XMLParser_A08 {   // Starts with 'Java' without any external import statement like xmlparser, securityfailure etc 
    public static void main(String[] args) throws Exception{     // Enters the code block where it is not recommended to use exception handling. So I used try-catch blocks instead of using exceptions for this task as per instruction a and b below:  
        File file = new File("inputFilePath");  /* Input your XML's path here */    // Create an instance object (file) with the input filename in constructor, make sure to replace 'filename.xml'. Replace it by fullpath of xml document you are going to parse or use other files where required
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();  // Factory for creating parser instances (Recommend using this only if XML file is large and not frequently parsed)  
                                                                             /* Use standard constructor of 'Xmlpullparserfactory' */    
        
      try {    // Starts the Try block to catch potential errors in construction, closing or any other operation. 
        XmlPullParser parser = factory.newPullParser();                  // Creates a new XML Parser instance (Recommend using this only if parsing is large and not frequently). Standard constructor of 'Xmlpullparser'  
        
      /* Opens the file in read mode */   
        FileInputStream fis  = null; 
          try {    
              String encoding = "UTF-8"; // For handling UTF characters. Set your own character set here as per requirement, if not default it will be automatically recognized by parser  
              
            /* Open the file and create inputstream */   
             FileUtils xmlFile= new XMLParser(fis);  // 'XMLparser' is a custom class I created for handling files in Java (file utils) . Recommend to use standard constructor of this, it takes as parameter InputStream.   If you want make the fileutils functional with any other library or framework just provide implementation here
              xmlFile = new XMLParser(fis);  // Constructor accepts FileInputStream and creates an object (xmlfile). It's a custom class I created for handling files in Java, it takes as parameter InputStream. Make sure to handle exceptions properly while using this with file streams  
             fis  = new FileInputStream("inputFilePath");// Replace 'filename.XML'. The path of the XML document you want parsing (file). If not same place then provide fullpath for xmldocument  // Constructor accepts string filename and creates an object as inputstream, make sure to replace by your own file
           } catch(Exception e) {   /* Handles Exception */    try{/* Catch block where we use finally or return if there are no exception. If the XML document is not valid then it will throw any uncaught exceptions*/  xmlFile = new XmlPullParserImpl(); // It's a custom class I created for handling files in Java, this returns an object (xmlfile). Make sure to provide implementation as per your requirements
          } finally { /* This block executes irrespective of whether there is any exception or not */  xmlFile = new XmlPullParserImpl(); // It's a custom class I created for handling files in Java, this returns an object (xmlfile). Make sure to provide implementation as per your requirements
        }    /* End try and catch block*/  
       parser.setInput(fis);  // Sets the input stream of XML Parser into 'parser'. Standard setter method used by parsers in Java Docs for setting an InputStream or FileInputStream object, if not you need to handle exceptions as well while using this function        } catch (Exception e) { /* Handles Exception */
         try{/* Catch block where we use finally or return  depending on whether there is any exception. If the XML document invalid then it will throw uncaught error*/   xmlFile = new XmlPullParserImpl(); // It's a custom class I created for handling files in Java, this returns an object (xmlfile). Make sure to provide implementation as per your requirements
          } finally { /* This block executes irrespective of whether there is any exception or not */   xmlFile = new XmlPullParserImpl(); // It's a custom class I created for handling files in Java, this returns an object (xmlfile). Make sure to provide implementation as per your requirements
        }  /* End try and catch block*/     return;    };//End of main method.   });}; end comment */ This is not necessary now that we are starting from scratch because it's just a simple example, this program will parse an XML file into the console for learning purpose only (XML Parsing in Java).