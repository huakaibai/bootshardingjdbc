package com.zhibinwang.repository;

import com.zhibinwang.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author 花开
 * @create 2019-09-21 12:41
 * @desc
 **/
public interface UserRepository extends CrudRepository<UserEntity,Long> {



}
