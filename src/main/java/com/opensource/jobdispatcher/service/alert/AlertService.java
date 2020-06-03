package com.opensource.jobdispatcher.service.alert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import com.opensource.jobdispatcher.model.middleware.builder.JobBoxBuilder;
import com.opensource.jobdispatcher.service.engine.JobBoxBuilderRegistry;

@Service
public class AlertService{
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@Autowired
	private JobBoxBuilderRegistry jobBoxBuilderRegistry;

	public void alert(String jobCode,String content){
		JobBoxBuilder jbb = jobBoxBuilderRegistry.getJobBoxBuilderByJobCode(jobCode);
		if(jbb != null) {
			//发送一个对应JobBuilder的告警内容
			applicationContext.publishEvent(new AlertEvent(this,jbb,content));
		}
	}

}
