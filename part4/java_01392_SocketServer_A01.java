import java.io.*;
import java.net.*;

public class java_01392_SocketServer_A01 {

    public static void main(String[] args) {

        int port = 12345; // you can use any port number
        try {

            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {

                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // receive the request
                String request = dis.readUTF();
                System.out.println("Received request: " + request);

                // process the request
                String response;
                if (request.equals("deny")) {
                    response = "Access Denied";
                } else {
                    response = "Access Granted";
                }

                // send the response
                dos.writeUTF(response);
                dos.flush();
                System.out.println("Sent response: " + response);

                socket.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}