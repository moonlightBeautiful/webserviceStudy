/**
 * AVMPMInterfaceSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.java1234.webservice.clientNet02Erp;

public interface AVMPMInterfaceSoap_PortType extends java.rmi.Remote {
    public String helloWorld() throws java.rmi.RemoteException;
    public String getDepartments(String dwbh, String state, String startTime, String instanceid, String bizDate, String userCode, String password) throws java.rmi.RemoteException;
    public String getWorkCenters(String dwbh, String state, String startTime, String instanceid, String bizDate, String userCode, String password) throws java.rmi.RemoteException;
    public String getTeams(String wcID, String state, String startTime, String instanceid, String bizDate, String userCode, String password) throws java.rmi.RemoteException;
    public String getProject(String state, String startTime, String instanceid, String bizDate, String userCode, String password) throws java.rmi.RemoteException;
    public String getProjectPhase(String state, String startTime, String instanceid, String bizDate, String userCode, String password) throws java.rmi.RemoteException;
    public String getMeasureUnits(String instanceid, String bizDate, String userCode, String password) throws java.rmi.RemoteException;
    public String getMaterialSorts(String instanceid, String bizDate, String userCode, String password) throws java.rmi.RemoteException;
    public String getComMaterials(String dwbh, String state, String startTime, String kind, String instanceid, String bizDate, String userCode, String password) throws java.rmi.RemoteException;
    public String getMaterials(String state, String startTime, String kind, String instanceid, String bizDate, String userCode, String password) throws java.rmi.RemoteException;
    public String getQcjyxmfl(String instanceid, String bizDate, String userCode, String password) throws java.rmi.RemoteException;
    public String getQcjyxm(String instanceid, String bizDate, String userCode, String password) throws java.rmi.RemoteException;
    public String getGXFL(String instanceid, String bizDate, String userCode, String password) throws java.rmi.RemoteException;
    public String getBZGX(String state, String startTime, String instanceid, String bizDate, String userCode, String password) throws java.rmi.RemoteException;
    public String getBOM(String dwbh, String materialId, String stageId, String isCircle) throws java.rmi.RemoteException;
    public String getRouting(String dwbh, String materialId, String stageId, String batchNo) throws java.rmi.RemoteException;
}
