package com.ligan.web.controller.pdforword;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ligan.common.annotation.Log;
import com.ligan.common.core.controller.BaseController;
import com.ligan.common.core.domain.AjaxResult;
import com.ligan.common.enums.BusinessType;
import com.ligan.system.domain.WordUpload;
import com.ligan.system.service.IWordUploadService;
import com.ligan.common.utils.poi.ExcelUtil;
import com.ligan.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2021-08-16
 */
@RestController//
@RequestMapping("/system/upload")
public class WordUploadController extends BaseController
{
    @Autowired
    private IWordUploadService wordUploadService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:upload:list')")
    @GetMapping("/list")
    public TableDataInfo list(WordUpload wordUpload)
    {
        startPage();
        List<WordUpload> list = wordUploadService.selectWordUploadList(wordUpload);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:upload:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WordUpload wordUpload)
    {
        List<WordUpload> list = wordUploadService.selectWordUploadList(wordUpload);
        ExcelUtil<WordUpload> util = new ExcelUtil<WordUpload>(WordUpload.class);
        return util.exportExcel(list, "upload");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:upload:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wordUploadService.selectWordUploadById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:upload:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WordUpload wordUpload)
    {
        return toAjax(wordUploadService.insertWordUpload(wordUpload));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:upload:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WordUpload wordUpload)
    {
        return toAjax(wordUploadService.updateWordUpload(wordUpload));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:upload:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wordUploadService.deleteWordUploadByIds(ids));
    }
}
