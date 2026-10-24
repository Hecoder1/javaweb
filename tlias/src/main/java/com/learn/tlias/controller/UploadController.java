package com.learn.tlias.controller;


import com.learn.tlias.pojo.Result;
import com.learn.tlias.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) {
        log.info("上传文件：{}", file);
        try {
            if (file == null || file.isEmpty()) {
                return Result.error("文件为空");
            }
            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null || originalFilename.lastIndexOf('.') < 0) {
                return Result.error("文件名不合法");
            }
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString().replace("-", "") + extName;
            String url = aliyunOSSOperator.upload(file.getBytes(), uniqueFileName);
            return Result.success(url);
        } catch (Exception e) {
            log.error("文件上传失败", e);           // ← 关键：让堆栈进日志
            return Result.error("上传失败：" + e.getMessage());
        }
    }

}