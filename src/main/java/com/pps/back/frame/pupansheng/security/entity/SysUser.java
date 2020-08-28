package com.pps.back.frame.pupansheng.security.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

/**
 * sys_user
 * @author 
 */
@Data
public class SysUser implements Serializable {

    private Long id;

    private String name;

    private String password;

    private String phone;

    private static final long serialVersionUID = 1L;

}