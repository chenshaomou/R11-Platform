package org.rainboweleven.platform.controller.protection;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.rainboweleven.platform.controller.util.Result;
import org.rainboweleven.platform.controller.vo.NewAppObject;
import org.springframework.web.bind.annotation.*;

@Api(value="产品管理接口")
@RestController
@RequestMapping(value="/protection/pm",produces="application/json;charset=UTF-8")
public class PMController {

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(notes="新增应用",value="新增应用",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "newAppObject", value = "新增应用", paramType = "body", required = true, dataType = "string")
    })
    public Result addNew(@RequestBody NewAppObject newAppObject){


        return new Result();
    }
}
