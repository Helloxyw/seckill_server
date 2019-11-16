package com.xyw.seckill_server.dao;

import com.xyw.seckill_server.domain.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName MiaoshaUserDao.java
 * @Description TODO
 * @createTime 2019年11月16日 16:27:00
 */
@Mapper
@Component
public interface MiaoshaUserDao {

    @Select("select * from miaosha_user where id =#{id}")
    MiaoshaUser getById(@Param("id") String id);

    @Update("uodate miaosha_user set password = #{password} where id = #{id}")
    void update(MiaoshaUser miaoshaUser);

}