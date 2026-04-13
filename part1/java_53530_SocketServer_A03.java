import java.io.*;
import java.net.*;

public class java_53530_SocketServer_A03 {  
    public static void main(String args[]) throws Exception{     
        ServerSocket server = new ServerSocket(6013);         //Create a socket on port number 'port' and listen for incoming connections         
    	System.out.println("Waiting For Connection..");      
            Socket s=server.accept();                     	//Accept the client connection   while waiting 
           System.out.println("\nConnected To The Client: "+s);    //After accepting, print a message for connected clients and their IP address     	    	   		       			            	       	 				                    					        						       } catch (Exception e){ s .close(); server . close() ; 	}
           try{ BufferedReader in=new BufferedReader( new InputStreamReader((s.getInputStream())) ); PrintWriter out = new PrintWriter(s.getOutputStream(),true);   //Reading and writing stream from client to socket & back   	    		          }catch (Exception e){ s .close(); server . close() ; 	}
           String msg,response;     	//define a variable of type string for incoming message                    try{ while((msg=in.readLine())!=null) { System.out.println("Client :"+msg); response = process(msg)); out.println (response ); } catch {} finally{} s .close(); server . close() ; 	}  
        public static String process(String str){     //define a method for security-sensitive operation related to injection attacks      	str=new Scanner(Str).nextLine().replaceAll("",""); return "Server :"+ Str; }        	//Replace the input string with an empty one. The server receives and sends back modified strings       
    }}  //End of Main method     s .close(); if (s !=  null) { try{ s .close();} catch(Exception ex){}}      ;if (server !=null ){try{  	 }catch{}finally {}	} });      		        	  };          	//Closing all streams