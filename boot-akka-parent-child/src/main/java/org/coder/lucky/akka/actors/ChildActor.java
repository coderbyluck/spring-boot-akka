package org.coder.lucky.akka.actors;

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
public class ChildActor extends UntypedActor {
    /**
     * The Logger.
     */
    LoggingAdapter logger = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object message) throws Throwable {

        if(message instanceof Data){
            logger.info("*****CHILD***** Recieved Data from Parent as --> {}", message);
        }else if (message.equals("Echo")){
            logger.info("Echoooooeeeedd!!!");
        }

    }
}
