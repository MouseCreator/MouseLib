package mouse.project.lib.ioc.injector.card.factory.invoke;

import mouse.project.lib.exception.CardException;
import mouse.project.lib.exception.ScanException;
import mouse.project.lib.ioc.Ioc;
import mouse.project.lib.ioc.annotation.After;
import mouse.project.lib.ioc.annotation.Configuration;
import mouse.project.lib.ioc.annotation.Prototype;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActionInvokerTest {
    @Configuration(includeClasses = { PrototypeA.class, PrototypeB.class })
    private static class ConfigTwoPrototypes {
    }
    @Prototype
    private static class PrototypeA {
        @After
        private void after(PrototypeB b) {

        }
    }
    @Prototype
    private static class PrototypeB {
        @After
        private void after(PrototypeA a) {

        }
    }
    @Test
    public void testTwoPrototypes() {
        Assertions.assertThrows(CardException.class, () -> Ioc.getConfiguredInjector(ConfigTwoPrototypes.class).get(PrototypeA.class));
    }

    @Configuration(includeClasses = { SingletonA.class, SingletonB.class })
    private static class ConfigTwoSingletons {
    }
    private static class SingletonA {
        @After
        private void after(SingletonB b) {

        }
    }
    private static class SingletonB {
        @After
        private void after(SingletonA a) {

        }
    }
    @Test
    public void testTwoSingletons() {
        Assertions.assertDoesNotThrow(() -> Ioc.getConfiguredInjector(ConfigTwoSingletons.class).get(SingletonA.class));
    }
}
