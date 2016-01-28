package com.swl.tp_slack_integrater.controller;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import lombok.extern.java.Log;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@Log
@Controller
public class TPSlackController {
	private static final Cache<String, Template> TEMPLATES = 
			CacheBuilder.newBuilder()
		    .concurrencyLevel(2)
		    .maximumSize(10000)
		    .expireAfterWrite(30, TimeUnit.MINUTES)
		    .build();
	
	@RequestMapping(value = "/tp-slack-proxy", method = RequestMethod.POST)
    public void recieveTPWebhook(final @RequestBody Template template) throws IOException, ExecutionException{
        log.info(template.toString());
        
        Template previousTemplate = TEMPLATES.getIfPresent(template.text);
        
        if (previousTemplate != null) {
        	return;
        }
        	
        TEMPLATES.put(template.text, template);
        
        HttpPost post = new HttpPost(template.webhook);
        post.addHeader("Content-Type", ContentType.APPLICATION_JSON.getMimeType());
        post.setEntity(new StringEntity(new ObjectMapper().writeValueAsString(template), Charsets.UTF_8));
        
        log.info("Pushing notification to the Slack channel.");
        
        HttpClientBuilder.create().build().execute(post);
    }
}