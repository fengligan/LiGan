package com.ligan.system.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @program: ligan
 * @description: word操作类service
 * @author: fenglg
 * @create: 2021-08-12 09:22
 **/
public interface IWordService {

    int wordToPdf(MultipartFile[] words) throws Exception;
}
