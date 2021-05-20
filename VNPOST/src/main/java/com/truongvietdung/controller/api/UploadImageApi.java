package com.truongvietdung.controller.api;

import com.truongvietdung.model.request.UploadFile;
import com.truongvietdung.utils.UploadFileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@RequestMapping("/api")
public class UploadImageApi {

    @PostMapping("/image")
    public ResponseEntity<Void> upLoadImage(@RequestBody UploadFile uploadFile){
        byte[] decodeBase64 = Base64.getDecoder().decode(uploadFile.getBase64().getBytes());
        UploadFileUtils.writeOfUpdate(decodeBase64,"C:\\Users\\vietd\\Desktop\\ProjectVNPOST\\VNPOST\\src\\main\\webapp\\templates\\web\\img\\"+uploadFile.getName());
        return ResponseEntity.ok().build();
    }

}
