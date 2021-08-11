package com.ligan.web.controller.pdforword;

import com.ligan.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ligan
 * @description: pdf及word操作
 * @author: fenglg
 * @create: 2021-08-11 17:34
 **/
@RequestMapping("/word")
@RestController
public class PdfOrWordController {

    public AjaxResult wordToPdf(){

        return AjaxResult.success();
    }
}
