package com.zoivi.repository;

import com.zoivi.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/3/26 0026.
 * 数据库接口，相当于dao
 */
public interface GirlRepository extends JpaRepository<Girl, Integer>{
    // 通过年龄查询 方法名要严格按照格式写
    public List<Girl> findByAge (Integer age);
}
