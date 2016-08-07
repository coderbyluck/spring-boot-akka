package org.coder.lucky.akka.actor;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import org.coder.lucky.lombok.model.Action;
import org.coder.lucky.lombok.model.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: coderbyluck
 * Date: 8/5/16
 * Time: 10:42 PM
 * File Description:
 */
public class HelloActor extends UntypedActor {
    LoggingAdapter logger = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object message) throws Throwable {

        logger.info("Triggered Actor--> {}, at --> {}", getSelf().path().name(), LocalDateTime.now());
        if(message instanceof Action){
            logger.info("Performing action for command --> {}", ((Action) message).getCommand());
            final Data data = new Data(UUID.randomUUID(), ((Action) message).getCommand());
        }else if (message.equals("Echo")){
            logger.info("Echoooooeeeedd!!!");
        }

    }
}
