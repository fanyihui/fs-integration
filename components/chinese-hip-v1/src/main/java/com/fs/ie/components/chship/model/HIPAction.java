package com.fs.ie.components.chship.model;

public enum HIPAction {
    PatientRegistryReviseRequest("PatientRegistryReviseRequest"),
    PatientRegistryAddRequest("PatientRegistryAddRequest"),
    PatientRegistryDuplicatesResolved("PatientRegistryDuplicatesResolved"),
    PatientRegistryFindCandidatesQuery("PatientRegistryFindCandidatesQuery"),
    AddProviderRequest("AddProviderRequest"),
    UpdateProviderRequest("UpdateProviderRequest"),
    ProviderDetailsQuery("ProviderDetailsQuery"),
    AddOrganizationRequest("AddOrganizationRequest");


    private String action;

    private HIPAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
