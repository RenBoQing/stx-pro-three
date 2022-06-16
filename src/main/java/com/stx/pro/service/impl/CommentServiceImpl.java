package com.stx.pro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stx.pro.mapper.CommentMapper;
import com.stx.pro.pojo.Comment;
import com.stx.pro.service.CommentService;
import com.sun.webkit.dom.CommentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class CommentServiceImpl extends ServiceImpl <CommentMapper,Comment>implements CommentService{

}

