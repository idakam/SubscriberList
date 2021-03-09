package com.tts.subscriberList.subscriber;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubscriberController {
	
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@GetMapping
	public String index(Subscriber subscriber) {
		return "subscriber/index";
	}
	
	@PostMapping(value = "/")
	public String addNewSubscriber(Subscriber subscriber, Model model) {
		subscriberRepository.save(new Subscriber(subscriber.getFirstName(), 
	        subscriber.getLastName(), subscriber.getUserName(), subscriber.getSignedUp()));
		model.addAttribute("firstName", subscriber.getFirstName());
		model.addAttribute("lastName", subscriber.getLastName());
		model.addAttribute("userName", subscriber.getUserName());
		return "subscriber/result";
	}
	
	@GetMapping(value = "/subscribers")
	public String getAllSubscribers(Subscriber subscriber, Model model) {
		List<Subscriber> listAllSubscribers = new ArrayList<Subscriber>();
		listAllSubscribers = subscriberRepository.findAll();
		model.addAttribute("listAllSubscribers", listAllSubscribers);
		return "subscriber/subscribers";
	}
}
