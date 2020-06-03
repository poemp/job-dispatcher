package com.opensource.jobdispatcher.controller.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.opensource.jobdispatcher.model.middleware.builder.JobBoxBuilder;
import com.opensource.jobdispatcher.service.engine.JobBoxBuilderRegistry;

@Service
public class BuilderControllerService {

	@Autowired
	private JobBoxBuilderRegistry jobBoxBuilderRegistry;

	public JsonArray getAllJobBuilders() {
		JsonArray ja = new JsonArray();
		List<JobBoxBuilder> jbs = jobBoxBuilderRegistry.getAllJobBoxBuilders();
		if(null!=jbs) {
			for(JobBoxBuilder jb:jbs) {
				ja.add(new JsonParser().parse(new Gson().toJson(jb)).getAsJsonObject());
			}
		}
		return ja;
	}
	

}