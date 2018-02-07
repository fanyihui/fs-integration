package com.fs.ie.model;

public class CodeDefinition {
    private String code;
    private CodeSystem codeSystem;
    private String codeDescription;

    public CodeDefinition(String code, CodeSystem codeSystem, String codeDescription){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CodeSystem getCodeSystem() {
        return codeSystem;
    }

    public void setCodeSystem(CodeSystem codeSystem) {
        this.codeSystem = codeSystem;
    }

    public String getCodeDescription() {
        return codeDescription;
    }

    public void setCodeDescription(String codeDescription) {
        this.codeDescription = codeDescription;
    }
}
