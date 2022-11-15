package com.stx.pro.controller;

import com.stx.pro.pojo.Comment;
import com.stx.pro.pojo.SysUser;
import com.stx.pro.service.CommentService;
import com.stx.pro.utils.CommonResult;
import com.stx.pro.utils.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
/*
 * 商品评论的实体类
 * @author RenBoQing
 * @date 2022/11/15 0015 22:32
 * @param null
 * @return null
 */
@Controller
@RequestMapping("/goodsComment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    /*
     *查询所有的数据
     * @author RenBoQing
     * @date 2022/10/13 0013 14:37
     * @return com.stx.pro.utils.CommonResult
     */
    @ResponseBody
    @RequestMapping(value = "/goodsCommentList")
    public CommonResult queryAllGoodsComment(){
        List<Comment> list = commentService.list();
        if (list.size()>0){
            return CommonResult.success("查询成功");
        }else {
            return CommonResult.failed("暂无数据");
        }
    }
    /*
     *根据id修改数据
     * @author RenBoQing
     * @date 2022/10/13 0013 14:38
     * @param comment
     * @return com.stx.pro.utils.CommonResult
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


   /*
    *删除评论
    * @author RenBoQing
    * @date 2022/10/13 0013 14:39
    * @param cid
    * @return com.stx.pro.utils.JsonObject
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


     /*
      *
      * @author RenBoQing
      * @date 2022/10/13 0013 14:40
      * @param comment 
      * @return com.stx.pro.utils.JsonObject
      */
    @RequestMapping(value = "/CommentJoin", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject addComment(Comment comment) {
        boolean insert = commentService.save(comment);
        if (insert) {
            return JsonObject.success(0, "添加成功");
        } else {
            return JsonObject.fail(1, "添加失败");
        }
    }
}
