package com.bjb.config;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:处理文件上传后的路径
 */
@Data
public class FileResult {
    private String code;
    private List<String> data;

    public FileResult(String code, List<String> data) {
        this.code = code;
        this.data = data;
    }

    public FileResult(String code, String data) {
        this.code = code;
        this.data = new ArrayList<>();
        this.data.add(data);
    }
}
