public class java_50216_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{          
            // Create an instance of DocumentBuilderFactory            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();                     
             
            // Use the newDocument() method to create a new document builder         
            @SuppressWarnings("unused") 
			DocumentBuilder builder = factory.newDocumentBuilder();     
              
                /* parse your XML file */   
             Source source = new StreamSource(Main.class   // Input from classpath:your_file.xml for example    
                     ("/Users/myuserhome/samples/sample1234567890-aegdgfghjklmnopqrstuvwxyzabcdefedcba" + ".txt"));  // your XML file here                 
            builder.setEntityResolver(new MyEntResolver());   
             Document document =builder.parse(source);         
              /* print the read content */          
                System.out.println("XML Parsing Finished Successfully.");         } catch (ParserConfigurationException e) {e.printStackTrace();  }} ) ; // your XML file here                 
            MyHandler myhandler = new MyHandler(){   public void startElement(String uri, String localName ,   
             String qName, Attributes attributes){System .out .println ("Start Element : " +qName );}       }              };     DocumentBuilderFactory dbFactory  =         factory;  // your XML file here                  Builder builder =dbFactory.newDocumentBuilder();   MyHandler myhandler= new            Main().MyHandler(){ public void startElement(String uri, String localname ,     
             String qName, Attributes attributes){System .out .println ("Start Element : " +qName );}};  // your XML file here                  builder.parse("your_xmlfile");};   };         } catch (SAXException e) {e.printStackTrace();} });    }}