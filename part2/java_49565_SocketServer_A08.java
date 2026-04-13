import java.io.*;
import java.net.*;

public class java_49565_SocketServer_A08 {  
    public static void main(String args[]) throws Exception{    	
        ServerSocket server = new ServerSocket(8090);//creating a socket at port no 6754     		      			         	       	     	    }        	 					           //accept request from client                                       	}  								               	//send and receive message back to the same location using DatagramPacket
        while (true) {    	            				    Socket sock = server.accept();                      PrintWriter out =  new 		      			          PW(sock.getOutputStream());      //stream channel for sending data through socket  					          	  }              if((input=br.readLine())!=  null){
            System.out.println("Client: " + input);                 	     out.println (“Server :”+ ‘’request sent from client");          try {sock.close();    server.close()} catch(IOException e) {} }      if((input=br.readLine())!=  null){
            System.out.println("Client: " + input);                      out .print ("Server :”+ ‘’request sent from client");   try {sock.close();    server.close()} catch(IOException e) {} }                 					          	               	}      		     				    			         
        br = new BufferedReader (new InputStreamReader((socket.getInputStream())         //reading the message  received by socket to display in console,then close connection   try {sock .close();    server.closed()} catch(IOException e) {} }               					          		}    		     				    			         
        if ((input = br.readLine())) != null                   System.out.println("Client: " + input);                     out  println ("Server :”+ '’request sent from client");         try {sock .close();    server sockerclosed()} catch(IOException e) {} }                					          	               	}