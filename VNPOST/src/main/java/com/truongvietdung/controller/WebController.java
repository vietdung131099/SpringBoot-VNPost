package com.truongvietdung.controller;

import com.truongvietdung.entity.*;
import com.truongvietdung.model.response.PageResponse;
import com.truongvietdung.model.response.blog.BlogDisplayResponse;
import com.truongvietdung.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class WebController {

    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private DetailService_Service detailService_service;
    @Autowired
    private CityService cityService;
    @Autowired
    private ServiceCompanyService serviceCompanyService;

    @GetMapping("/danh-sach-tinh")
    public String getPageListProvince(Model model,@RequestParam int page,@RequestParam int size){
        PageRequest pageRequest = PageRequest.of(page-1,size);
        List<City> cities = cityService.findAll(pageRequest).getContent();
        PageResponse<City> pageResponse = PageResponse.of(cities.size(),cities,page,size);
        model.addAttribute("cities",pageResponse);
        return "listProvince";
    }

    @GetMapping("/404")
    public String getPage404(){
        return "404";
    }

    @GetMapping("/trang-chu")
    public String getPageHome(Model model){
        PageRequest pageRequest = PageRequest.of(0,5);
        List<Blog> blogs = blogService.findAll(pageRequest).getContent();
        model.addAttribute("blogs",blogs);
        return "home";
    }

    @GetMapping("/dang-nhap")
    public String getPageLogin(){
        return "login";
    }

    @GetMapping("/tin-tuc")
    public String getPageNews(Model model){
        // chỗ này là để load dữ liệu ra phần màu xanh
        List<SubCategory> tinVietNamPost = subCategoryService.findAllByCategoryId(1);
        List<SubCategory> buuDienVanHoaXa = subCategoryService.findAllByCategoryId(2);
        List<SubCategory> nguoiBuuDien = subCategoryService.findAllByCategoryId(3);
        List<SubCategory> hoatDongDangDoanThe = subCategoryService.findAllByCategoryId(4);

        model.addAttribute("tinVietNamPost",tinVietNamPost);
        model.addAttribute("buuDienVanHoaXa",buuDienVanHoaXa);
        model.addAttribute("nguoiBuuDien",nguoiBuuDien);
        model.addAttribute("hoatDongDangDoanThe",hoatDongDangDoanThe);

        // chỗ này là hiển thị phần nội dung đoạn 1 :
        PageRequest pageRequest = PageRequest.of(0,4);
        List<BlogDisplayResponse> tinVietNamPostContent = blogService.findAllByCategoryId(1,pageRequest);
        model.addAttribute("tinVietNamPostContent",tinVietNamPostContent);
        BlogDisplayResponse tinVietNamPostContentLeft = tinVietNamPostContent.get(0);
        model.addAttribute("tinVietNamPostContentLeft",tinVietNamPostContentLeft);

        // chỗ này là hiển thị phần nội dung đoạn 2 :
        List<BlogDisplayResponse> buuDienVanHoaXaContent = blogService.findAllByCategoryId(2,pageRequest);
        model.addAttribute("buuDienVanHoaXaContent",buuDienVanHoaXaContent);
        BlogDisplayResponse buuDienVanHoaXaContentLeft = buuDienVanHoaXaContent.get(0);
        model.addAttribute("buuDienVanHoaXaContentLeft",buuDienVanHoaXaContentLeft);

        // chỗ này là hiển thị phần nội dung đoạn 3 :
        List<BlogDisplayResponse> nguoiBuuDienContent = blogService.findAllByCategoryId(3,pageRequest);
        model.addAttribute("nguoiBuuDienContent",nguoiBuuDienContent);
        BlogDisplayResponse nguoiBuuDienContentLeft = nguoiBuuDienContent.get(0);
        model.addAttribute("nguoiBuuDienContentLeft",nguoiBuuDienContentLeft);

        // chỗ này là hiển thị phần nội dung đoạn 4 :
        List<BlogDisplayResponse> hoatDongDangContent = blogService.findAllByCategoryId(4,pageRequest);
        model.addAttribute("hoatDongDangContent",hoatDongDangContent);
        BlogDisplayResponse hoatDongDangContentLeft = hoatDongDangContent.get(0);
        model.addAttribute("hoatDongDangContentLeft",hoatDongDangContentLeft);

        return "news";
    }

    @GetMapping("/chi-tiet-tin-tuc/{id}")
    public String getPageDetailNews(Model model, @PathVariable int id){
        Blog detailBlog = blogService.findOneById(id).get();
        model.addAttribute("detailBlog",detailBlog);

        // hiển thị phần tin khác
        int categoryId = blogService.findOneById(id).get().getSubCategory().getCategory().getId();
        PageRequest pageRequest = PageRequest.of(0,10);
        List<BlogDisplayResponse> tinKhac = blogService.findAllByCategoryId(categoryId,pageRequest);
        model.addAttribute("tinKhac",tinKhac);

        return "detailNews";
    }

    @GetMapping("/danh-sach-tin-tuc/{id}") // lấy danh sách tin tức theo subCategoryId
    public String getPageListNewsBySubCategoryId(Model model, @PathVariable int id, @RequestParam int page,@RequestParam int size){
        PageRequest pageRequest = PageRequest.of(page-1,size);
        List<Blog> listBySubCategory = blogService.findAllBySubCategoryId(id,pageRequest);
        PageResponse pageResponse = PageResponse.of(listBySubCategory.size(),listBySubCategory,page,size);
        model.addAttribute("pageResponse",pageResponse);
        model.addAttribute("id",id);
        model.addAttribute("check",1);
        return "listNews";
    }


    @GetMapping("/danh-sach-tin-tuc/the-loai/{id}") // lấy danh sách tin tức theo categoryId
    public String getPageListNewsByCategoryId(Model model,@PathVariable int id, @RequestParam int page, @RequestParam int size){
        PageRequest pageRequest = PageRequest.of(page-1,size);
        List<Blog> listByCategory = blogService.findAllNewsByCategoryId(id,pageRequest);
        PageResponse pageResponse = PageResponse.of(listByCategory.size(),listByCategory,page,size);
        model.addAttribute("pageResponse",pageResponse);
        model.addAttribute("id",id);
        return "listNews";
    }


    // đây là các bài viết liên quan đến dịch vụ
    @GetMapping("/buu-chinh-chuyen-phat")
    public String getPagePostalDelivery(){
        return "buuchinhchuyenphat";
    }

    @GetMapping("/dich-vu/{id}")
    public String getPageServices(Model model,@PathVariable int id,@RequestParam int page,@RequestParam int size) {
        PageRequest pageRequest = PageRequest.of(page-1,size);
        List<DetailService> detailServices = detailService_service.findAllByServiceCompanyId(id,pageRequest);
        PageResponse<DetailService> pageResponse = PageResponse.of(detailServices.size(),detailServices,page,size);
        String serviceCompanyName = serviceCompanyService.findOneById(id).get().getName(); //lấy cái name của ServiceCompany để trả ra client
        model.addAttribute("detailServices",pageResponse);
        model.addAttribute("serviceCompanyName",serviceCompanyName);
        model.addAttribute("id",id);
        return "services";
    }

    @GetMapping("/chi-tiet-dich-vu/{id}")
    public String getPageDetailService(Model model,@PathVariable int id){
        DetailService detailService = detailService_service.findOneById(id).get();
        model.addAttribute("detailService",detailService);
        return "detailServices";
    }


}
