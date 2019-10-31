package com.maxton.controller;

import com.maxton.common.response.PageResult;
import com.maxton.common.response.ResponseResult;
import com.maxton.common.response.enumCode.CommonCode;
import com.maxton.model.UserData;
import com.maxton.service.UserDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description
 * @Author maxton.zhang
 * @Date 2019/10/31 13:21
 * @Version 1.0
 */
@Api(tags = "测试接口")
@RestController
@CrossOrigin
@RequestMapping("/userData")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    /**
     * 查询全部数据
     *
     * @return
     */
    @ApiOperation("查询全部")
    @GetMapping(value = "/findAll")
    public ResponseResult findAll() {
        return new ResponseResult(CommonCode.QUERY_SUCCESS, userDataService.findAll());
    }

    /**
     * 根据id查询
     *
     * @param user_id
     * @return
     */
    @ApiOperation("根据id查询")
    @GetMapping(value = "/findUserDataById/{user_id}")
    public ResponseResult findUserDataById(@PathVariable String user_id) {
        return new ResponseResult(CommonCode.QUERY_SUCCESS, userDataService.findUserDataById(user_id));
    }

    /**
     * 分页+多条件查询
     *
     * @param searchMap 查询条件封装
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @ApiOperation("分页+多条件查询")
    @RequestMapping(value = "/findSearch/{page}/{size}", method = RequestMethod.POST)
    public ResponseResult findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<UserData> pageList = userDataService.findSearch(searchMap, page, size);
        return new ResponseResult(CommonCode.SUCCESS, new PageResult<UserData>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 根据条件查询
     *
     * @param searchMap
     * @return
     */
    @ApiOperation("根据条件查询")
    @RequestMapping(value = "/findSearch/search", method = RequestMethod.POST)
    public ResponseResult findSearch(@RequestBody Map searchMap) {
        return new ResponseResult(CommonCode.QUERY_SUCCESS, userDataService.findSearch(searchMap));
    }


    /**
     * 增加
     *
     * @param userData
     */
    @ApiOperation("增加")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody UserData userData) {
        userDataService.add(userData);
        return new ResponseResult(CommonCode.CREATE_SUCCESS);
    }

    /**
     * 修改
     *
     * @param userData
     * @param user_id
     * @return
     */
    @ApiOperation("修改")
    @RequestMapping(value = "/update/{user_id}", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody UserData userData, @PathVariable String user_id) {
        userData.setUser_id(user_id);
        userDataService.update(userData);
        return new ResponseResult(CommonCode.UPDATE_SUCCESS);
    }

    /**
     * 删除
     *
     * @param user_id
     */
    @ApiOperation("删除")
    @RequestMapping(value = "/delete/{user_id}", method = RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable String user_id) {
        userDataService.deleteById(user_id);
        return new ResponseResult(CommonCode.DELETE_SUCCESS);
    }
}
