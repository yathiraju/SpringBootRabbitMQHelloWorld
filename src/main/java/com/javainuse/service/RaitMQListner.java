package com.javainuse.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.javainuse.model.Employee;

@Service
public class RaitMQListner {


	@RabbitListener(queues="${javainuse.rabbitmq.queue}")
	public void receiveMessage(Employee employee) {
		System.out.println("Message came: "+ employee);
		System.out.println("Message came: "+ employee.getEmpId());
	}

}
