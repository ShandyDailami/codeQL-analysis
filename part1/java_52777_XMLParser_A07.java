public class java_52777_XMLParser_A07 {  
    public static void main(String[] args) throws Exception{ 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder builder=factory.newDocumentBuilder();         
          
        //parse xml file               
        org.w3c.dom.Document doc =  builder.parse("sample-file.xml");  
           
        XPath xpath = XPathFactory.newInstance().newXPath(); 
        
        String expression="/BookStore/Book[1]";      //selects first book from Bookstore      
          
        NodeList nodeList;    
              
        try{            
          System.out.println("Root element:"+doc.getDocumentElement().getNodeName());  
           
         /* select nodes with XPath */ 
              if(nodeList=xpath.selectNodes(expression)){      
                for (int i = 0;i <= nodeList.getLength()-1 ; ++i) {    //loop through the selected XML tags     
                    Node nNode = nodeList.item(i);  
                   System.out.println("\nBook "+ ((i+1) +" details :"));    
                       if (nNode != null){                        
                            System.out.print("Title: ");    //accessing elements by their names 
                             NodeList nl = nNode .getChildNodes();  
                              for(int j = 0;j<nl.getLength();++j)     {     
                                  if (nl.item(i).getNodeType() == Node.ELEMENT_NODE ){       System.out.println((Element) i +": "+ nl.item(h));  }                          //printing element details                  }}   catch Exception e {}}}}   ^C to terminate it!