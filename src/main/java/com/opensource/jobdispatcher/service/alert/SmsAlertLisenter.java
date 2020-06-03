package com.opensource.jobdispatcher.service.alert;

import java.util.Arrays;
import java.util.HashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component
public class SmsAlertLisenter{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Value("${admin.mobilenos}")
	private String adminMobileNos;

	@EventListener
    public void smsAlert(AlertEvent alertEvent) {
		try {
			HashSet<String> mobileSet = new HashSet<String>(Arrays.asList(adminMobileNos.split(",")));
			String mp = alertEvent.getJobBoxBuilder().getMonitorParas();
			if(mp!=null) {
				JsonObject jo = new JsonParser().parse(mp).getAsJsonObject();
				if(null!=jo.get("mobileNos")) {
					JsonArray mobileNos = jo.get("mobileNos").getAsJsonArray();
					for(JsonElement mobileNo:mobileNos) {
						mobileSet.add(mobileNo.getAsString());
					}
				}
				log.info("<<<<<Start Send Sms :mobilenos is " + mobileSet.toString());
				//此处自行实现如何处理警告
			}
		}catch(Exception e) {
			log.error("####告警中心异常 "+ e.getMessage());
		}
	}
}
