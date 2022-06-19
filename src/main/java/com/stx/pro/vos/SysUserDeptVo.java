package com.stx.pro.vos;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;
/**
 * @author RenBoQing
 * @date 2022年06月17日 19:41
 * @Description 实体类
 */
@Data
public class SysUserDeptVo {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long suid;
    private String sysname;
    private String sysnickname;
    private String sysemail;
    private Integer systatus;
    private Date createtime;
    private String deptname;
    private Integer sort;
    @TableLogic
    private Integer deleted;
    private String sysavaurl;
}
