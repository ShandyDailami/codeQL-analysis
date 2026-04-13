import java.io.*;
import java.net.*;

public class java_22412_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server is listening on port 6000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A new client connected");

            // Handling the client's request in a new thread
            Thread t = new Thread(new ClientHandler(socket));
            t.start();
        }
    }

    static class ClientHandler implements Runnable {
        Socket socket;

        public java_22412_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);
                    out.writeBytes("HTTP/1.1 200 OK\n\n");
                    out.writeBytes("<h1>Hello, client!</h1>\n");
                }
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}