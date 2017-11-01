package org.rainboweleven.platform.controller.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rainboweleven.platform.controller.util.Result;
import org.rainboweleven.platform.controller.util.TokenApi;
import org.rainboweleven.platform.controller.vo.LoginObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api(value="用户相关的接口")
@RestController
@RequestMapping(value="/common/user",produces="application/json;charset=UTF-8")
public class UserController {

    @Autowired
    private TokenApi tokenApi;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(notes="用户登录",value="用户登录",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginObject", value = "登录对象", paramType = "body", required = true, dataType = "string")
    })
    public String login(@RequestBody LoginObject loginObject){


        //TODO:首先去验证用户名密码对不对

        /**
         * 生成token
         */
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put(TokenApi.CLAIM_KEY_USERNAME, loginObject.getUsername());
        claims.put(TokenApi.CLAIM_KEY_CREATED, new Date());
        String token = tokenApi.generateToken(claims);

        /**
         * 登录成功后将token返回给前端
         */
        Result r = new Result();
        r.putString("token",token);
        r.setResult(true);
        return r.toString();

    }

}
