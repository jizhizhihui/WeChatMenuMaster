package com.wxMenuProvider.project.serverImpl;

import com.wxMenuAPI.project.service.IFileService;
import com.wxMenuAPI.utils.ImageUtils;
import com.wxMenuProvider.utils.FileUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.web.multipart.MultipartFile;

@Log4j2
@Service(version = "1.0.0")
public class FileServiceImpl implements IFileService {

    @Override
    public boolean upLoadHeader(int userId, MultipartFile file){
        try{
            //保存图片
            FileUtils.uploadImage(file, ImageUtils.userHeaderPath(file.getName()));
            //保存头像路径
            return true;
        } catch (Exception e){
            log.error("头像存储失败：" + e);
        }
        return false;
    }

    @Override
    public  boolean uploadImage(MultipartFile file, String path){
       return FileUtils.uploadImage(file,path);
    }
}
