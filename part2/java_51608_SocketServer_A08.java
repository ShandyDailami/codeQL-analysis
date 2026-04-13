import java.io.*;
import java.net.*;   // for InetAddress and ServerSocket 

public class java_51608_SocketServer_A08 {    
    public static void main(String[] args){      
        try{           
             int portNumber = 8095;              
             @SuppressWarnings("resource")
              ServerSocket server = new ServerSocket(portNumber);          // Create a socket at specified port  number   and wait for client connection.        	    		   	 	     	   			     	       									        } catch (IOException e){ System.out.println ("Failed to listen on " + portNumber+" :"  +e );}
              Socket welcomeSocket = server.accept();       // Accept the socket that was created in a previous call  and wait for client connection   by calling accept() method of Serversocket class   	    		      } catch (IOException e){ System.out.println ("Failed to establish communication with " +e );}
              PrintWriter outToClient = new PrintWriter(welcomeSocket.getOutputStream(), true);         // Get an output stream from socket and use for writing data   message . 	 	    		   									     	} catch (IOException e){ System.out.println ("Failed to write on " +e );}
              BufferedReader inFromClient = new BufferedReader(new InputStreamReader(welcomeSocket.getInputStream()));         // Get an input stream from socket and use for reading data  message .	 	    		   									     	} catch (IOException e){ System.out.println ("Failed to read on " +e );}
              String clientMessage;             while((clientMessage = inFromClient.readLine()) != null ){         // Read the incoming text from a Client  and print it .  	    		   									     	} catch (IOException e){ System.out.println ("Failed to read on " +e );}
              welcomeSocket.close();        server.close();       }catch(IOException ex) {ex.printStackTrace();}} // Closing the Socket Connection  in case of exception  	    		   									     	} catch (Exception e){ System.out.println ("Error: " +e );}