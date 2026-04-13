import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_00303_SocketServer_A01 {
    private static final int PORT = 8080;
    private static final String BROKEN_ACCESS_CONTROL_MESSAGE = "Broken Access Control: Attempted to read password from client";

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
            executorService.execute(new ClientHandler(executorService));
        }
    }

    static class ClientHandler implements Runnable {
        private final ExecutorService executorService;

        ClientHandler(ExecutorService executorService) {
            this.executorService = executorService;
        }

        @Override
        public void run() {
            try {
                Socket client = new Socket("localhost", PORT);
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                String password;
                while ((password = in.readLine()) != null) {
                    if (password.equals("secret")) {
                        out.println(BROKEN_ACCESS_CONTROL_MESSAGE);
                    } else {
                        out.println("Access granted");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                executorService.remove(this);
            }
        }
    }
}