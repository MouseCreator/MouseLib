package mouse.project.lib.ioc.injector.card.scan;

import mouse.project.lib.ioc.annotation.Card;
import mouse.project.lib.ioc.annotation.Service;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Card
class PackageLoaderTest {
    @Card
    private static class Inner {

    }

    @Test
    void testOnSelf() {
        PackageLoader packageLoader = new PackageLoader();
        Set<Class<?>> classes = packageLoader.getAnnotatedClasses(
                "mouse.project.lib.ioc.injector.card.scan",
                Card.class);
        assertTrue(classes.contains(PackageLoaderTest.class));
        assertTrue(classes.contains(Inner.class));
    }

    @Test
    void testEmptyPackage() {
        PackageLoader packageLoader = new PackageLoader();
        assertThrows(IllegalArgumentException.class, () -> packageLoader.getAnnotatedClasses("", Card.class));
    }
}