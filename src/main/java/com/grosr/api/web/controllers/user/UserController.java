package com.grosr.api.web.controllers.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.grosr.api.dao.authentication.AccountDAO;
import com.grosr.api.dao.authentication.PasswordDAO;
import com.grosr.api.domain.account.Account;
import com.grosr.api.domain.account.Password;
import com.grosr.api.dto.auth.Login;
import com.grosr.api.services.common.CryptWithMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * Created by grosr on 3/4/17.
 */
@RestController
public class UserController implements IUserController{


    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private PasswordDAO passwordDAO;


    @Autowired
    private CryptWithMD5 cryptWithMD5;

    @Override
    @RequestMapping(value = "/api/v1/me", method = RequestMethod.POST)
    public JWT me(@RequestHeader(value = "token") String token) {
        JWT jwt = null;
        try {
            jwt = JWT.decode(token);
        } catch (JWTDecodeException exception){
            //Invalid token
        }
        return jwt;
    }
    @Override
    @RequestMapping(value = "/api/v1/register", method = RequestMethod.POST)
    public String register(@RequestBody Account payload) {
        try {
            Date today = new Date();
            payload.setCreatedBy(1);
            payload.setModifiedBy(1);
            payload.setCreatedAt(today);
            payload.setModifiedAt(today);
            Account account = accountDAO.create(payload);
            Password pwd = new Password();
            pwd.setUserId(account.getUserId());

            pwd.setPassword(cryptWithMD5.cryptWithMD5("admin"));
            pwd.setCreatedBy(1);
            pwd.setModifiedBy(1);
            pwd.setCreatedAt(today);
            pwd.setModifiedAt(today);
            //pwd.setPassword(payload);
            passwordDAO.create(pwd);
            return "Account Created.";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @RequestMapping(value = "/api/v1/resetpassword", method = RequestMethod.POST)
    public String resetpassword(@RequestBody Login payload) {
        try {
            Date today = new Date();
            Password pwd = new Password();
            //pwd.setUserId(payload.getUserId());
            pwd.setPassword(cryptWithMD5.cryptWithMD5(payload.getPassword()));
            pwd.setCreatedBy(1);
            pwd.setModifiedBy(1);
            pwd.setCreatedAt(today);
            pwd.setModifiedAt(today);
            passwordDAO.create(pwd);
            return "Account Created.";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
