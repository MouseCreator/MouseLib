package mouse.project.lib.ioc.injector.card.producer;

import mouse.project.lib.ioc.injector.card.access.CardAccess;
import mouse.project.lib.ioc.injector.card.invoke.Parameters;

public interface ActionProducer {
    void call(Object callOn, CardAccess container);
    Parameters getParameters();
}
