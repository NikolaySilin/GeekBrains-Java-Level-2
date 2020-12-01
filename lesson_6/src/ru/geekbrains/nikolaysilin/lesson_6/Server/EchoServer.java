package ru.geekbrains.nikolaysilin.lesson_6.Server;

// 1. Написать консольный вариант клиент\серверного приложения, в котором пользователь может писать сообщения,
// как на клиентской стороне, так и на серверной. Т.е. если на клиентской стороне написать "Привет",
// нажать Enter то сообщение должно передаться на сервер и там отпечататься в консоли.
// Если сделать то же самое на серверной стороне, сообщение соответственно передается клиенту и печатается у него в консоли.
// Есть одна особенность, которую нужно учитывать: клиент или сервер может написать несколько сообщений подряд, такую ситуацию необходимо корректно обработать
// Разобраться с кодом с занятия, он является фундаментом проекта-чата
// ВАЖНО! Сервер общается только с одним клиентом, т.е. не нужно запускать цикл, который будет ожидать второго/третьего/n-го клиентов

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) {

        EchoServer server = new EchoServer();
    }

    public EchoServer() {

        // розетка сервера
        ServerSocket server = null; // иницилизация локальной перемннной, так что пишу нолик
        // розетка клиента, это некий поток, который будет подключаться к серверу
        Socket socket = null;

        try {
            // порт, который будет прослушивать наш сервер
            server = new ServerSocket(8189);
            System.out.println("Server is working...");
            System.out.println("Waiting for a client...");
            socket = server.accept();
            System.out.println("New Client");
            // входящий поток
            Scanner in =  new Scanner(socket.getInputStream());
            // исходящий поток
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //или пишем внизу метод
            // с консоли
            Scanner sc = new Scanner(System.in);

            // отправляем в этом потоке сообщение от сервера
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("Server, write you message");
                        String msg = sc.nextLine();
                        System.out.println("The message was send");
                        out.println(msg);
                    }
                }
            }).start();

            // в главном потоке получаем сообщение и шлем эхо
            while (true) {
                String msg = in.nextLine();
                if (msg.equals("/end")) break;
                System.out.println("Client: " + msg);
                //               out.flush(); // это автоматический/принудительный сброс буфера вывода
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close(); // закрываем розетку клиента
                server.close(); // закрываем розетку клиента
                System.out.println("Server closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}