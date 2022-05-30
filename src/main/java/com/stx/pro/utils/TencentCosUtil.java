package com.stx.pro.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Random;

/**
 * @author RenBoQing
 * @date 2022年05月30日 16:14
 * @Description  腾讯云CoS文件上传配置类
 */
public class TencentCosUtil {
    // 存储桶名称
    private static final String bucketName = "pro-demo-1305783091";
    //secretId 秘钥id
    private static final String SecretId = "AKIDrXw4wd4D6i37zauwhCQN3TcU5RWJp43l";
    //SecretKey 秘钥
    private static final String SecretKey = "RbV8UZOxFGzSeZDagV3KK3Vgfuud6IDr";
    // 腾讯云 自定义文件夹名称
    private static final String prefix = "stx-pro-three/";
    // 访问域名
    public static final String URL = "https://pro-demo-1305783091.cos.ap-chengdu.myqcloud.com/";
    // 创建COS 凭证
    private static COSCredentials credentials = new BasicCOSCredentials(SecretId, SecretKey);
    // 配置 COS 区域 就购买时选择的区域 我这里是 成都（chengdu）
    private static ClientConfig clientConfig = new ClientConfig(new Region("ap-chengdu"));

    public static String uploadfile(MultipartFile file) {
        // 创建 COS 客户端连接
        COSClient cosClient = new COSClient(credentials, clientConfig);
        String fileName = file.getOriginalFilename();
        try {
            String substring = fileName.substring(fileName.lastIndexOf("."));
            File localFile = File.createTempFile(String.valueOf(System.currentTimeMillis()), substring);
            file.transferTo(localFile);
            Random random = new Random();
            fileName = prefix + random.nextInt(10000) + System.currentTimeMillis() + substring;
            //将文件上传至 COS
            PutObjectRequest objectRequest = new PutObjectRequest(bucketName, fileName, localFile);
            cosClient.putObject(objectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cosClient.shutdown();
        }
        return URL + fileName;
    }
}
