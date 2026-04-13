import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_30990_SocketServer_A08 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");
            Handler handler = new Handler(socket);
            executor.execute(handler);
        }
    }

    static class Handler extends Thread {
        Socket socket;

        public java_30990_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);
                    String serverMessage = "Server: " + clientMessage;
                    output.writeBytes(serverMessage + "\n");
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}