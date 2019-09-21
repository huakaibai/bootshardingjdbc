package com.zhibinwang.repository;

import com.zhibinwang.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;



public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
	@Query(value = "SELECT order_id ,user_id  FROM t_order  where order_id in (?1);", nativeQuery = true)
	public List<OrderEntity> findExpiredOrderState(List<String> bpIds);

	@Query(value = "SELECT order_id ,user_id  FROM t_order  where user_id=:userId ", nativeQuery = true)
	public List<OrderEntity> findByUserId(@Param("userId") Long userId);

	@Query(value = "SELECT a.order_id ,a.user_id FROM t_order a LEFT  join  t_user b ON a.user_id = b.user_id ", nativeQuery = true)
	public List<OrderEntity> findByUser();
}