package com.hfzs.biz.sys.service.impl;


import com.hfzs.biz.sys.service.IWorkflowProcessInstanceService;
import com.hfzs.framework.domain.ProcessInstanceAndHistoryDto;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description 流程公共方法类 
 * @author wwang 
 * @date 2016-8-5
 */
@Service("workflowProcessInstanceService")
@SuppressWarnings("unused")
public class WorkflowProcessInstanceServiceImpl implements IWorkflowProcessInstanceService {
	
	@Autowired
	private ProcessEngine processEngine;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	protected HistoryService historyService;
	
	@Autowired
	private IdentityService identityService;
	

	
	@Override
	public ProcessInstance startProcessInstance(String processDefinitionKey,
			String businessKey, Map<String, Object> variables) {
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey, variables);
		return processInstance;
	}
	
	@Override
	public List<ProcessInstanceAndHistoryDto> findProcessInstanceAndHistoryList(String processDefinitionKey,String userId,String roleID) {
//		//1、查询执行的流程 (个人)
//		TaskQuery runQuery = taskService.createTaskQuery().active()//
//				.processDefinitionKey(processDefinitionKey).taskCandidateOrAssigned(userId).taskAssignee(userId).taskCandidateGroup(roleID);
//		List<Task> runList=new ArrayList<Task>();
//		List<ProcessInstanceAndHistoryDto> runProcessList=new ArrayList<ProcessInstanceAndHistoryDto>();
//		runList = runQuery.list();
//
//		ProcessDefinitionCache.setRepositoryService(repositoryService);
//		//查询任务对应的流程实例
//		for (Task task : runList) {
//
//			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()//
//											.processInstanceId(task.getProcessInstanceId()).singleResult();
//			ProcessInstanceAndHistoryDto dto=new ProcessInstanceAndHistoryDto();
//			dto.setId(processInstance.getId());
//			runProcessList.add(dto);
//
////			if(processInstance!=null){
////				ProcessInstanceAndHistoryDto dto=new ProcessInstanceAndHistoryDto();
////				dto.setId(processInstance.getId());
////				dto.setBusinessKey(processInstance.getBusinessKey());//业务id
////		    	if (this.adjustHaveRight(task.getName(), roleID)){   //查看该角色是否有权限到该任务
////		    	   runProcessList.add(dto);
////		    	}
////			}
//		}
//
//		TaskQuery runGQuery = taskService.createTaskQuery().active()//
//				.processDefinitionKey(processDefinitionKey).taskCandidateGroup(roleID);
//		List<Task> runGList=new ArrayList<Task>();
//		runGList = runGQuery.list();
//
//		ProcessDefinitionCache.setRepositoryService(repositoryService);
//		//查询任务对应的流程实例
//		for (Task task : runGList) {
//
//			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()//
//											.processInstanceId(task.getProcessInstanceId()).singleResult();
//			if(processInstance!=null){
//				ProcessInstanceAndHistoryDto dto=new ProcessInstanceAndHistoryDto();
//				dto.setId(processInstance.getId());
//				dto.setBusinessKey(processInstance.getBusinessKey());//业务id
//		    	if (this.adjustHaveRight(task.getName(), roleID)){   //查看该角色是否有权限到该任务
//				runProcessList.add(dto);
//		    	}
//			}
//		}
//
//		//2、查询历史任务的流程实例 (个人)
//		List<ProcessInstanceAndHistoryDto> hisProcessList=new ArrayList<ProcessInstanceAndHistoryDto>();
//		//查询历史任务(查询指定人的任务)
//		HistoricTaskInstanceQuery hisQuery = historyService // 历史任务Service
//			        .createHistoricTaskInstanceQuery() // 创建历史任务实例查询
//			        .taskAssignee(userId) // 指定办理人
//			        .processDefinitionKey(processDefinitionKey)//指定流程key
//			        .finished().orderByHistoricTaskInstanceEndTime().desc(); // 查询已经完成的任务
//
//		List<HistoricTaskInstance> hisList=new ArrayList<HistoricTaskInstance>();
//		hisList = hisQuery.list();
//		//2.1查询历史任务对应的流程实例
//		for (HistoricTaskInstance task : hisList) {
//			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()//
//												.processInstanceId(task.getProcessInstanceId()).singleResult();
//			if(processInstance!=null){
//				ProcessInstanceAndHistoryDto dto=new ProcessInstanceAndHistoryDto();
//				dto.setId(processInstance.getId());
//				dto.setBusinessKey(processInstance.getBusinessKey());//业务id
//				if (this.adjustHaveRight(task.getName(), roleID)){   //查看该角色是否有权限到该任务
//					hisProcessList.add(dto);
//				}
//			}
//
//		}
//
//		//2.2(查询角色group的任务)
//		hisQuery = historyService // 历史任务Service
//					        .createHistoricTaskInstanceQuery() // 创建历史任务实例查询
//					        .taskCandidateGroup(roleID)
//					        .processDefinitionKey(processDefinitionKey)//指定流程key
//					        .finished().orderByHistoricTaskInstanceEndTime().desc(); //
//		hisList = hisQuery.list();
//		//查询历史任务对应的流程实例
//		for (HistoricTaskInstance task : hisList) {
//			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()//
//												.processInstanceId(task.getProcessInstanceId()).singleResult();
//			if(processInstance!=null){
//				ProcessInstanceAndHistoryDto dto=new ProcessInstanceAndHistoryDto();
//				dto.setId(processInstance.getId());
//				dto.setBusinessKey(processInstance.getBusinessKey());//业务id
//				if (this.adjustHaveRight(task.getName(), roleID)){   //查看该角色是否有权限到该任务
//					hisProcessList.add(dto);
//				}
//			}
//
//		}
//
//		//3.根据历史任务查询历史流程信息
//		List<ProcessInstanceAndHistoryDto> hisTaskProcessList=new ArrayList<ProcessInstanceAndHistoryDto>();
//		//查询历史任务(查询指定人的任务)
//		HistoricTaskInstanceQuery hisTaskQuery = historyService // 历史任务Service
//			        .createHistoricTaskInstanceQuery() // 创建历史任务实例查询
//			        .taskAssignee(userId) // 指定办理人
//			        .processDefinitionKey(processDefinitionKey)//指定流程key
//			        .orderByHistoricTaskInstanceEndTime().desc(); // 查询已经完成的任务
//
//		List<HistoricTaskInstance> hisTaskList=new ArrayList<HistoricTaskInstance>();
//		hisTaskList = hisTaskQuery.list();
//		//3.1查询历史任务对应的历史流程实例
//		for (HistoricTaskInstance task : hisTaskList) {
//			HistoricProcessInstance historicProcessInstance = historyService.//
//								createHistoricProcessInstanceQuery().finished()//
//								.processInstanceId(task.getProcessInstanceId())//
//								.singleResult();
//			if(historicProcessInstance!=null){
//				ProcessInstanceAndHistoryDto dto=new ProcessInstanceAndHistoryDto();
//				dto.setId(historicProcessInstance.getId());
//				dto.setBusinessKey(historicProcessInstance.getBusinessKey());//业务id
//				if (this.adjustHaveRight(task.getName(), roleID)){   //查看该角色是否有权限到该任务
//					hisTaskProcessList.add(dto);
//				}
//			}
//
//		}
//
//		//3.2(查询角色group的任务)
//		hisTaskQuery = historyService // 历史任务Service
//					        .createHistoricTaskInstanceQuery() // 创建历史任务实例查询
//					        .taskCandidateGroup(roleID)//组--角色
//					        .processDefinitionKey(processDefinitionKey)//指定流程key
//					        .finished().orderByHistoricTaskInstanceEndTime().desc(); //
//		hisTaskList = hisTaskQuery.list();
//		//查询历史任务对应的历史流程实例
//		for (HistoricTaskInstance task : hisTaskList) {
//			HistoricProcessInstance historicProcessInstance = historyService.//
//						createHistoricProcessInstanceQuery().finished()//
//						.processInstanceId(task.getProcessInstanceId())//
//						.singleResult();
//			if(historicProcessInstance!=null){
//				ProcessInstanceAndHistoryDto dto=new ProcessInstanceAndHistoryDto();
//				dto.setId(historicProcessInstance.getId());
//				dto.setBusinessKey(historicProcessInstance.getBusinessKey());//业务id
//				if (this.adjustHaveRight(task.getName(), roleID)){   //查看该角色是否有权限到该任务
//					hisTaskProcessList.add(dto);
//				}
//			}
//		}
//
//
//		//返回的结果集合
//		List<ProcessInstanceAndHistoryDto> processList=new ArrayList<ProcessInstanceAndHistoryDto>();
//		processList.addAll(runProcessList);//运行中的流程实例
//		processList.addAll(hisProcessList);//历史任务的运行中的流程实例
//		processList.addAll(hisTaskProcessList);//历史任务的历史流程实例
//		return processList;
		return  null;
	}

	@Override
	public void deleteProcesssInsatance(String processInstanceId,String deleteReason) {
		runtimeService.deleteProcessInstance(processInstanceId, deleteReason);
	}

	@Override
	public void claim(String taskId, String userId) {
		//分配的个人任务（可以是组任务中的成员，也可以是非组任务的成员）
		taskService.claim(taskId, userId);
	}

	@Override
	public void complete(String taskId, Map<String, Object> variables) {
		taskService.complete(taskId, variables);
	}

	@Override
	public void backTask(String taskId) {
		taskService.setAssignee(taskId, null);
	}

	@Override
	public List<Comment> findCommentByTaskId(String processInstanceId,String... type) {
		String activitiType="comment";
		if(type!=null&&type.length>0){
			activitiType=type[0];
		}
		//使用当前任务ID，获取当前历史任务对象
		List<Comment> historyCommnets = new ArrayList<Comment>();
	     //2）通过流程实例查询所有的(用户任务类型)历史活动   
	     List<HistoricActivityInstance> hais = historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId).activityType("userTask").list();
	     //3）查询每个历史任务的批注
	     for (HistoricActivityInstance hai : hais) {
	         String historytaskId = hai.getTaskId();
	         List<Comment> comments = taskService.getTaskComments(historytaskId,activitiType);//审核意见
	         // 4）如果当前任务有批注信息，添加到集合中
	         if(comments!=null && comments.size()>0){
	             historyCommnets.addAll(comments);
	         }
	     }
	     //5）返回
	     return historyCommnets;
	}

	@Override
	public Task findTask(String processInstanceId) {
		Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
		return task;
	}

	@Override
	public void addComment(String userId,String taskId,String processInstanceId, String comment) {
		Authentication.setAuthenticatedUserId(userId);//批注人的名称  一定要写，不然查看的时候不知道人物信息
        // 添加批注信息
        taskService.addComment(taskId, processInstanceId, comment);//comment为批注内容
	}

	@Override
	public boolean adjustHaveRight(String taskName, String roleId) {
//		// 查看该task属于哪个角色
//		List<DicTask> list = dicTaskDao.getDicTaskByTaskNameAndRoleId(taskName, ActivitiMap.getProperty(roleId));
//		if(list!=null&&list.size()>0){
//			return true;
//		}
		return false;
	}
	
	@Override
	public void addComment(String userId,String taskId,String processInstanceId,String type, String comment) {
		Authentication.setAuthenticatedUserId(userId);//批注人的名称  一定要写，不然查看的时候不知道人物信息
        // 添加批注信息
        taskService.addComment(taskId, processInstanceId, type, comment);
	}

	@Override
	public void updateJobTime(String processInstanceId, Date jobTime) throws Exception {
		List<Execution> list = runtimeService.createExecutionQuery().processInstanceId(processInstanceId).list();
		String exId="";
		for (Execution e : list) {
			System.out.print("exid: "+e.getId());
			ExecutionEntity ee=(ExecutionEntity) e;
			if(ee.isActive()){
				exId=e.getId(); 
			} 	
		}
		
//		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		String date = sdf.format(jobTime);
//
//		Connection conn = DBUtils.createConn();
//		PreparedStatement pst = null;
//			String t_sql = "UPDATE act_ru_job SET DUEDATE_ =? WHERE EXECUTION_ID_=?";
//			pst = conn.prepareStatement(t_sql);
//			pst.setString(1, date);
//			pst.setString(2, exId);
//			pst.executeUpdate();
//
//		if (pst != null) {
//			try {
//				pst.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		if (conn != null) {
//			try {
//				conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}

	@Override
	public void suspendProcess(String processInstanceId) {
		runtimeService.suspendProcessInstanceById(processInstanceId);
		
	}

	@Override
	public void activateProcess(String processInstanceId,Map<String,Object> variables) {
		runtimeService.activateProcessInstanceById(processInstanceId);
		String executionId = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getId();
		runtimeService.setVariables(executionId, variables);
	}

	@Override
	public HistoricTaskInstance findHistoricTaskByTaskName(String processInstanceId, String taskName) {
		HistoricTaskInstance hisTaskQuery = historyService // 历史任务Service  
		        .createHistoricTaskInstanceQuery() // 创建历史任务实例查询  
		        .processInstanceId(processInstanceId)//
		        .taskName(taskName).singleResult();//任务名称
		return hisTaskQuery;
	}

}
