package com.lx;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.api.VerboseProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerate {
    public static void main(String[] args) {
        List<String> warnings = new ArrayList<String>();
        try {
            boolean overwrite = true;
            ConfigurationParser cp = new ConfigurationParser(warnings);
            ClassLoader classLoader = CodeGenerate.class.getClassLoader();
            Configuration config = cp.parseConfiguration(classLoader.getResourceAsStream("generatorConfig.xml"));
            String projectDir = System.getProperty("user.dir");
            DefaultShellCallback callback = new CustomShellCallback(overwrite,projectDir);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            ProgressCallback progressCallback = new VerboseProgressCallback();
            myBatisGenerator.generate(progressCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
