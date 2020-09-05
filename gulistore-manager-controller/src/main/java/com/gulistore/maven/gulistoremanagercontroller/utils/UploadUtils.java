package com.gulistore.maven.gulistoremanagercontroller.utils;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadUtils {

    private static String localhostIp;
    private static String port;
    private static FastFileStorageClient fastFileStorageClient;

    public static String FastUpload(MultipartFile multipartFile){
        try {
            String fileName = multipartFile.getOriginalFilename();
            String fileNameSuffix = fileName.substring(fileName.lastIndexOf('.') + 1);

            StorePath storePath = fastFileStorageClient.uploadFile(multipartFile.getInputStream(), multipartFile.getSize(), fileNameSuffix, null);
            String path = "http://" + localhostIp + ":" + port + "/" + storePath.getFullPath();
            return path;
        }catch (Exception e) {

        }
        return null;
    }

    @Autowired
    public void setFastFileStorageClient(FastFileStorageClient fastFileStorageClient) {
        UploadUtils.fastFileStorageClient = fastFileStorageClient;
    }

    @Value("${fdfs.ip}")
    public void setLocalhostIp(String localhostIp) {
        UploadUtils.localhostIp = localhostIp;
    }

    @Value("${fdfs.port}")
    public void setPort(String port) {
        UploadUtils.port = port;
    }
}
