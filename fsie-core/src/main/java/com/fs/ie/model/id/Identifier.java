package com.fs.ie.model.id;

public abstract class Identifier {
    public String id;
    public IdentifierAssigningAuthority identifierAssigningAuthority;

    public abstract String getId();
    public abstract void setId(String id);

    public abstract IdentifierAssigningAuthority getIdentifierAssigningAuthority();
    public abstract void setIdentifierAssigningAuthority(IdentifierAssigningAuthority identifierAssigningAuthority);
}
