package com.taxapplication.distributedusers.dto;

import com.taxapplication.distributedusers.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto implements Serializable {

    private Long id;

    private String roleName;

    private String description;

    List<UserDto> usersroles;

}
