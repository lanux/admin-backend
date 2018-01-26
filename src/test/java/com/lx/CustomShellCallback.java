package com.lx;

import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;

public class CustomShellCallback extends DefaultShellCallback{

    private String rootPath;

    public CustomShellCallback(boolean overwrite,String rootPath) {
        super(overwrite);
        this.rootPath = rootPath;
    }

    @Override
    public File getDirectory(String targetProject, String targetPackage) throws ShellException {
        return super.getDirectory(rootPath + File.separator + targetProject, targetPackage);
    }
}
