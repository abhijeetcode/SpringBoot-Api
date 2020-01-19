package com.abhijeet.webservices.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.abhijeet.webservices.pojos.Topic;

@Service
public class TopicService {

	List<Topic> topics = Arrays.asList(new Topic("1", "Spring", "Spring framwork java"),
			new Topic("2", "Spring IOC", "Spring framwork java"));

	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getOneTopic(String id){
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		
	}

}
