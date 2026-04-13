import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_52283_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        String inputFilePath;          //input xml file path             
	    System.out.println("Enter the XML File Path: ");            
            BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));   	  
            inputFilePath=reader.readLine(); 
          		        				    			     	 	     					       	       						         	   
                                    //validate if file exists in the path              System.out.println(inputFilePath);             File xmlfile = new File("D:\\mydata");                            	   }                          catch (Exception e) {            System.out.print ("Error!");           return;         }} 		    			
        DocumentBuilderFactory dbFactory = 				      DocumentBuilderFactory.newInstance();   					      	   
                                                    Document document = dbFactory .newDocumentBuilder().parse( new File(inputFilePath));   } catch (ParserConfigurationException e) {          System.out.println("Failed to parsing the input file " + e);           return;      }} 		    			              				   	      					
        //print out access control info about all nodes in xml document            NodeList nodeList =document .getElementsByTagName(“*”) ;             for (int i = 0;i <nodeList. getLength(); ++i){                     String tagname=nodeList.item(i).getNodeName() 
         if ((tagname != null ) && (!tagname .equals(""))&&(!tagname! equalsIgnoreCase "xml")   //to avoid security sensitive operations, ignore all nodes with name '<XML>' or similar      System.out.println ("Access Control Information for node :" + tagName ); }}}