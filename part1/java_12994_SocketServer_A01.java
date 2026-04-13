import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12994_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 5000; // the port number to listen on

        try {
            // create a server socket
            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Waiting for client connection...");

            // keep listening until a client is connected
            while (true) {
                // accept a client socket
                Socket clientSocket = serverSocket.accept();

                // get the ip address of the client and print a message
                InetAddress ip = clientSocket.getInetAddress();
                System.out.println("Client IP: " + ip.getHostAddress());

                // get the output stream of the client socket
                OutputStream outToClient = clientSocket.getOutputStream();
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                
                // send a message to the client
                outToClient.write(("Hello, Client!").getBytes());

                // close the connection
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}