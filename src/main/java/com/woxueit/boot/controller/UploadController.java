package com.woxueit.boot.controller;
import com.woxueit.boot.utils.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    //读取配置文件：upload.path的值
    @Value("${upload.path}")
    private String uploadPath;

    /**
     * 单文件上传
     * @param file 上传的文件
     * @return 文件访问地址
     */
    @PostMapping("/single")
    public CommonResult uploadSingle(@RequestParam("file") MultipartFile file) throws IOException {
        // 空文件判断
        if (file.isEmpty()) {
            return new CommonResult(500, "上传失败，请选择文件");
        }

        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();
        // 生成唯一文件名（防止重名覆盖）
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID() + suffix;

        // 创建文件对象
        File destFile = new File(uploadPath + File.separator + fileName);
        // 写入磁盘
        file.transferTo(destFile);

        // 返回可访问的URL
        return new CommonResult(200, "上传成功！", "http://localhost:8080/files/" + fileName);
    }

    /**
     * 多文件上传
     * @param files 文件数组
     * @return 所有文件访问地址
     */
    @PostMapping("/multiple")
    public CommonResult uploadMultiple(@RequestParam("files") MultipartFile[] files) throws IOException {
        List<String> resultList = new ArrayList<>();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String originalFilename = file.getOriginalFilename();
                String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
                String fileName = UUID.randomUUID() + suffix;

                File destFile = new File(uploadPath + File.separator + fileName);
                file.transferTo(destFile);

                resultList.add("http://localhost:8080/files/" + fileName);
            }
        }
        return new CommonResult(200, "success", resultList);
    }
}