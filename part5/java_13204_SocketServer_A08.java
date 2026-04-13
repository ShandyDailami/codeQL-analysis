import java.io.*;
import java.net.*;

public class java_13204_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected.");

            // Create a new thread to handle communication with the client
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }

    static class SocketHandler implements Runnable {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        SocketHandler(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);

                    // Here you can implement your security-sensitive operations related to A08_IntegrityFailure.
                    // For example, you can check if the request is valid and trust the client, or you can encrypt the response
                    // and send it back.

                    out.println("Server response: " + request);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}