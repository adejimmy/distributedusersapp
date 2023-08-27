package com.taxapplication.distributedusers.servicesImpl;

import com.taxapplication.distributedusers.domain.Organization;
import com.taxapplication.distributedusers.domain.Users;
import com.taxapplication.distributedusers.dto.RoleDto;
import com.taxapplication.distributedusers.dto.UserDto;
import com.taxapplication.distributedusers.exception.UserServiceException;
import com.taxapplication.distributedusers.repository.UsersRepository;
import com.taxapplication.distributedusers.services.UserService;
import com.taxapplication.distributedusers.utilities.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepository userRepository;
    @Autowired
    Utils util;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private RestTemplate restTemplate;

    public UserDto createUser(UserDto user) {


        if (userRepository.findByEmail(user.getEmail()) != null)
            throw new UserServiceException("Record already exists");

        for (int i = 0; i < user.getRoles().size(); i++) {
            RoleDto roles = user.getRoles().get(i);
            roles.setUsersroles(List.of(user));
            user.getRoles().set(i, roles);
        }

        //BeanUtils.copyProperties(user, userEntity);
        ModelMapper modelMapper = new ModelMapper();
        Users userEntity = modelMapper.map(user, Users.class);

        String publicUserId = util.generateId(30);
        userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setEmailVerificationToken(util.generateEmailVerificationToken(publicUserId));

        Users storedUserDetails = userRepository.save(userEntity);

        //BeanUtils.copyProperties(storedUserDetails, returnValue);
        UserDto returnValue = modelMapper.map(storedUserDetails, UserDto.class);


        return returnValue;
    }


//    public Users findUserById(Long userid) {
//
//        return userrepo.findByUserid(userid);
//    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetailsImpl.build(user);
    }


//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        Users user = userRepository.findByUsername(s).orElseThrow(() ->
//                new UsernameNotFoundException(String.format("User with name %s does not exist", s)));
//
//        return withUsername(user.getUsername())
//                .password(user.getPassword())
//                .authorities(user.getRoles())
//                .accountExpired(false)
//                .accountLocked(false)
//                .credentialsExpired(false)
//                .disabled(false)
//                .build();
//    }
    @Override
    public UserDto getUser(String username) {
        Optional<Users> userEntity = userRepository.findByUsername(username);

        if (userEntity == null)
            throw new UsernameNotFoundException(username);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }


}



    
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//            Users userEntity = userRepository.findByEmail(email);
//
//            if (userEntity == null)
//                throw new UsernameNotFoundException(email);
//
//            return new User(userEntity.getEmail(), userEntity.getPassword(),
//                    userEntity.getEmailVerificationStatus(),
//                    true, true,
//                    true, new ArrayList<>()) {
//            };
//    }

//    private static Users createUserObject1() {
//        Users user = new Users();
//        user.setUsername("user1");
//        user.setPassword("testPassword");
//        Role role = new Role();
//        role.setName("Lab Staff");
//        List<Role> roles = Collections.singletonList(role);
//        user.setRoles(roles);
//        return user;
//    }
//    private static Users createUserObject2() {
//        Users user = new Users();
//        user.setUsername("user2");
//        user.setPassword("testPassword2");
//        Role role1 = new Role();
//        role1.setName("Teacher");
//        Role role2 = new Role();
//        role2.setName("Chairman");
//        List<Role> roles = new ArrayList<>();
//        roles.add(role1);
//        roles.add(role2);
//        user.setRoles(roles);
//        return user;
//    }
//}

