package study.services;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {
	public String getDescription() {
		System.out.println("in desc");
		return "desc";
	}
	
	public String tell() {
		System.out.println("tell");
		return "tell";
	}
}
