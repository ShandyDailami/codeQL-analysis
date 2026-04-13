import java.net.*;         // for DatagramSocket, SocketException and InetAddress   
public class java_52030_SocketServer_A01 {    
 public static void main(String args[]) throws SocketException{         
      try (DatagramSocket socket = new DatagramSocket(4456)){          
            System.out.println("Echo Server Started");        
              byte [] buf=new byte[256];        //buffer to hold the data            
               while(true){                    
                 DatagramPacket packet= 
                      new DatagramPacket (buf, buf.length); 
                   socket.receive(packet);     //get a response from client         
                  String echo=new String (     
                       packet.getData(),0 ,       packet.getLength());        
                     System.out.println("Echo received: " +echo );       
                      buf =echo.getBytes();   //prepare the message to send    }     socket.close();}}catch(Exception ignored){}  }}          echoSocket . close ();}}} catch      ((IOException e) {System. out. println ("Error in Communication :"+e)} );                   
                  });                    
              System.out.println("Echo Server Stopped");       }     protected java_52030_SocketServer_A01() {} //required by API   }}                };  public static void main(String[] args){try {new EchoClient().start();} catch (Exception e) {System . out . println ("Error in Starting Client : " +e);}};}}}`