package com.hfzs.biz.sys.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hfzs.framework.domain.ProcessInstanceAndHistoryDto;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
/**
 * @description 流程相关的公告方法 
 * @author wwang 
 * @date 2016-8-4
 */
public interface IWorkflowProcessInstanceService {
	
	/**
	 * @description 启动流程 
	 * @author wei 
	 * @date 2016-8-5
	 * @param processDefinitionKey 流程key
	 * @param businessKey 实体表单id
	 * @param variables 参数变量
	 * @return
	 */
	public ProcessInstance startProcessInstance(String processDefinitionKey, String businessKey, Map<String, Object> variables);
	
	/**
	 * @description 根据用户id 查询  
	 * @author wei 
	 * @date 2016-8-4
	 * @param processDefinitionKey 流程key
	 * @param userId 用户id
	 * @return
	 */
	public List<ProcessInstanceAndHistoryDto> findProcessInstanceAndHistoryList(String processDefinitionKey, String userId, String roleID);
	
	/**
	 * @description 删除流程实例 
	 * @author wei 
	 * @date 2016-8-5
	 * @param processInstanceId
	 */
	public void deleteProcesssInsatance(String processInstanceId, String deleteReason);
	
	/**
	 * @description 任务拾取 
	 * @author wei 
	 * @date 2016-8-5
	 * @param taskId
	 * @param userId
	 */
	public void claim(String taskId, String userId);
	
	/**
	 * @description  完成任务
	 * @author wei 
	 * @date 2016-8-5
	 * @param taskId
	 * @param variables 参数变量
	 */
	public void complete(String taskId, Map<String, Object> variables);
	
	/**
	 * @description 回退任务 
	 * @author wei 
	 * @date 2016-8-5
	 * @param taskId
	 */
	public void backTask(String taskId);
	
	/**
	 * @description  获取任务的Comment集合
	 * @author wei 
	 * @date 2016-8-15
	 * @param
	 * @return
	 */
	public List<Comment> findCommentByTaskId(String processInstanceId, String... type);
	
	/**
	 * @description 查询当前流程的任务
	 * @author wei 
	 * @date 2016-8-20
	 * @param processInstanceId
	 * @return
	 */
	public Task findTask(String processInstanceId);
	
	
	/**
	 * @description 添加批注信息
	 * @author wei 
	 * @date 2016-8-20
	 */
	public void addComment(String userId, String taskId, String processInstanceId, String comment);
	
	/**
	 * @description 根据role和taskName判断是否该role是事有该taskName的权限 
	 * @author ruix
	 */
    public boolean adjustHaveRight(String taskName, String roleId);
    
    /**
     * @description 添加批注信息
     * @author wwang 
     * @date 2016-9-1
     * @param userId
     * @param taskId
     * @param processInstanceId
     * @param type 类型
     * @param comment
     */
    public void addComment(String userId, String taskId, String processInstanceId, String type, String comment);
    
    /**
     * @description 修改定时任务时间
     * @author shy
     * @param processInstanceId
     * @param jobTime
     */
    public void updateJobTime(String processInstanceId, Date jobTime) throws Exception ;
    
    /**
     * @description 流程挂起
     * @author shy
     * @param processInstanceId
     */
    
    public void suspendProcess(String processInstanceId);
    
    
    /**
     * @description 流程激活
     * @author shy
     * @param processInstanceId
     */
    public void activateProcess(String processInstanceId, Map<String, Object> variables);
    
    /**
     * @description 根据流程id和任务名称查询历史任务
     * @author wwang 
     * @date 2016年9月13日
     * @param processInstanceId
     * @param taskName
     * @return
     */
    public HistoricTaskInstance findHistoricTaskByTaskName(String processInstanceId, String taskName);
}
