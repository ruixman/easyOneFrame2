package com.hfzs.framework.domain;

import org.activiti.engine.repository.ProcessDefinition;

import java.util.Date;

public class ProcessInstanceAndHistoryDto {
    private String id;
    private String processInstanceId;//流程实例id
    private String processDefinitionId;//流程定义id
    private boolean suspended;//是否挂起
    private String nodeName;//节点名称
    private String deploymentId;
    private ProcessDefinition processDefinition;
    private String businessKey;//流程表单的id
    private Date startTime;//流程创建时间
    private Date endTime;//流程结束时间
    private String taskId;//任务id

    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getProcessInstanceId() {
        return processInstanceId;
    }
    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }
    public String getProcessDefinitionId() {
        return processDefinitionId;
    }
    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }
    public String getNodeName() {
        return nodeName;
    }
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }
    public boolean isSuspended() {
        return suspended;
    }
    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }
    public String getDeploymentId() {
        return deploymentId;
    }
    public void setProcessDefinition(ProcessDefinition processDefinition) {
        this.processDefinition = processDefinition;
    }
    public ProcessDefinition getProcessDefinition() {
        return processDefinition;
    }
    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }
    public String getBusinessKey() {
        return businessKey;
    }
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    public String getTaskId() {
        return taskId;
    }
}
