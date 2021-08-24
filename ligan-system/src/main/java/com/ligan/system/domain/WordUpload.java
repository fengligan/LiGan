package com.ligan.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ligan.common.annotation.Excel;
import com.ligan.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 word_upload
 * 
 * @author ruoyi
 * @date 2021-08-16
 */
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

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPath(String path) 
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }
    public void setIp(String ip) 
    {
        this.ip = ip;
    }

    public String getIp() 
    {
        return ip;
    }
    public void setCreateId(Long createId) 
    {
        this.createId = createId;
    }

    public Long getCreateId() 
    {
        return createId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("path", getPath())
            .append("ip", getIp())
            .append("createBy", getCreateBy())
            .append("createId", getCreateId())
            .append("createTime", getCreateTime())
            .toString();
    }
}
