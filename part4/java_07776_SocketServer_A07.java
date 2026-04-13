import java.io.*;
import java.net.*;

public class java_07776_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000); // port number
        System.out.println("Server is listening on port 5000");

        while (true) {
            Socket clientSocket = serverSocket.accept(); // waiting for client
            System.out.println("New client connected!");

            // Handling client's request
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String request = in.readLine();
            System.out.println("Client says: " + request);

            if (request.equals("auth")) { // simulate a successful authentication
                out.println("AuthSuccess");
            } else {
                out.println("AuthFailure");
            }

            clientSocket.close();
        }
    }
}