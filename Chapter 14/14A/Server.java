//Задания к главе 14
//        Вариант А
//        Создать на основе сокетов клиент/серверное приложение:
//        7. Чат. Сервер рассылает всем клиентам информацию о клиентах, вошедших
//        в чат и покинувших его.
//ТОРЯШИЕВ ЖАРГАЛ Б763-2А
//НАДО ЗАУПСТИТЬ СЕРВЕР А ПОСЛЕ НЕСКОЛЬКО РАЗ КЛИЕНТ



import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Server {

    private static final int PORT = 12345;

    // Список клиентов
    private static final Set<ClientHandler> clients =
            ConcurrentHashMap.newKeySet();

    public static void main(String[] args) {

        System.out.println("Сервер запущен...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (true) {

                Socket socket = serverSocket.accept();

                ClientHandler client = new ClientHandler(socket);

                clients.add(client);

                new Thread(client).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Отправка всем клиентам
    public static void broadcast(String message) {

        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    // Удаление клиента
    public static void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    // Класс клиента
    static class ClientHandler implements Runnable {

        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String name;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try {

                in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                out = new PrintWriter(
                        socket.getOutputStream(), true);

                // Имя клиента
                out.println("Введите имя:");

                name = in.readLine();

                System.out.println(name + " подключился");

                broadcast(">>> " + name + " вошёл в чат");

                String message;

                while ((message = in.readLine()) != null) {

                    broadcast(name + ": " + message);
                }

            } catch (IOException e) {

                System.out.println(name + " отключился");

            } finally {

                broadcast("<<< " + name + " покинул чат");

                removeClient(this);

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }
    }
}