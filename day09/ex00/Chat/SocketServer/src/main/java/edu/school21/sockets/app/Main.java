package edu.school21.sockets.app;

import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.repositories.UsersRepository;
import edu.school21.sockets.server.Server;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SocketsApplicationConfig.class);

        UsersRepository usersRepository = context.getBean("usersRepositoryBean", UsersRepository.class);
        System.out.println(usersRepository.findAll());

        context.close();

        try {
            Server server = new Server(8081);
            server.run();
            server.close();
        } catch (IOException e) {
            System.err.println(e);
//            e.printStackTrace();
        }
    }
}
