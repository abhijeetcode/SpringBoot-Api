package com.abhijeet.webservices.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abhijeet.webservices.pojos.Topic;
import com.abhijeet.webservices.service.TopicService;

@RestController
public class FirstController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/hello")
	public String testing()
	{
		return "Hello world";
	}
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopic()
	{
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable("id") String topicId)
	{
		return topicService.getOneTopic(topicId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic)
	{
			topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopis(@RequestBody Topic topic,@PathVariable String id)
	{
		topicService.updateTopicDetails(topic,id);
	}
}
