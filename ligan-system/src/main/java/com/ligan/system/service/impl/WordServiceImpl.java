package com.ligan.system.service.impl;

import com.ligan.common.config.RuoYiConfig;
import com.ligan.common.utils.file.FileUploadUtils;
import com.ligan.common.utils.pdf.PdfUtil;
import com.ligan.system.service.IWordService;
import com.ligan.system.utils.ServerConfigUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * @program: ligan
 * @description: word操作类Service实现类
 * @author: fenglg
 * @create: 2021-08-12 09:23
 **/
@Service
public class WordServiceImpl implements IWordService {
    private Logger log = LoggerFactory.getLogger(WordServiceImpl.class);

    @Autowired
    private ServerConfigUtils serverConfig;

    //word转pdf地址
    @Value("${ruoyi.wordToPdfPath}")
    private String wordToPdfPath;

    @Value("${licensePath}")
    private String licensePath;


    @Override
    public int wordToPdf(MultipartFile[] words) throws Exception {
        Map<String,String> urlsMap = new HashMap<>();
        List<String> pdfUrls = new ArrayList<>();
        for (MultipartFile file : words) {
                // 上传文件路径
                String filePath = RuoYiConfig.getUploadPath();
                // 上传并返回新文件名称
                String fileName = FileUploadUtils.upload(filePath, file);
                String url = serverConfig.getUrl() + fileName;
                urlsMap.put(fileName,url);
        }
        for (Map.Entry<String, String> set : urlsMap.entrySet()) {
            //word文件上传的路径
            String pdfPath = PdfUtil.doc2pdf(set.getValue(), wordToPdfPath + set.getKey() + ".pdf", true, licensePath);
            pdfUrls.add(pdfPath);
        }


        return 1;
    }
}
