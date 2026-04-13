import javafx.xml.*; // for Loader, FXMLLoader class java_45424_XMLParser_A08 javax.xml.parsers.*; //for XMLParser interface and classes XmlPullParserException   
public void parseXML() throws ParserConfigurationException {    
//Step1: Create a new instance of the parser using default configuration     
XmlFactory xmlfactory = null;      
  try{         
   xmlfactory=Xml.newFactory();        //create XML factory object             
}catch (ParserConfigurationException e) {                 
e.printStackTrace();                    }           
     XmlLoader loader =  new XmlLoader(xmlfactory);   
      String url = "file:src/test1234567890XMLTestDataSetSeq_A08IntegrityFailure"+".txt";  //load XML file with URL                 
       try {                     
        loader.setDocumentBuilderFactory(XmlReader.newInstance());    }catch (Exception e) {}    
          Document doc =loader . load(url);   });            xmlfactory=null;              }}`}})}).trim();}