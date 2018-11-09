package com.fs.ie.model.patient;

import com.fs.ie.model.Patient;
import com.fs.ie.model.id.Identifier;
import com.fs.ie.model.id.IdentifierAssigningAuthority;

public class PatientID extends Identifier{
    @Override
    public IdentifierAssigningAuthority getIdentifierAssigningAuthority() {
        return identifierAssigningAuthority;
    }

    @Override
    public void setIdentifierAssigningAuthority(IdentifierAssigningAuthority identifierAssigningAuthority) {
        this.identifierAssigningAuthority = identifierAssigningAuthority;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
