package org.coder.lucky.akka.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
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
public class ParentActor extends UntypedActor {
    /**
     * The Logger.
     */
    LoggingAdapter logger = Logging.getLogger(getContext().system(), this);

    private ActorRef childActor;

    /**
     * Instantiates a new Parent actor.
     */
    public ParentActor(){
        childActor = getContext().actorOf(Props.create(ChildActor.class), "child-actor-ref");

    }

    @Override
    public void onReceive(Object message) throws Throwable {

        if(message instanceof Action){
            logger.info("*****PARENT********Triggered Actor--> {}, at --> {}, with message {}"
                    , getSelf().path().name(), LocalDateTime.now(), ((Action) message).getCommand());
            final Data data = new Data(UUID.randomUUID(), ((Action) message).getCommand());
            childActor.tell(data, getSelf());
        }else if (message.equals("Echo")){
            logger.info("Echoooooeeeedd!!!");
        }

    }
}
