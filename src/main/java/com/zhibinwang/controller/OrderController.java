package com.zhibinwang.controller;

import com.zhibinwang.config.SnowflakeIdWorker;
import com.zhibinwang.entity.OrderEntity;
import com.zhibinwang.entity.UserEntity;
import com.zhibinwang.repository.OrderRepository;
import com.zhibinwang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@RestController
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	private static final SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0, 0);

	// 查询所有的订单信息
	@RequestMapping("/getOrderAll")
	public List<OrderEntity> getOrderAll() {
		List<OrderEntity> listOrder = (List<OrderEntity>) orderRepository.findAll();
		System.out.println("总数：" + listOrder.size());
		return listOrder;
	}

	@GetMapping("/findByUser")
	public List<OrderEntity> findByUser(){
		List<OrderEntity> byUser = orderRepository.findByUser();
		return byUser;
	}

	@RequestMapping("/findIdByOrder")
	public Optional<OrderEntity> findIdByOrder(Long id) {
		return orderRepository.findById(id);
	}

	@RequestMapping("/findIdByUserId")
	public List<OrderEntity> findIdByUserId(Long userId) {
		return orderRepository.findByUserId(userId);
	}

	// 使用in条件查询
	@RequestMapping("/inOrder")
	public List<OrderEntity> inOrder() {
		List<String> ids = new ArrayList<>();
		ids.add("2");
		ids.add("3");
		ids.add("4");
		ids.add("5");
		return orderRepository.findExpiredOrderState(ids);

	}

	// 增加
	@RequestMapping("/inserOrder")
	public String inserOrder(OrderEntity orderEntity) {
		for (int i = 0; i < 10; i++) {
			OrderEntity order = new OrderEntity();
			long l = snowflakeIdWorker.nextId();
			order.setOrderId(l);
			order.setUserId( l);
			// 根据userid进行分片存放
			orderRepository.save(order);
			UserEntity userEntity = new UserEntity();
			userEntity.setUserId(l);
			userEntity.setUserName("zhibinwang"+i);
			userRepository.save(userEntity);
		}
		for (int i = 0; i < 10; i++){
			OrderEntity order = new OrderEntity();
			long l = snowflakeIdWorker.nextId();
			order.setOrderId(l);
			order.setUserId( l);
			orderRepository.save(order);
		}
		return "success";
	}

}
