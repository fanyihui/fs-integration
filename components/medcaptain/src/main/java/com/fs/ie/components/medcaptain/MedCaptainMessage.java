package com.fs.ie.components.medcaptain;

import java.io.Serializable;
import java.util.ArrayList;

public class MedCaptainMessage implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2351298091944210836L;

	private int commandCode;

	private Device device;

	private Patient patient;
	
    private Mar mar;

	public int getCommandCode() {
		return commandCode;
	}

	public void setCommandCode(int commandCode) {
		this.commandCode = commandCode;
	}

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Mar getMar() {
        return mar;
    }

    public void setMar(Mar mar) {
        this.mar = mar;
    }
}
