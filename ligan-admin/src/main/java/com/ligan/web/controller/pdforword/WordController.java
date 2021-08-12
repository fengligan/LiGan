package com.ligan.web.controller.pdforword;

import com.ligan.common.core.domain.AjaxResult;
import com.ligan.common.utils.pdf.PdfUtil;
import com.ligan.framework.Aop.WordLog;
import com.ligan.system.service.IWordService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @program: ligan
 * @description: word操作类
 * @author: fenglg
 * @create: 2021-08-11 17:34
 **/
@RequestMapping("/word")
@RestController
public class WordController {

    @Autowired
    private IWordService wordService;
    /**
     * word转换pdf
     * @return
     */
    @ApiOperation("word转化pdf")
    @GetMapping("/toPdf")
    @WordLog
    public AjaxResult wordToPdf(MultipartFile[] words){

        try {
            int a = wordService.wordToPdf(words);
        }catch (Exception e){
            e.printStackTrace();
        }


        return AjaxResult.success();
    }
}
