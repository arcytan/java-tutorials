package cn.arcy.testing.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserVo {
    private Integer id;
    private String name;
    private String sex;
    private LocalDateTime createdAt;
}
