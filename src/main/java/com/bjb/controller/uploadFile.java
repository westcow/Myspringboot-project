package com.bjb.controller;

import com.bjb.config.AppConfig;
import com.bjb.config.FileResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/upload")
public class uploadFile {
    @Autowired
    private AppConfig appConfig;

    @RequestMapping("/fileUpload")
    public FileResult fileUpload(MultipartFile file)  {
        String fileName = "";
        if (!file.isEmpty()){
            //获取文件的后缀
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

            //定义新文件的名称
            fileName = System.currentTimeMillis() + suffix;

            //定义文件存储的最终路径
            String savePath = appConfig.getFilePath() + fileName;

            File dest = new File(savePath);
            if (!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);//保存文件
            }catch (IOException e){
                e.printStackTrace();
                return new FileResult("300","文件上传失败！");
            }

        }else {
            return new FileResult("300","文件上传失败！");
        }
        //将上传成功后的路径返回到前端
        String fileVisitPath = appConfig.getUrlPath() + "/public/upload/" + fileName;//为了在富文本编辑器中使用
        String filePath = fileName;//存表的
        List<String> list = new ArrayList<>();
        list.add(fileVisitPath);
        list.add(filePath);
        return new FileResult("200",list);
    }
}
