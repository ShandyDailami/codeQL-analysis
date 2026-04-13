import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_19345_SocketServer_A03 {

    private static final int PORT = 1234;
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress() + " connected");

                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_19345_SocketServer_A03(Socket socket) {
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
            String message;
            try {
                if ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Example of a possible injection point.
                    // This can be replaced with any other code.
                    String newMessage = message + " Server";
                    out.println(newMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            socketClose();
        }

        private void socketClose() {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}