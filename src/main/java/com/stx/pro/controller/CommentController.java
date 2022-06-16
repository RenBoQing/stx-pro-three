package com.stx.pro.controller;

import com.stx.pro.pojo.Comment;
import com.stx.pro.pojo.SysUser;
import com.stx.pro.service.CommentService;
import com.stx.pro.utils.CommonResult;
import com.stx.pro.utils.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/goodsComment")
public class CommentController {
    @Autowired
    private CommentService commentService;


    /**
     * 查询所有评论
     *
     * @return {@link CommonResult}
     */
    @ResponseBody
    @RequestMapping(value = "/goodsCommentList")
    private CommonResult queryAllGoodsComment(){
        List<Comment> list = commentService.list();
        if (list.size()>0){
            return CommonResult.success("查询成功");
        }else {
            return CommonResult.failed("暂无数据");
        }
    }


    /**
     * 修改评论
     *
     * @param comment 系统用户
     * @return {@link CommonResult}
     */
    @RequestMapping(value = "/updateByCid", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateByCid(Comment comment) {
        boolean updateById = commentService.updateById(comment);
        if (updateById) {
            return CommonResult.success("修改成功");
        } else {
            return CommonResult.failed("修改失败");
        }
    }


    /**
     * 由cid删除系统用户
     *
     * @param cid cid
     * @return {@link JsonObject}
     */
    @RequestMapping(value = "/del/{cid}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonObject deleteSysUserByCid(@PathVariable("cid") Long cid) {
        boolean b = commentService.removeById(cid);
        if (b) {
            return JsonObject.success(0, "删除成功");
        } else {
            return JsonObject.fail(1, "删除失败");
        }
    }





    @RequestMapping(value = "/CommentJoin", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject join(Comment comment) {
        boolean insert = commentService.save(comment);
        if (insert) {
            return JsonObject.success(0, "添加成功");
        } else {
            return JsonObject.fail(1, "添加失败");
        }
    }


}
