package com.opensource.jobdispatcher.service.alert;

import org.springframework.context.ApplicationEvent;
import com.opensource.jobdispatcher.model.middleware.builder.JobBoxBuilder;

public class AlertEvent extends ApplicationEvent{
	
	private static final long serialVersionUID = 49879530541259812L;
	
	private JobBoxBuilder jobBoxBuilder;
	
	private String content;

	public AlertEvent(Object source, JobBoxBuilder jbb, String content) {
		super(source);
		this.jobBoxBuilder = jbb;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public JobBoxBuilder getJobBoxBuilder() {
		return jobBoxBuilder;
	}
	
}