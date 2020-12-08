package com.example.application.utils;

import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: wuwenhua
 * @Date: 2020/12/6 11:52
 * @Description:
 */
@Configuration
public class YamlUtil {
    public static final YamlUtil instance = new YamlUtil();
    private static Map<String, Object> ymlMap = new HashMap<>();

    static {
        Yaml yaml = new Yaml();
        try (InputStream in = YamlUtil.class.getClassLoader().getResourceAsStream("application.yml");) {
            ymlMap = yaml.loadAs(in, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        String separator = ".";
        String[] separatorKeys = null;
        if (key.contains(separator)) {
            separatorKeys = key.split("\\.");
        } else {
            return ymlMap.get(key).toString();
        }

        Map<String, Object> finalValue = new HashMap<>();
        for (int i = 0; i < separatorKeys.length - 1; i++) {
            if (i == 0) {
                finalValue = (Map) ymlMap.get(separatorKeys[i]);
                continue;
            }
            if (finalValue == null) {
                break;
            }
            finalValue = (Map)finalValue.get(separatorKeys[i]);
        }

        return finalValue == null ? null : finalValue.get(separatorKeys[separatorKeys.length - 1]).toString();
    }
}
