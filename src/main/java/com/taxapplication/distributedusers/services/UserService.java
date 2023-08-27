package com.taxapplication.distributedusers.services;

import com.taxapplication.distributedusers.domain.Users;
import com.taxapplication.distributedusers.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userdto);

    //ResponseTemplateVo getUserApprovalLevelById(Long userid);
    UserDto getUser(String username);
   // UserDto findUserById(Long userid);


}
