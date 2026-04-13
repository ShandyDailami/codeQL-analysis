import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_34313_SocketServer_A08 {

    private static final int PORT = 6000;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
            try {
                Socket socket = new Socket(HOST, PORT);
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Client connects, start a new thread to handle the communication.
                executorService.execute(new ClientHandler(reader, writer));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler implements Runnable {

        private final BufferedReader reader;
        private final PrintWriter writer;

        public java_34313_SocketServer_A08(BufferedReader reader, PrintWriter writer) {
            this.reader = reader;
            this.writer = writer;
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    // Handle the message, for example, verify the integrity of the data.
                    // If the data is not valid, send an integrity failure response to the client.
                    if (message.equals("invalid data")) {
                        writer.println("IntegrityFailure");
                    } else {
                        // Handle the message normally.
                        System.out.println("Received: " + message);
                    }
                    writer.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}