package com.ligan.system.domain;

import lombok.Data;
import com.ligan.common.annotation.Excel;
import com.ligan.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 word_upload
 *
 * @author ruoyi
 * @date 2021-08-16
 */
@Data
public class WordUpload extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** wordName */
    @Excel(name = "wordName")
    private String name;

    /** 存放路径 */
    @Excel(name = "存放路径")
    private String path;

    /** 上传ip */
    @Excel(name = "上传ip")
    private String ip;

    /** 创建者id */
    @Excel(name = "创建者id")
    private Long createId;

    //主机名称
    private String hostName;

    //主机地址
    private String ipAddress;

}
