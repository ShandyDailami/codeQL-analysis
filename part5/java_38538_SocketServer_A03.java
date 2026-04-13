import java.io.*;
import java.net.*;

public class java_38538_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // create a socket server at port 2020
            ServerSocket server = new ServerSocket(2020);

            System.out.println("Server is listening on port 2020...");

            // keep waiting for client connection
            while(true) {
                Socket socket = server.accept();

                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // create a new input stream and output stream
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // read a message from client
                String message = dis.readUTF();
                System.out.println("Received: " + message);

                // send a response back to client
                String response = "Hello, Client!";
                dos.writeUTF(response);
                System.out.println("Sent: " + response);

                // close the connection
                socket.close();
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}