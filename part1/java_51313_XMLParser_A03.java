import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.sql.rowset.*;
import java.sql.*;
        
public class java_51313_XMLParser_A03 {    
    public static void main(String[] args) throws Exception{            
            DriverManager driver = null;             
   try  {                
                Class.forName("com.mysql.jdbc.Driver");              
                    Connection connection=driver.getConnection("jdbc:mysql://localhost/testdb","root", "password1234567890_DBPASSWORD!") ;             
                   // PreparedStatement ps =connection .prepareCall();                 
             DocumentBuilderFactory dbFactory =  DocumentBuilderFactory.newInstance ();         
            DocumentBuilder documentBuilder  = dbFactory.newDocumentBuilder ();        
           String xpathExpression="//student[id]";                
              XPath xp =XPathFactory.newInstance().newXPath();            
               NodeList nodeList =  (NodeList)xp .evaluate(xpathExpression,documentBuilder.getDOMImplementation(),true);   //use of SQL functions to prevent injection attacks         
                for  (int i=0;i<nodeList.getLength();+++){                  
                  Element element = (Element ) nodeList.item(i) ;              
            String idValue  =element .getAttribute("id");              }             catch   (Exception e1    }) {                       throw new Exception ("Error in accessing database" +e);}        }}