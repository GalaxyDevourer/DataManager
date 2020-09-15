package chmnu.project.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;

import java.io.*;
import java.util.Objects;

public class ConfigManager {
    private YAMLFactory yaml = new YAMLFactory();
    private YAMLMapper.Builder mapper = YAMLMapper.builder()
            .disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
            .disable(YAMLGenerator.Feature.INDENT_ARRAYS);

    private final String CONFIG_NAME = "/settings.yml";

    public List<RaidArena> getClassFromCfg(String filename) throws IOException {
        String path = PLUGIN_FOLDER_PATH + "\\" + filename;
        File cfg = new File(path);

        YAMLParser yamlParser = yaml.createParser(cfg);
        return mapper.readValues(yamlParser, new TypeReference<RaidArena>(){}).readAll();
    }
}
