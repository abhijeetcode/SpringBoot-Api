package com.abhijeet.webservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abhijeet.webservices.exceptions.CustomException;
import com.abhijeet.webservices.pojos.Topic;
import com.abhijeet.webservices.service.TopicService;

@RestController
public class FirstController {

	@Autowired
	private TopicService topicService;

	@RequestMapping("/hello")
	public ResponseEntity<String> testing() {
		try {
			int x = 12;
			x = x / 1;

		} catch (Exception e) {
			throw new CustomException();
		}
		return new ResponseEntity<String>("Product found", HttpStatus.FOUND);
	}

	@RequestMapping("/topics")
	public ResponseEntity<Object> getAllTopic() {
		
		List<Topic> allTopics = topicService.getAllTopics();
		if(allTopics.size()>0)
		{
			return new ResponseEntity<>(allTopics,HttpStatus.OK);
		}
		return new ResponseEntity<>("Not data",HttpStatus.NOT_FOUND);
	}

	// To get topic details based on
	@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable("id") String topicId) {
		return topicService.getOneTopic(topicId);
	}

	// To add new topic
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

	// To update the topic
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopis(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopicDetails(topic, id);
	}

	// To delete a topic
	@RequestMapping(method = RequestMethod.DELETE, value = "topics/{id}")
	public void deleteTopic(@PathVariable("id") String id) {
		topicService.deleteTopic(id);
	}

}
