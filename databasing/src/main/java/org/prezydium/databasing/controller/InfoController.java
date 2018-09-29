package org.prezydium.databasing.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class InfoController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getInfo() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ApplicationContext.CLASSPATH_URL_PREFIX);
        stringBuilder.append("\n");
        File file = new File("sql/get-all.sql");
        stringBuilder.append(file.getCanonicalPath());
        return stringBuilder.toString();
    }
}
