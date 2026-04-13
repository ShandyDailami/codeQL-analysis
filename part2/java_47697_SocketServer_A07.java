import java.net.*;   // For DatagramSocket, InetAddress and other classes

public class java_47697_SocketServer_A07 {   

     public static void main(String[] args) throws Exception{          

          int serverPort = 8091;  // Define your port number here                    

         try (DatagramSocket socket = new DatagramSocket(serverPort))   {            

            byte [] receiveData=new byte[512];       // Receive buffer. Increase as needed, but not too large                  

           while(true)     {                           

              DatagramPacket packet = 

                new DatagramPacket(receiveData , receiveData.length);  

               socket.receive(packet);  //Waiting for a message           

             String sentence = new String (      packet.getData(),0,       packet.getLength());   

              System.out.println("RECEIVED: " +sentence);        }    

         }catch(Exception e){e.printStackTrace();}  // Error handling in a multi-threaded environment          

      }}`