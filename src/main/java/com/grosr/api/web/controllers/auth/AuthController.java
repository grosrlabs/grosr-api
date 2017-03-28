package com.grosr.api.web.controllers.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.grosr.api.dao.authentication.AccountDAO;
import com.grosr.api.dao.authentication.PasswordDAO;
import com.grosr.api.domain.account.Account;
import com.grosr.api.domain.account.Password;
import com.grosr.api.dto.auth.Login;
import com.grosr.api.dto.auth.User;
import com.grosr.api.services.common.CryptWithMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by grosr on 3/4/17.
 */

@RestController
public class AuthController implements IAuthController {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private PasswordDAO passwordDAO;

    @Autowired
    private CryptWithMD5 cryptWithMD5;


    @CrossOrigin(origins = "*")
    @Override
    @RequestMapping(value = "/api/v1/auth/login",method = RequestMethod.POST)
    public User login(@RequestBody Login payload) {
        User user = new User();
        Date startTime = new Date();
        Account acc = accountDAO.getByUsername(payload.getUsername());
        Password pwd = passwordDAO.getByUserId(acc.getUserId());
        if(pwd!=null && pwd.getPassword().equals(cryptWithMD5.cryptWithMD5(payload.getPassword()))) {
            Date endTime = new Date();
            System.out.println((endTime.getTime() - startTime.getTime()) / 1000);
            String token = "";
            if (acc != null) {
                try {
                    token = JWT.create()
                            .withIssuer("grosr.api")
                            .withClaim("admin", true)
                            .withJWTId(acc.getUsername())
                            .sign(Algorithm.HMAC256(acc.getUsername()));
                } catch (JWTCreationException exception) {
                    //Invalid Signing configuration / Couldn't convert Claims.
                } catch (UnsupportedEncodingException ex) {

                }
            }

            user.setToken(token);
            return user;
        }else{
            return null;
        }
    }

    @CrossOrigin(origins = "*")
    @Override
    @RequestMapping(value = "/api/v1/auth/logout",method = RequestMethod.GET)
    public String logout() {
        return null;
    }
}
