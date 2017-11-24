package org.workflow.core.activity;

import org.workflow.core.execption.WorkflowExtensionException;
import org.workflow.core.model.TaskList;
import org.workflow.core.model.TaskVariableResponse;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface RestClient {
	@RequestLine("POST  query/tasks")
	@Headers("Content-Type: application/json")
	TaskList getTasks(ProcessSearchRequest request) throws WorkflowExtensionException;

	@RequestLine("GET  runtime/tasks/{taskId}/variables")
	TaskVariableResponse[] getVariables(@Param("taskId") String taskId) throws WorkflowExtensionException;
}