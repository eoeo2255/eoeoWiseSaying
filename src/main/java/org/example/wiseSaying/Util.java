package org.example.wiseSaying;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.wiseSaying.wiseSay.entity.WiseSaying;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {

    private final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private final String absPath = new File("").getAbsolutePath();
    private final String extType = ".json";
    private final String tableName = "WiseSayTable";
    private final String  dbPath;

    public Util() {
        File dbDir = new File(absPath + "/DataBase");

        if (!dbDir.exists()) {
            dbDir.mkdir();
        }
        dbPath = dbDir.getAbsolutePath();

        File tableFile = new File(dbPath + "/" + tableName + extType);

        if (!tableFile.exists()) {
            init();
        }

    }

    public void init() {
        try {
            objectMapper.writeValue(new File(dbPath + "/" + tableName + extType), new ArrayList<>());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveObjToJsonFile(Object object) {
        try {
            objectMapper.writeValue(new File(dbPath + "/" + tableName + extType),object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        public List<WiseSaying> readJson() {
        try {
            List<WiseSaying> book = objectMapper.readValue(new File(dbPath + "/" + tableName + extType), new TypeReference<List<WiseSaying>>(){});
            return book;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
