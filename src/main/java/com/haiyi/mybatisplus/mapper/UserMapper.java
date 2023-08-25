package com.haiyi.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haiyi.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository
public  interface UserMapper extends BaseMapper<User> {
    public Map<String,Object>  selectMapById(@Param("userId") Long id);
}
