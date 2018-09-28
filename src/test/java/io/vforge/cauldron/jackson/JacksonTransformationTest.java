package io.vforge.cauldron.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class JacksonTransformationTest {

    private final String folderPath = System.getProperties().get("user.dir") +
            "/src/test/resources/";

    @Test
    public void testJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        byte[] bytes = Files.readAllBytes(Paths.get(folderPath + "test.json"));

        HashMap hashMap = objectMapper.readValue(bytes, 0, bytes.length, HashMap.class);

        ArrayList interfaces = (ArrayList) ((LinkedHashMap) hashMap.get("network-status")).get("interfaces");

        log.debug("mapper:", hashMap);
    }
}
