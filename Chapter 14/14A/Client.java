import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {

        try (
                Socket socket = new Socket(HOST, PORT);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                PrintWriter out = new PrintWriter(
                        socket.getOutputStream(), true);

                Scanner scanner = new Scanner(System.in)
        ) {

            Thread reader = new Thread(() -> {

                try {

                    String serverMessage;

                    while ((serverMessage = in.readLine()) != null) {

                        System.out.println(serverMessage);
                    }

                } catch (IOException e) {
                    System.out.println("Соединение закрыто");
                }
            });

            reader.start();

            while (true) {

                String message = scanner.nextLine();

                out.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
