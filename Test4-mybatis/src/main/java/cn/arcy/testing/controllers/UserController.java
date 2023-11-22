package cn.arcy.testing.controllers;

import cn.arcy.testing.entities.Users;
import cn.arcy.testing.mappers.UsersMapper;
import cn.arcy.testing.mapstruct.UserMapStruct;
import cn.arcy.testing.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    UsersMapper usersMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserVo> getUserInfo(@PathVariable Integer id)
    {
        log.info("id:{}", id);
        Users userInfo = usersMapper.selectByPrimaryKey(id);

        //UserVo userVo = new UserVo();
        //BeanUtils.copyProperties(userInfo, userVo);

        UserVo userVo = UserMapStruct.INSTANCE.toUserVo(userInfo);

        return ResponseEntity.ok(userVo);
    }

    @PostMapping
    public ResponseEntity<Map<String, Integer>> insertUser(@RequestBody UserVo userVo)
    {
        HashMap<String, Integer> res = new HashMap<>();

        System.out.println(userVo);

        Users users = new Users();
        users.setName(userVo.getName());
        users.setCreatedAt(LocalDateTime.now());
        users.setStatus((byte) 1);

        usersMapper.insert(users);

        res.put("code", 200);
        res.put("data", 1);

        return ResponseEntity.ok(res);
    }
}
