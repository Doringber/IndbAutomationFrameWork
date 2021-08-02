package Infrastructure.Uitiles;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

public class getConfig {
    InputStream inputStream = new FileInputStream(new File("config.yml"));

    Yaml yaml = new Yaml();
    Map<String,Object> data = yaml.load(inputStream);

    public getConfig() throws FileNotFoundException {
    }
}
