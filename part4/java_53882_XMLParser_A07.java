public class java_53882_XMLParser_A07 {
    public static void main(String[] args) throws Exception{
        String xml = "<note>\n" + "\n" + 
                "  <to>Tove</to>\n"  + "\n"+ 
                "  <from>Jani</from>\n"  + "\n"   + 
                "  <heading>Reminder</heading>\n" + "\n" 
                +"   <body>Don't forget me this weekend!</body>\n" + 
              " <note>";                   // root element of the document.  
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory .newInstance();   
          
       /* A Builder for manipulating XML contents using DOM */ 
          DomHandler domh= null;        
     try {                           
             if ((domh  = dbFactory.newDocumentBuilder()) == null)   //can throw SAXException     
            System.out.println("No Document Builder Factory available");       
           /* use of builder to read the XML file */   
                domh .setOutputCharacters(true); 
                  XmlReader reader =domh .getXmlReader();    
                        // create an instance   DOMHandler         
                          } catch (Exception e) {                          
                            System.out.println("Error parsing your xml: " +e );    return;      };             
                try{                       /*  using read() method to parse the XML file */             reader .read();}       //parse and print all event details in a loop          catch (Exception e) {   Console.WriteLine ("error processing exception"+E); }               if(reader != null){ Reader().closeDocument ;
                System outprintln("The document is closed");  };                       });                   }}