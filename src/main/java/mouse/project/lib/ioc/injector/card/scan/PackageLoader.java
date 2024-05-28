package mouse.project.lib.ioc.injector.card.scan;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.lang.annotation.Annotation;
import java.util.Set;

public class PackageLoader {
    public Set<Class<?>> getAnnotatedClasses(String prefix, Class<? extends Annotation> annotation) {
        if (prefix == null || prefix.isEmpty()) {
            throw new IllegalArgumentException("Package name cannot be null or empty");
        }
        Reflections reflections = new Reflections(prefix, Scanners.TypesAnnotated);
        return reflections.getTypesAnnotatedWith(annotation);
    }

    public Set<Class<?>> getAllClasses(String packageName) {
        if (packageName == null || packageName.isEmpty()) {
            throw new IllegalArgumentException("Package name cannot be null or empty");
        }

        Reflections reflections = new Reflections(packageName, Scanners.SubTypes.filterResultsBy(s -> true));
        Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);
        return classes;
    }
}
