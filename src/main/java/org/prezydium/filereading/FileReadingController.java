package org.prezydium.filereading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@RestController
public class FileReadingController {

    @Value("classpath:/files/hello.txt")
    private Resource helloFile;

    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping(value = "/filereading/resource", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendFileAsString() throws IOException {
        return StreamUtils.copyToString(helloFile.getInputStream(), UTF_8);
    }

    @RequestMapping(value = "/filereading/lazy")
    public String sendFileAsStringLazyLoad() throws IOException {
        return StreamUtils.copyToString(resourceLoader
                .getResource("classpath:/files/hello.txt")
                .getInputStream(), UTF_8);
    }
}
