package com.ligan.system.service.impl;

import java.util.List;
import com.ligan.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ligan.system.mapper.WordUploadMapper;
import com.ligan.system.domain.WordUpload;
import com.ligan.system.service.IWordUploadService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-08-16
 */
@Service
public class WordUploadServiceImpl implements IWordUploadService 
{
    @Autowired
    private WordUploadMapper wordUploadMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public WordUpload selectWordUploadById(Long id)
    {
        return wordUploadMapper.selectWordUploadById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param wordUpload 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<WordUpload> selectWordUploadList(WordUpload wordUpload)
    {
        return wordUploadMapper.selectWordUploadList(wordUpload);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param wordUpload 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertWordUpload(WordUpload wordUpload)
    {
        wordUpload.setCreateTime(DateUtils.getNowDate());
        return wordUploadMapper.insertWordUpload(wordUpload);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param wordUpload 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateWordUpload(WordUpload wordUpload)
    {
        return wordUploadMapper.updateWordUpload(wordUpload);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteWordUploadByIds(Long[] ids)
    {
        return wordUploadMapper.deleteWordUploadByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteWordUploadById(Long id)
    {
        return wordUploadMapper.deleteWordUploadById(id);
    }
}
