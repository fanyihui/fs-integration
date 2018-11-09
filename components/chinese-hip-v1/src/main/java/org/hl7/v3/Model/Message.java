package org.hl7.v3.Model;

import java.util.Date;
import com.fs.ie.model.id.InstanceIdentifier;

public class Message {
    private String messageType;
    private InstanceIdentifier id;
    private Date createTime;
    private InstanceIdentifier interactionId;
    private String processingCode;
    private String processingModeCode;
    private String acceptAckCode;

}
