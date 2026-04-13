import java.net.*;
import java.io.*;

public class java_26710_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 4445;

        try {
            // Create a datagram socket and listen on the specified port
            DatagramSocket serverSocket = new DatagramSocket(port);

            // Receive data from the client
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

            System.out.println("Server started on port: " + port);

            while (true) {
                // Receive a datagram packet
                serverSocket.receive(receivePacket);

                // Extract the client IP and port from the packet
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Convert the received data to a string
                String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());

                System.out.println("Received from client " + clientAddress.getHostAddress() + " on port " + clientPort + ": " + receivedData);

                // Create a data packet to send back to the client
                String response = "Hello, client!";
                byte[] sendBuffer = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);

                // Send the response to the client
                serverSocket.send(sendPacket);
            }
        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}