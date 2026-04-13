import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03818_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080, 10000, InetAddress.getByName("localhost"));
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client has connected");

                // Create new thread for each client
                new Thread(() -> {
                    try {
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        OutputStream out = clientSocket.getOutputStream();

                        String message;
                        while ((message = in.readLine()) != null) {
                            System.out.println("Received: " + message);

                            // Here you can write the code to verify the integrity of the message.
                            // If the message is not valid, you can send a response and close the connection
                            if (message.equals("A08_IntegrityFailure")) {
                                out.write("IntegrityFailureResponse".getBytes());
                                out.close();
                                clientSocket.close();
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}