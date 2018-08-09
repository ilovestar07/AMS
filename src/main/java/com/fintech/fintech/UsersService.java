package com.fintech.fintech;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersService {

	@Select("SELECT * FROM SYS_USERS where user_code='admin'")
    Users findByNameAndPassword(Users users);
}
