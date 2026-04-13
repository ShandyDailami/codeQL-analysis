import java.net.*;
import java.io.*;

public class java_03884_SocketServer_A01 {

    public static void main(String[] args) {
        int port = 6000;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client has connected!");

                // Here, I'm creating a new thread for each client. You could also use a ThreadPoolExecutor for more performance.
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // This is a sample client handler. In a real application, you'd have multiple clients, so you'd need to create a pool of these threads.
    static class ClientHandler implements Runnable {

        Socket socket;

        public java_03884_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Echo: " + message);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}