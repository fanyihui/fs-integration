package com.fs.ie.model;

public class CodeSystem {
    private String codeSystemOID;
    private String codeSystemName;
    private String codeSystemDesc;

    public CodeSystem(String codeSystemOID, String codeSystemName, String codeSystemDesc){
        this.codeSystemOID = codeSystemOID;
        this.codeSystemName = codeSystemName;
        this.codeSystemDesc = codeSystemDesc;
    }

    public String getCodeSystemOID() {
        return codeSystemOID;
    }

    public void setCodeSystemOID(String codeSystemOID) {
        this.codeSystemOID = codeSystemOID;
    }

    public String getCodeSystemName() {
        return codeSystemName;
    }

    public void setCodeSystemName(String codeSystemName) {
        this.codeSystemName = codeSystemName;
    }

    public String getCodeSystemDesc() {
        return codeSystemDesc;
    }

    public void setCodeSystemDesc(String codeSystemDesc) {
        this.codeSystemDesc = codeSystemDesc;
    }
}
