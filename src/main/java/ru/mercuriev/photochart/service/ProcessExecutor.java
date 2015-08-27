package ru.mercuriev.photochart.service;

import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Controller
class ProcessExecutor {

    public String execute(String command) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec(new String[] { "bash", "-c", command});
        p.waitFor();

        InputStream in = p.getInputStream();
        return new BufferedReader(new InputStreamReader(in)).readLine().trim();

    }
}
