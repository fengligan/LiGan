package com.ligan.system.service;

import java.util.List;
import com.ligan.system.domain.WordUpload;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2021-08-16
 */
public interface IWordUploadService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public WordUpload selectWordUploadById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param wordUpload 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<WordUpload> selectWordUploadList(WordUpload wordUpload);

    /**
     * 新增【请填写功能名称】
     * 
     * @param wordUpload 【请填写功能名称】
     * @return 结果
     */
    public int insertWordUpload(WordUpload wordUpload);

    /**
     * 修改【请填写功能名称】
     * 
     * @param wordUpload 【请填写功能名称】
     * @return 结果
     */
    public int updateWordUpload(WordUpload wordUpload);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteWordUploadByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteWordUploadById(Long id);
}
