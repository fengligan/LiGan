package com.ligan.web.controller.pdforword;

import java.util.Date;
import java.util.List;

import com.ligan.common.config.RuoYiConfig;
import com.ligan.common.core.domain.entity.SysUser;
import com.ligan.common.core.domain.model.LoginUser;
import com.ligan.common.utils.ServletUtils;
import com.ligan.common.utils.file.FileUploadUtils;
import com.ligan.common.utils.ip.IpUtils;
import com.ligan.framework.config.ServerConfig;
import com.ligan.framework.web.service.TokenService;
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
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private ServerConfig serverConfig;
    @Autowired
    TokenService tokenService;
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


    /**
     * 导入需要转换的word
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:user:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        WordUpload wordUpload = new WordUpload();
        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();
      //  for (MultipartFile file : files) {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            wordUpload.setCreateId(user.getUserId());
            wordUpload.setName(fileName);
            wordUpload.setPath(url);
            wordUpload.setHostName(IpUtils.getHostName());
            wordUpload.setIpAddress(IpUtils.getIpAddr(ServletUtils.getRequest()));
            wordUpload.setIp(IpUtils.getHostIp());
            wordUpload.setCreateBy(user.getUserName());
            wordUpload.setCreateTime(new Date());
            wordUploadService.insertWordUpload(wordUpload);
     //   }

        return AjaxResult.success();
    }



}
