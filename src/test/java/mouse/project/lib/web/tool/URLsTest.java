package mouse.project.lib.web.tool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class URLsTest {

    @Test
    void testUrlStruct() {
        String exampleParam = "q=";
        String[] split = exampleParam.split("=");
        assertEquals(1, split.length);
    }
}
