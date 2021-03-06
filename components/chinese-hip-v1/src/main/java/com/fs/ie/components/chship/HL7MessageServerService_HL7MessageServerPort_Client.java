
package com.fs.ie.components.chship;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-09-21T16:21:05.774+08:00
 * Generated source version: 3.2.6
 *
 */
public final class HL7MessageServerService_HL7MessageServerPort_Client {

    private static final QName SERVICE_NAME = new QName("urn:hl7-org:v3", "HL7MessageServerService");
    private static String MESSAGE = "<PRPA_IN201311UV02 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\" xsi:schemaLocation=\"urn:hl7-org:v3 ../multicacheschemas/PRPA_IN201311UV02.xsd\" xmlns=\"urn:hl7-org:v3\">\n" +
            "\t<id root=\"2.16.156.10011.0\" extension=\"22a0f9e0-4454-11dc-a6be-3603d6866807\"/>\n" +
            "\t<creationTime value=\"20070803130624\"/>\n" +
            "\t<interactionId root=\"2.16.840.1.113883.1.6\" extension=\"PRPA_IN201311UV02\"/>\n" +
            "\t<processingCode code=\"P\"/>\n" +
            "\t<processingModeCode code=\"R\"/>\n" +
            "\t<acceptAckCode code=\"AL\"/>\n" +
            "\t<receiver typeCode=\"RCV\">\n" +
            "\t\t<device classCode=\"DEV\" determinerCode=\"INSTANCE\">\n" +
            "\t\t\t<id root=\"2.16.156.10011.0.1.1\" extension=\"2.16.156.10011.0.1.1\"/>\n" +
            "\t\t</device>\n" +
            "\t</receiver>\n" +
            "\t<sender typeCode=\"SND\">\n" +
            "\t\t<device classCode=\"DEV\" determinerCode=\"INSTANCE\">\n" +
            "\t\t\t<id root=\"2.16.156.10011.0.1.2\" extension=\"2.16.156.10011.0.1.2\"/>\n" +
            "\t\t</device>\n" +
            "\t</sender>\n" +
            "\t<controlActProcess classCode=\"CACT\" moodCode=\"EVN\">\n" +
            "\t\t<subject typeCode=\"SUBJ\">\n" +
            "\t\t\t<registrationRequest classCode=\"REG\" moodCode=\"RQO\">\n" +
            "\t\t\t\t<statusCode code=\"active\"/>\n" +
            "\t\t\t\t<subject1 typeCode=\"SBJ\">\n" +
            "\t\t\t\t\t<patient classCode=\"PAT\">\n" +
            "\t\t\t\t\t\t<!--本地系统的患者ID -->\n" +
            "\t\t\t\t\t\t<id root=\"2.16.156.10011.0.2.2\" extension=\"患者ID\"/>\n" +
            "\t\t\t\t\t\t<statusCode code=\"active\"/>\n" +
            "\t\t\t\t\t\t<effectiveTime value=\"20111212141414\"/>\n" +
            "\t\t\t\t\t\t<patientPerson>\n" +
            "\t\t\t\t\t\t\t<!--身份证号-->\n" +
            "\t\t\t\t\t\t\t<id root=\"2.16.156.10011.1.3\" extension=\"120109197706015516\"/>\n" +
            "\t\t\t\t\t\t\t<!--姓名-->\n" +
            "\t\t\t\t\t\t\t<name use=\"L\">刘永好</name>\n" +
            "\t\t\t\t\t\t\t<!--联系电话-->\n" +
            "\t\t\t\t\t\t\t<telecom value=\"028-2222444\" use=\"H\"/>\n" +
            "\t\t\t\t\t\t\t<!--性别-->\n" +
            "\t\t\t\t\t\t\t<administrativeGenderCode code=\"1\" codeSystem=\"2.16.156.10011.2.3.3.4\" displayName=\"男性\"/>\n" +
            "\t\t\t\t\t\t\t<!--出生时间-->\n" +
            "\t\t\t\t\t\t\t<birthTime value=\"19570323\"/>\n" +
            "\t\t\t\t\t\t\t<!--联系地址-->\n" +
            "\t\t\t\t\t\t\t<addr use=\"PUB\">\n" +
            "\t\t\t\t\t\t\t\t<!--非结构化地址（完整地址描述） -->\n" +
            "\t\t\t\t\t\t\t\t<streetAddressLine partType=\"SAL\">四川省成都市双流县红沙村3号</streetAddressLine>\n" +
            "\t\t\t\t\t\t\t\t<!--地址-省（自治区、直辖市）   -->\n" +
            "\t\t\t\t\t\t\t\t<state language=\"CH\">广东省</state>\n" +
            "\t\t\t\t\t\t\t\t<!--地址-市（地区）   -->\n" +
            "\t\t\t\t\t\t\t\t<city>广州市</city>\n" +
            "\t\t\t\t\t\t\t\t<!--地址-县（区）   -->\n" +
            "\t\t\t\t\t\t\t\t<county>越秀区</county>\n" +
            "\t\t\t\t\t\t\t\t<!-- 地址-乡（镇、街道办事处）   -->\n" +
            "\t\t\t\t\t\t\t\t<streetNameBase>童心街</streetNameBase>\n" +
            "\t\t\t\t\t\t\t\t<!-- 地址-村（街、路、弄等）   -->\n" +
            "\t\t\t\t\t\t\t\t<streetName>下塘西路</streetName>\n" +
            "\t\t\t\t\t\t\t\t<!-- 地址-门牌号码 -->\n" +
            "\t\t\t\t\t\t\t\t<houseNumber>39号</houseNumber>\n" +
            "\t\t\t\t\t\t\t\t<!-- 邮政编码-->\n" +
            "\t\t\t\t\t\t\t\t<postalCode>510000</postalCode>\n" +
            "\t\t\t\t\t\t\t</addr>\n" +
            "\t\t\t\t\t\t\t<!--婚姻状况-->\n" +
            "\t\t\t\t\t\t\t<maritalStatusCode code=\"10\" codeSystem=\"2.16.156.10011.2.3.3.5\" displayName=\"未婚\"/>\n" +
            "\t\t\t\t\t\t\t<!--民族-->\n" +
            "\t\t\t\t\t\t\t<ethnicGroupCode code=\"01\" codeSystem=\"2.16.156.10011.2.3.3.3\" displayName=\"汉族\"/>\n" +
            "\t\t\t\t\t\t\t<!--职业类别代码-->\n" +
            "\t\t\t\t\t\t\t<asEmployee classCode=\"EMP\">\n" +
            "\t\t\t\t\t\t\t\t<occupationCode code=\"13\" codeSystem=\"2.16.156.10011.2.3.3.7\" displayName=\"专业技术人员\"/>\n" +
            "\t\t\t\t\t\t\t\t<employerOrganization classCode=\"ORG\" determinerCode=\"INSTANCE\">\n" +
            "\t\t\t\t\t\t\t\t\t<!--工作单位名称-->\n" +
            "\t\t\t\t\t\t\t\t\t<name>XXX学校</name>\n" +
            "\t\t\t\t\t\t\t\t\t<contactParty classCode=\"CON\">\n" +
            "\t\t\t\t\t\t\t\t\t\t<!--工作联系电话-->\n" +
            "\t\t\t\t\t\t\t\t\t\t<telecom value=\"028-9999999\" use=\"WP\"/>\n" +
            "\t\t\t\t\t\t\t\t\t</contactParty>\n" +
            "\t\t\t\t\t\t\t\t</employerOrganization>\n" +
            "\t\t\t\t\t\t\t</asEmployee>\n" +
            "\t\t\t\t\t\t\t<asOtherIDs classCode=\"PAT\">\n" +
            "\t\t\t\t\t\t\t\t<!--健康卡号-->\n" +
            "\t\t\t\t\t\t\t\t<id root=\"2.16.156.10011.1.19\" extension=\"38273N237\"/>\n" +
            "\t\t\t\t\t\t\t\t<scopingOrganization classCode=\"ORG\" determinerCode=\"INSTANCE\">\n" +
            "\t\t\t\t\t\t\t\t\t<!--健康卡发放机构代码-->\n" +
            "\t\t\t\t\t\t\t\t\t<id root=\"2.16.156.10011.1.5\" extension=\"XXXXX\"/>\n" +
            "\t\t\t\t\t\t\t\t</scopingOrganization>\n" +
            "\t\t\t\t\t\t\t</asOtherIDs>\n" +
            "\t\t\t\t\t\t\t<asOtherIDs classCode=\"PAT\">\n" +
            "\t\t\t\t\t\t\t\t<!--城乡居民健康档案编号-->\n" +
            "\t\t\t\t\t\t\t\t<id root=\"2.16.156.10011.1.2\" extension=\"38273N237\"/>\n" +
            "\t\t\t\t\t\t\t\t<scopingOrganization classCode=\"ORG\" determinerCode=\"INSTANCE\">\n" +
            "\t\t\t\t\t\t\t\t\t<!--建档医疗机构组织机构代码-->\n" +
            "\t\t\t\t\t\t\t\t\t<id root=\"2.16.156.10011.1.5\" extension=\"XXXXX\"/>\n" +
            "\t\t\t\t\t\t\t\t</scopingOrganization>\n" +
            "\t\t\t\t\t\t\t</asOtherIDs>\n" +
            "\t\t\t\t\t\t\t<!--联系人-->\n" +
            "\t\t\t\t\t\t\t<personalRelationship>\n" +
            "\t\t\t\t\t\t\t\t<code/>\n" +
            "\t\t\t\t\t\t\t\t<!--联系人电话-->\n" +
            "\t\t\t\t\t\t\t\t<telecom use=\"H\" value=\"028-8888888\"/>\n" +
            "\t\t\t\t\t\t\t\t<relationshipHolder1 classCode=\"PSN\" determinerCode=\"INSTANCE\">\n" +
            "\t\t\t\t\t\t\t\t\t<!--联系人姓名-->\n" +
            "\t\t\t\t\t\t\t\t\t<name>刘好</name>\n" +
            "\t\t\t\t\t\t\t\t</relationshipHolder1>\n" +
            "\t\t\t\t\t\t\t</personalRelationship>\n" +
            "\t\t\t\t\t\t</patientPerson>\n" +
            "\t\t\t\t\t\t<providerOrganization classCode=\"ORG\" determinerCode=\"INSTANCE\">\n" +
            "\t\t\t\t\t\t\t<id root=\"2.16.156.10011.1.5\" extension=\"XXXXX\"/>\n" +
            "\t\t\t\t\t\t\t<name use=\"L\">无锡中医院</name>\n" +
            "\t\t\t\t\t\t\t<contactParty classCode=\"CON\"/>\n" +
            "\t\t\t\t\t\t</providerOrganization>\n" +
            "\t\t\t\t\t\t<!--医疗保险信息-->\n" +
            "\t\t\t\t\t\t<coveredPartyOf typeCode=\"COV\">\n" +
            "\t\t\t\t\t\t\t<coverageRecord classCode=\"COV\" moodCode=\"EVN\">\n" +
            "\t\t\t\t\t\t\t\t<beneficiary typeCode=\"BEN\">\n" +
            "\t\t\t\t\t\t\t\t\t<beneficiary classCode=\"MBR\">\n" +
            "\t\t\t\t\t\t\t\t\t\t<code code=\"1\" codeSystem=\"2.16.156.10011.2.3.1.248\" codeSystemName=\"医疗保险类别代码\" displayName=\"城镇职工基本医疗保险\"/>\n" +
            "\t\t\t\t\t\t\t\t\t</beneficiary>\n" +
            "\t\t\t\t\t\t\t\t</beneficiary>\n" +
            "\t\t\t\t\t\t\t</coverageRecord>\n" +
            "\t\t\t\t\t\t</coveredPartyOf>\n" +
            "\t\t\t\t\t</patient>\n" +
            "\t\t\t\t</subject1>\n" +
            "\t\t\t\t<author typeCode=\"AUT\">\n" +
            "\t\t\t\t\t<assignedEntity classCode=\"ASSIGNED\">\n" +
            "\t\t\t\t\t\t<id root=\"2.16.156.10011.0.3.2\" extension=\"登记人ID\"/>\n" +
            "\t\t\t\t\t\t<assignedPerson classCode=\"PSN\" determinerCode=\"INSTANCE\">\n" +
            "\t\t\t\t\t\t\t<name use=\"L\">赵武</name>\n" +
            "\t\t\t\t\t\t</assignedPerson>\n" +
            "\t\t\t\t\t</assignedEntity>\n" +
            "\t\t\t\t</author>\n" +
            "\t\t\t</registrationRequest>\n" +
            "\t\t</subject>\n" +
            "\t</controlActProcess>\n" +
            "</PRPA_IN201311UV02>\n";

    private HL7MessageServerService_HL7MessageServerPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = HL7MessageServerService_Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        HL7MessageServerService_Service ss = new HL7MessageServerService_Service(wsdlURL, SERVICE_NAME);
        HL7MessageServerService port = ss.getHL7MessageServerPort();

        {
        System.out.println("Invoking hipMessageServer...");
        java.lang.String _hipMessageServer_action = "PatientRegistryAddRequest";
        java.lang.String _hipMessageServer_message = MESSAGE;
        java.lang.String _hipMessageServer__return = port.hipMessageServer(_hipMessageServer_action, _hipMessageServer_message);
        System.out.println("hipMessageServer.result=" + _hipMessageServer__return);


        }

        System.exit(0);
    }

}
