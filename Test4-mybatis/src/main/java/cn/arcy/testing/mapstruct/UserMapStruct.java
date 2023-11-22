package cn.arcy.testing.mapstruct;

import cn.arcy.testing.entities.Users;
import cn.arcy.testing.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapStruct {
    UserMapStruct INSTANCE = Mappers.getMapper(UserMapStruct.class);

    Users toUsers(UserVo userVo);

    UserVo toUserVo(Users user);

    List<UserVo> toUserVoList(List<Users> users);
}
