package com.taxapplication.distributedusers.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestModel {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
}
