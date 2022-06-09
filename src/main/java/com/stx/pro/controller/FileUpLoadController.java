package com.stx.pro.controller;

import com.stx.pro.utils.TencentCosUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author RenBoQing
 * @date 2022年05月30日 16:37
 * @Description 文件上传接口
 */
@RestController
public class FileUpLoadController {
    /*
     *文件上传
     * @author RenBoQing
     * @date 2022/6/7 0007 19:21
     * @param file
     * @return java.lang.String
     */
    @PostMapping("/file/upload")
    public String testUpload(@RequestParam(value = "file") MultipartFile file) {
        if (file == null) {
            return "上传文件为空 ";
        }
        String uploadfile = TencentCosUtil.uploadfile(file);
        //直接返回上传成功后的名称
        return uploadfile;
    }
}
