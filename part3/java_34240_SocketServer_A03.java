import java.io.*;
import java.net.*;

public class java_34240_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Create a thread for handling the communication with the client
            Thread t = new Thread(new ClientHandler(in, out));
            t.start();
        }
    }

    static class ClientHandler implements Runnable {
        BufferedReader in;
        PrintWriter out;

        public java_34240_SocketServer_A03(BufferedReader in, PrintWriter out) {
            this.in = in;
            this.out = out;
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Inject code here, for example, to prevent SQL injection
                    // message = new String("Your message here");

                    out.println("Server received: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}