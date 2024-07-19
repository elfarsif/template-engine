package org.frank;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Template {
    private String templateText;
    Map<String,String> variables;

    public Template(String templateText) {
        this.templateText = templateText;
        this.variables = new HashMap<>();
    }

    public void set(String variable, String value) {
        this.variables.put(variable,value);
    }

    public String evaluate() {
        String evaluatedTemplate = replaceVariables();
        checkForMissingValues(evaluatedTemplate);
        return evaluatedTemplate;
    }

    private String replaceVariables(){
        String result = templateText;
        for (Entry<String, String> entry : variables.entrySet()) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            result = result.replaceAll(regex, entry.getValue());
        }
        return result;
    }

    private void checkForMissingValues(String result){
        if (result.matches(".*\\$\\{.+\\}.*")) {
            throw new MissingValueException();
        }
    }


}
