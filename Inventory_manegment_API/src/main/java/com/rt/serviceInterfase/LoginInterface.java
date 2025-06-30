
package com.rt.serviceInterfase;

import java.util.Optional;

import com.rt.DTO.LoginDTO;
import com.rt.DTO.RespLoginDTO;


public interface LoginInterface {

	RespLoginDTO login(LoginDTO loginDto);

}
