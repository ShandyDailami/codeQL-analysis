import java.io.*;  // For Input/Output Streams, Socket etc...
import java.net.*;   // Required to use InetAddress & ServerSocket ...etc..   

public class java_51412_SocketServer_A07 {    
 public static void main(String[] args) throws IOException{        
          int port = 80; 
          
          if (args.length != 1){      
              System.out.println("Usage: java SecureServer <port number>");     
              return ;    // Exit the program  
          }        else {               
               try{           
                   port = Integer.parseInt( args[0] );  // Get user input for PORT Number        
            	}           catch (NumberFormatException ex){      
                    System.out.println("Invalid Port number, using default ");   
             	 }       	 		    			         									  	   	       	     						      },// Exit the program if args are not proper...  // Handling any I/O exception ...         return;            };                        catch (IOException ex){                    System.out.println("I'm sorry, an error occured");          
	                  exit(1);                                                            }    });   }}                     );              },            					};                                 			});    	   	}  }) )).start();}}})))});      // End of the main method       };                                                                                          {{{ {{{