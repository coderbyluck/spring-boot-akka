package org.coder.lucky.spring.boot;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.coder.lucky.akka.actor.HelloActor;
import org.coder.lucky.lombok.model.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by IntelliJ IDEA.
 * User: coderbyluck
 * Date: 8/5/16
 * Time: 9:29 PM
 * File Description:
 */
@SpringBootApplication
public class Application {

   private static final Logger LOGGER = LoggerFactory.getLogger("Application.class");

    public static void main(String[] args) throws InterruptedException {
        LOGGER.info("#######################################");
        LOGGER.info("Starting Spring Boot Application : {}");
        LOGGER.info("#######################################");

        SpringApplication.run(Application.class, args);

        //Akka Config
        final ActorSystem actorSystem = ActorSystem.create("spring-boot-akka-lesson1");
        ActorRef actorRef = actorSystem.actorOf(Props.create(HelloActor.class),"simple-actor");

        for(int i=1;i<=1000;i++){
            actorRef.tell(new Action("Actor-"+i), null);
        }

        Thread.sleep(5000);

        LOGGER.info("Actor System Shutdown Starting...");

        actorSystem.terminate();

    }
}
