package com.stx.pro.controller;

import com.stx.pro.utils.CommonResult;
import com.stx.pro.utils.TencentCosUtil;
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
    public CommonResult testUpload(@RequestParam(value = "file") MultipartFile file) {
        if (file == null) {
            return CommonResult.failed("上传文件不能为空");
        }
        String uploadfile = TencentCosUtil.uploadfile(file);
        return CommonResult.success(uploadfile, "文件上传成功");
    }
}
