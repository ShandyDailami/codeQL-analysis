import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_30300_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        System.out.println("Starting server on port " + port);

        // Start server
        ServerThread serverThread = new ServerThread();
        serverThread.start();

        // Keep the server running until it's stopped
        while (true) {
            Thread.sleep(1000);
        }
    }

    static class ServerThread extends Thread {
        Socket socket;
        BufferedReader reader;
        PrintWriter writer;

        @Override
        public void run() {
            try {
                socket = new Socket("localhost", port);
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Client says: " + message);
                    // Here you can add the logic to handle the messages
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}