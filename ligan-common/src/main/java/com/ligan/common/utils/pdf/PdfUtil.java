package com.ligan.common.utils.pdf;



import com.aspose.words.Document;
import com.aspose.words.FontSettings;
import com.aspose.words.License;
import com.ligan.common.config.RuoYiConfig;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @program: yltcms
 * @description: word转pdf帮助类
 * @author: fenglg
 * @create: 2021-03-05 09:51
 **/
@Slf4j
public class PdfUtil {

    public static boolean getLicense(String path) throws FileNotFoundException {
        //File path = new File(ResourceUtils.getURL("classpath:").getPath());
        boolean result = false;
        try {
            // license.xml应放在..\WebRoot\WEB-INF\classes路径下
//            InputStream is =new FileInputStream(path+"\\static\\license.xml");
            InputStream is = new FileInputStream(path);
//            InputStream is = ContentValue.InputStream.get("license");
//            InputStream is = PdfUtil.class.getClassLoader().getResourceAsStream("license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            is.close();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getAbsoluteFile(String filename) {
        String downloadPath = RuoYiConfig.getDownloadPath() + filename;
        File desc = new File(downloadPath);
        if (!desc.getParentFile().exists()) {
            desc.getParentFile().mkdirs();
        }
        return downloadPath;
    }

    /**
     * @param wordPath 需要被转换的word全路径带文件名
     * @param pdfPath  转换之后pdf的全路径带文件名
     */
    public static String doc2pdf(String wordPath, String pdfPath, boolean delflag, String licensePath) throws FileNotFoundException {
        if (!getLicense(licensePath)) { // 验证License 若不验证则转化出的pdf文档会有水印产生
            return null;
        }
        String url = null;
        try {
            long old = System.currentTimeMillis();
            File file = new File(pdfPath); //新建一个pdf文档
            FileOutputStream os = new FileOutputStream(file);
            System.out.println("操作系统名称：" + System.getProperty("os.name")); // 操作系统名称
            if (!System.getProperty("os.name").contains("Windows")) {
                FontSettings.setFontsFolder("/usr/share/fonts" + File.separator, true);
            }
            Document doc = new Document(wordPath); //Address是将要被转化的word文档
            doc.save(os, com.aspose.words.SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
            long now = System.currentTimeMillis();
            os.close();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒"); //转化用时

            if (delflag) {
                log.info("word地址："+wordPath);
                log.info("pdf地址："+pdfPath);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pdfPath;
    }


    public static void main(String[] args) throws Exception {
    /*    File path = new File(ResourceUtils.getURL("classpath:").getPath());
        InputStream is =new FileInputStream(path+"\\static\\license.xml");
        ContentValue.InputStream.put("license",is);
        //word 和excel 转为pdf
        String filePaths="D:/110024-1-1.doc";
        String fileName="14";
        String pdfPath="D:/"+fileName+".pdf";
        //filePaths需要转换的文件位置 pdfPath为存储位置
        doc2pdf(filePaths, pdfPath,false);*/
        File file = new File("C:\\Users\\12163\\AppData\\Local\\Temp\\pattern6539370443479087889.oss-cn-beijingHT202011277836.pdf");
        Document doc = new Document("C:\\Users\\12163\\AppData\\Local\\Temp\\pattern6539370443479087889.oss-cn-beijingHT202011277836.doc");
        FileOutputStream os = new FileOutputStream(file);
        doc.save(os, com.aspose.words.SaveFormat.PDF);//全

    }
}
