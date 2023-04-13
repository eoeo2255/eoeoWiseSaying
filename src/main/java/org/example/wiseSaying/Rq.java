package org.example.wiseSaying;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String action;
    private Map<String, String> parameter;

    public Rq(String command) {
        String[] cmdBits = command.split("\\?", 2);
        this.action = cmdBits[0];
        this.parameter = new HashMap<>();

        if (cmdBits.length == 1) {
            return;
        }
        String[] params = cmdBits[1].split("&");

        for (String param : params) {
            String[] paramBits = param.split("=", 2);
            if (paramBits.length == 1) {
                continue;
            }

            String key = paramBits[0];
            String value = paramBits[1];
            parameter.put(key, value);
        }
    }

    public String getAction() {
        return action;
    }

    public Map<String, String> getParameters() {
        return parameter;
    }

    public String getParameter(String key) {
        return parameter.get(key);
    }

    public int getParameterInt(String key, int defaultValue) {
        try {
            return Integer.parseInt(getParameter(key));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

}
