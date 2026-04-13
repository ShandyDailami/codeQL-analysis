import java.io.*;   // Import of InputStream class java_49564_XMLParser_A01 read file as a stream   
      import javax.xml.parsers.*;     //Importing XML parser from Java library        
public Class XmlParsing{      
//Main method       
 public static void main(String[] args){ 
          String xmlfile = "sample_data/books.xml";   /*Your file path goes here*/   
           parse(xmlfile);      //Call to our function which reads and parses XML data    
 }            
         private static DocumentBuilderFactory dbFactory;      
        @SuppressWarnings("unused")  void init(){             
                try {                     dbf = new DocumentBuilderFactory();                   if((dbFactory=dbf.newInstance())==null){                       System.out.println("Failed to create a builder"); return;}                  } catch (Exception e) {}                    dbFactory =  null;               }}   //Main method ends          
        public static void parse(String fileName ) {     DocumentBuilder dbuilder;      try{dbf = DocumentBuilderFactory.newInstance();    dbuilder=dbf.newDocumentBuilder();}catch(ParserConfigurationException pce){System.out.println("Problem configuring parser"); }   //parse XML with DOM
  if (fileName == null) { System.out.println("File name is empty."); return;     }      Document doc = dbuilder.parse(new File( fileName ));    NodeList nList =  doc.getElementsByTagName("*");        for(int temp=0 ;temp<nList.getLength();temp++){          //Iterate through all the elements in XML 
                  if (doc == null) { System.out.println("\nUnable to retrieve nodes; element found is : " + doc.getElementsByTagName("*").item(t).getTextContent() );      return;}            Element eElement = (Element) nList.item(temp);     //prints the tag name and attribute 
                  System.out.println("\nCurrent Element: [ "+eElement.getNodeName() +" ]");         }    try { if (!(dbf instanceof DocumentBuilderFactory)) throw new Exception("Can't create a factory instance.");}} catch (Exception e)   //End of function