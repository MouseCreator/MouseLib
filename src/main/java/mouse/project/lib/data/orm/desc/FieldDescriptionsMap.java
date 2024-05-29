package mouse.project.lib.data.orm.desc;

import java.util.*;

public class FieldDescriptionsMap implements FieldDescriptions {
    private FieldDescriptionsMap() {
        map = new HashMap<>();
    }
    private final Map<Key, FieldDescription> map;
    public static FieldDescriptionsMap of(List<FieldDescription> fieldDescriptions) {
        FieldDescriptionsMap fieldDescriptionsMap = new FieldDescriptionsMap();
        for (FieldDescription fieldDescription : fieldDescriptions) {
            String name = fieldDescription.columnName();
            fieldDescriptionsMap.map.put(new Key(name, fieldDescription.type()), fieldDescription);
        }
        return fieldDescriptionsMap;
    }

    @Override
    public List<FieldDescription> getDescriptions() {
        return new ArrayList<>(map.values());
    }
    private record Key(String name, FieldDescType type) {
    }
    @Override
    public Optional<FieldDescription> getFieldDescriptionByNameAndType(String name, FieldDescType type) {
        FieldDescription fieldDescription = map.get(new Key(name, type));
        return Optional.ofNullable(fieldDescription);
    }
}
