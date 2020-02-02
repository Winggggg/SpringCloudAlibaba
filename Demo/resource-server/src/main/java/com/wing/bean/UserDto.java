package com.wing.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author heweiye
 * @version 1.0
 * @description TODO
 * @date 2020/1/15 17:33
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String password;

    private String userName;

    private Jwt jwt;
}
