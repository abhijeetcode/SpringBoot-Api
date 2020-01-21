package com.abhijeet.webservices.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.abhijeet.webservices.pojos.Topic;

@Service
public class TopicService {
	

	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("1", "Spring", "Spring framwork java"),
			new Topic("2", "Spring IOC", "Spring framwork java")
			));

	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getOneTopic(String id){
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}


	public void updateTopicDetails(Topic topic, String id) {
		for(int i=0;i<topics.size();i++)
		{
			Topic tp = topics.get(i);
			if(tp.getId().equals(id))
			{
				topics.set(i,topic);
				return;
			}
			
		}
		
	}

}
