package cn.ituring.design_patterns.p2_adapter.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileProperties extends Properties implements FileIO{

    @Override
    public void readFromFile(String filename) throws IOException {
        load(new FileInputStream(filename));
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        String header = "Written by FileProperties";
        store(new FileOutputStream(filename), header);
    }

    @Override
    public void setValue(String key, String value) {
        setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return getProperty(key);
    }
}
