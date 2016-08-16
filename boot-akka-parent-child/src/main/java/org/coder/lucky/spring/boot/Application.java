package org.coder.lucky.spring.boot;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.coder.lucky.akka.actors.ParentActor;
import org.coder.lucky.lombok.model.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by IntelliJ IDEA.
 * User: coderbyluck
 * Date: 8/5/16
 * Time: 9:29 PM
 * File Description:
 */
@SpringBootApplication
@EnableScheduling
public class Application {

   private static final Logger LOGGER = LoggerFactory.getLogger("Application.class");

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        LOGGER.info("#######################################");
        LOGGER.info("Starting Spring Boot Application : {}");
        LOGGER.info("#######################################");

        SpringApplication.run(Application.class, args);



    }

    /**
     * Work.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Scheduled(fixedDelayString = "${delay.between.runs.msec}")
    public void work() throws InterruptedException {
        //Akka Config
        final ActorSystem actorSystem = ActorSystem.create("spring-boot-akka-lesson1");
        ActorRef actorRef = actorSystem.actorOf(Props.create(ParentActor.class),"parent-actor-ref");

        for(int i=1;i<=1000;i++){
            actorRef.tell(new Action("Actor-"+i), null);
        }

        Thread.sleep(5000);

        LOGGER.info("Actor System Shutdown Starting...");

        actorSystem.terminate();
    }
}
