import java.io.*;
import java.net.*;

public class java_28349_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client connection...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String clientMessage;
        while ((clientMessage = in.readLine()) != null) {
            System.out.println("Received: " + clientMessage);

            // Here, we are checking for A07_AuthFailure for authentication failure
            if (clientMessage.equals("A07_AuthFailure")) {
                // If the message is "A07_AuthFailure", we will deny the connection and send a response
                out.println("A07_AuthFailureDenied");
                out.close();
                socket.close();
            } else {
                // If the message is not "A07_AuthFailure", we will send a response
                out.println("Authentication Successful");
                out.close();
            }
        }
    }
}