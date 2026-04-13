import javax.xml.parsers.*;  // Import XML parser classes (not external frameworks)  
public class java_43048_XMLParser_A01 {   
     public static void main(String[] args){     
         try{         
             String xmlFile = "sample.xml";      
                  Parser p=null;          
                 BufferedReader br=  null ;  //reads the input source             
                   int lineNumber = 0;               
                      if (Platform.isServer()|| Platform .isStandard()) {    
                          System.out.println("This program is not for use on a client or server environment.");         
                         return -1;}            else{    //creates an instance of the XML parser       }  p=new SAXParser();      if (p==null){        new ErrorHandler(){           @Override             public void error(SAXParseException e) { throw new RuntimeException("Error in line "+e.getLineNumber());}};
                  try{               br = new BufferedReader(  //reads the file into a buffer          reader=p.getDefaultHandler().asInheritableBufferedReader();       } catch (FileNotFoundException e) { throw new RuntimeException("XML input not found on server "+xmlfile);}};
            String sCurrentLine = "";  
                    while ((lineNumber < 5))  //reads the line from buffer          if(br.ready()){     try{             reader=new FileReader ( xmlFile );       } catch (Exception e) { throw new RuntimeException("Unable to read file");}};              br =  null ;  
                     while ((lineNumber < 5))  //reads the line from buffer          if(br.ready()){ sCurrentLine = reader.readLine();++lineNumber;}       } catch (IOException e) { throw new RuntimeException("Unable to read file");}}}        System . out . println ("Starting parsing of XML document" + xmlFile);
                  try{               DocumentBuilderFactory dbFactory =  //creates a factory for the parser          DocumentBuilderFactory dbfac =       DOMSource. Factory;      p=dbfac.newDocumentBuilder();} catch (Exception e) { throw new RuntimeException("Unable to create XML Parser");}}
              try{               Documents documentsList  =p .parse(xmlFile);//parses the document list         docs =     parser ….. //handles a single Document and parses it.   } catch (SAXException e) { throw new RuntimeException("Unable to parse XML");}};
              System out . println ("Ending of Parsing " + xmlFile);}         
            catch(Exception ex){throw  new ExceptionInInitializerError();};    //catch block      for error handling, uncomment and implement the code     @Override             public void warning (SAXParseException e) { System.out . println ("Warning in line"+e.getLineNumber() + ": " + 
              e.getMessage());}   }},  int column = 0; //unused variable         if(ex instanceof RuntimeException){       for (; ex != null ; ++column ){ try { throw ( Exception) exp;} catch (( Exception) excid =null , false)}}}});    };     System . out