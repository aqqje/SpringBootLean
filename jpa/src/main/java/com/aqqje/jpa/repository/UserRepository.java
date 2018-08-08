package com.aqqje.jpa.repository;

import com.aqqje.jpa.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

// 继承 JpaRepository 来对数据表进行操作
public interface UserRepository extends JpaRepository<User, Integer> {
}
