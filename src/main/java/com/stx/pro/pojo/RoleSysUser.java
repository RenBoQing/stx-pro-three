package com.stx.pro.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author RenBoQing
 * @date 2022年06月17日 19:02
 * @Description
 */
@Data
@TableName("fruit_role_sysuser")
public class RoleSysUser {
    @JsonFormat(shape = JsonFormat.Shape.STRING)   //解决雪花算法到前端进度丢失问题
    @TableId(value = "sysuid", type = IdType.ASSIGN_ID)
    private Long sysUid;
    @TableField("roleid")
    private Long roleId;
}
