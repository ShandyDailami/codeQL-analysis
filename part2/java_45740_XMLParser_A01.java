import javax.xml.parsers.*; // import JavaXMLParsers package   
import org.w3c.dom.*;   // Import DOM and XPath API    
import java.io.*;       // for File I/O operations     

public class java_45740_XMLParser_A01 { 
	DocumentBuilderFactory dbFactory;//factory object       
	public DocumentBuilder dBuilder;	//builder object        
	  public static void main(String[] args)  
	    throws ParserConfigurationException, IOException   
	{         		     //main method           
	        String filePath = "securitysensitivefile.xml";  /*File location*/              	      
	      parseXML(filePath);     				//calling our function       					            				        						                                                            								                                                                                   }   public static void parseXML (String file) throws ParserConfigurationException, IOException {   		     dbFactory = DocumentBuilderFactory.newInstance();          dBuilder=dbFactory.newDocumentBuilder();       // create a new document builder          
	                  System.out.println("Parsing complete in dir " +file);  					  File xmlFile = new File( file );     				        		    				//parse the XML file            Document doc =dBuilder .parse(xmlFile) ;                dDoc‌​n is used to save newly created DOM    objects                  	
           /* Create a new delegate object, parsing using the builder */  					  XPath xp=XPathFactory.newInstance().newXPath();    				        		          String expression = "/store/book";       //use an Xpath query     			        NodeList nodes =  (NodeList)xp .evaluate(expression ,doc, XPathConstants.NODESET);              
                    for  (int temp=0;temp<nodes.getLength();+++){          System‌​.out.print("Book " + ++Temp );          				Element element = (Element)(nodes.item(tem));     //we can now handle individual nodes in a list fashion  
                        /*Print out the details of each book */                String title  =element .getElementsByTagName ("title"). item (0).getTextContent();             System‌​out..println("Title: " + Title);                      					    } 				        				}             	    		      catch(Exception e){System.out.printlne("Problems parsing the XML file");e . printStackTrace() ;}}