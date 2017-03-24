package study.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;

public class ReleaseSourceApplicationListener implements ApplicationListener {
    private static final Logger LOG = LoggerFactory.getLogger(ReleaseSourceApplicationListener.class);

    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextClosedEvent) {
            if(((ContextClosedEvent)event).getApplicationContext().getParent() == null) {
                LOG.info("################ context closed" + event.toString() + " " + event.getSource());
            }
        } else if(event instanceof ContextStoppedEvent) {
            LOG.info("################ context stopped");
        } else {
            LOG.info("################ other event");
        }
    }
}
