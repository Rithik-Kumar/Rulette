package com.github.kislayverma.rulette.core.dao;

import com.github.kislayverma.rulette.core.ruleinput.value.InputDataType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 *
 * @author kislay
 */
public class Utils {

    /**
     * Read a properties file from the classpath and return a Properties object
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static Properties readProperties(String fileName) throws IOException {
        File f = new File(fileName);
        if (!f.canRead()) {
            throw new IOException("Could not read the datasource file");
        }

        URL url = f.toURI().toURL();
        InputStream in = url.openStream();
        Properties props = new Properties();
        props.load(in);

        return props;
    }
//    public static Properties readProperties(String filename) throws IOException {
//        Properties props = new Properties();
//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        InputStream stream = loader.getResourceAsStream(filename);
//        props.load(stream);
//        return props;
//    }

    public static final InputDataType getRuleInputDataTypeFromName(String name) {
        switch (name.toLowerCase()) {
            case("number"):
                return InputDataType.NUMBER;
            case("date"):
                return InputDataType.DATE;
            case("string"):
                return InputDataType.STRING;
            default:
                return null;
        }
    }
}
