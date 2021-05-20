package com.truongvietdung.controller;

import com.truongvietdung.entity.*;
import com.truongvietdung.model.response.PageResponse;
import com.truongvietdung.model.response.district.DistrictResponse;
import com.truongvietdung.model.response.subDistrict.SubDistrictResponse;
import com.truongvietdung.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ServiceCompanyService serviceCompanyService;
    @Autowired
    private DetailService_Service detailService_service;
    @Autowired
    private CityService cityService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private SubDistrictService subDistrictService;
    @Autowired
    private RoleGroupService roleGroupService;
    @Autowired
    private UsersService usersService;


    @GetMapping("/trang-chu")
    public String getPageAdminHome(){
        return "adminHome";
    }

    @GetMapping("/danh-sach/tin-tuc")
    public String getPageListBlogs(Model model, @RequestParam int page,@RequestParam int size){
        PageRequest pageRequest = PageRequest.of(page,size);
        List<Blog> blogs = blogService.findAll(pageRequest).getContent();
        PageResponse<Blog> pageResponse = PageResponse.of(blogs.size(),blogs,page,size);
        model.addAttribute("blogs",pageResponse);
        return "adminNewsList";
    }

    @GetMapping("/chinh-sua/tin-tuc") // thêm
    public String getPageAddBlog(Model model){
        SubCategory subCategory = new SubCategory();
        subCategory.setId(0);
        /**
         * vì nếu ko khởi tạo đối tượng SubCategory thì blog.getSubCategory.getId là null
         * => ở adminNewsEdit ở chỗ th:selected="${blog.subCategory.id}" nó sẽ bị lỗi
         * */
        Blog blog = new Blog();
        blog.setSubCategory(subCategory);
        model.addAttribute("blog",blog);
        /**
         * Lý do phải làm như thế này là bởi vì thằng thymeleaf khi mà có th:text="${...}" (thymeleaf mà chỉ cần trả giá trị thì ở controller buộc phải trả ra cái gì đó)
         * thì buộc ở server phải trả ra cái gì đó ko nó bị lỗi
         * */
        List<SubCategory> subCategories = subCategoryService.findAll();
        model.addAttribute("subCategories",subCategories);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "adminNewsEdit";
    }

    @GetMapping("/chinh-sua/tin-tuc/{id}") // sửa
    public String getPageEditBlog(Model model,@PathVariable int id){
        model.addAttribute("blog",blogService.findOneById(id).get());
        return "adminNewsEdit";
    }

    // chỗ này là chỗ dịch vụ
    @GetMapping("/danh-sach/chi-tiet/dich-vu")
    public String getPageListDetailServices(Model model,@RequestParam int page,@RequestParam int size) {
        PageRequest pageRequest = PageRequest.of(page-1,size);
        List<DetailService> detailServices = detailService_service.findAll(pageRequest).getContent();
        PageResponse pageResponse = PageResponse.of(detailServices.size(),detailServices,page,size);
        model.addAttribute("detailServices",pageResponse);
        return "adminDetailServiceList";
    }

    @GetMapping("/chinh-sua/chi-tiet/dich-vu")
    public String getPageAddDetailService(Model model){
        DetailService detailService = new DetailService();
        ServiceCompany serviceCompany = new ServiceCompany();
        detailService.setServiceCompany(serviceCompany);
        model.addAttribute("detailService",detailService);

        List<ServiceCompany> serviceCompanies = serviceCompanyService.findAll();
        model.addAttribute("serviceCompanies",serviceCompanies);
        return "adminDetailServiceEdit";
    }

    @GetMapping("/chinh-sua/chi-tiet/dich-vu/{id}")
    public String getPageEditDetailService(Model model,@PathVariable int id) {
        DetailService detailService = detailService_service.findOneById(id).get();
        model.addAttribute("detailService",detailService);

        List<ServiceCompany> serviceCompanies = serviceCompanyService.findAll();
        model.addAttribute("serviceCompanies",serviceCompanies);
        return "adminDetailServiceEdit";
    }

    // đây là các controller liên quan đến danh sách tỉnh , huyện , xã
    @GetMapping("/danh-sach/thanh-pho")
    public String getPageListCities(Model model,@RequestParam int page,@RequestParam int size) {
        PageRequest pageRequest = PageRequest.of(page-1,size);
        List<City> cities = cityService.findAll(pageRequest).getContent();
        PageResponse<City> pageResponse = PageResponse.of(cities.size(),cities,page,size);
        model.addAttribute("cities",pageResponse);
        return "adminCityList";
    }

    @GetMapping("/danh-sach/quan")
    public String getPageListDistricts(Model model,@RequestParam int page,@RequestParam int size) {
        PageRequest pageRequest = PageRequest.of(page-1,size);
        List<DistrictResponse> districtResponses = districtService.findDetailDistrict(pageRequest).getContent();
        PageResponse<DistrictResponse> pageResponse = PageResponse.of(districtResponses.size(),districtResponses,page,size);
        model.addAttribute("districts",pageResponse);
        return "adminDistrictList";
    }

    @GetMapping("/danh-sach/phuong")
    public String getPageListSubDistricts(Model model,@RequestParam int page,@RequestParam int size) {
        PageRequest pageRequest = PageRequest.of(page-1,size);
        List<SubDistrictResponse> subDistrictResponses = subDistrictService.findAllSubDistrictResponse(pageRequest);
        PageResponse<SubDistrictResponse> pageResponse = PageResponse.of(subDistrictResponses.size(),subDistrictResponses,page,size);
        model.addAttribute("subDistricts",pageResponse);
        return "adminSubDistrictList";
    }

    @GetMapping("/chinh-sua/thanh-pho")
    public String getPageAddCity(Model model){
        City city = new City();
        model.addAttribute("city",city);
        return "adminCityEdit";
    }

    @GetMapping("/chinh-sua/thanh-pho/{id}")
    public String getPageEditCity(Model model,@PathVariable String id) {
        City city = cityService.findOneById(id).get();
        model.addAttribute("city",city);
        return "adminCityEdit";
    }

    @GetMapping("/chinh-sua/quan")
    public String getPageAddDistrict(Model model) {
        District district = new District();
        model.addAttribute("district",district);

        List<City> cities = cityService.findAll();
        model.addAttribute("cities",cities);
        return "adminDistrictEdit";
    }

    @GetMapping("/chinh-sua/quan/{id}")
    public String getPageEditDistrict(Model model,@PathVariable String id) {
        District district = districtService.findOneById(id).get();
        model.addAttribute("district",district);

        List<City> cities = cityService.findAll();
        model.addAttribute("cities",cities);
        return "adminDistrictEdit";
    }

    @GetMapping("chinh-sua/phuong")
    public String getPageAddSubDistrict(Model model) {
        SubDistrict subDistrict = new SubDistrict();
        model.addAttribute("subDistrict",subDistrict);

        List<City> cities = cityService.findAll();
        model.addAttribute("cities",cities);
        return "adminSubDistrictEdit";
    }

    @GetMapping("chinh-sua/phuong/{id}")
    public String getPageEditSubDistrict(Model model,@PathVariable String id) {
        SubDistrict subDistrict = subDistrictService.findOneById(id).get();
        model.addAttribute("subDistrict",subDistrict);
        List<City> cities = cityService.findAll();
        model.addAttribute("cities",cities);
        List<District> districts = districtService.findAll();
        model.addAttribute("districts",districts);
        return "adminSubDistrictEdit";
    }

    // đây là các controller liên quan đến nhóm quyền
    @GetMapping("/danh-sach/nhom-quyen")
    public String getPageListRoleGroup(Model model,@RequestParam int page,@RequestParam int size) {
        PageRequest pageRequest = PageRequest.of(page-1,size);
        List<RoleGroup> roleGroups = roleGroupService.findAll(pageRequest).getContent();
        PageResponse<RoleGroup> pageResponse = PageResponse.of(roleGroups.size(),roleGroups,page,size);
        model.addAttribute("roleGroups",pageResponse);
        return "adminGroupRoleList";
    }

    @GetMapping("/chinh-sua/nhom-quyen")
    public String getPageAddGroupRole(Model model){
        RoleGroup roleGroup = new RoleGroup();
        model.addAttribute("roleGroup",roleGroup);

        Map<Integer,Boolean> check = new HashMap<>();
        for(int i=1;i<=41;i++){
            check.put(i,false);
        }
        model.addAttribute("check",check);
        return "adminGroupRoleEdit";
    }

    @GetMapping("/chinh-sua/nhom-quyen/{id}")
    public String getPageEditGroupRole(Model model,@PathVariable int id){
        RoleGroup roleGroup = roleGroupService.findOneById(id).get();
        model.addAttribute("roleGroup",roleGroup);

        Map<Integer,Boolean> check = new HashMap<>(); // đoạn này là xử lý để điền vào ô checkbox
        for(int i=1;i<=41;i++){
            check.put(i,false);
        }
        for(Role role : roleGroup.getRoles()){
            check.put(role.getId(),true);
        }
        model.addAttribute("check",check);

        return "adminGroupRoleEdit";
    }

    // đây là các controller liên quan đến users
    @GetMapping("/danh-sach/nguoi-dung")
    public String getPageListUsers(Model model,@RequestParam int page,@RequestParam int size){
        PageRequest pageRequest = PageRequest.of(page-1,size);
        List<Users> users = usersService.findAll(pageRequest).getContent();
        PageResponse<Users> pageResponse = PageResponse.of(users.size(),users,page,size);
        model.addAttribute("users",pageResponse);
        return "adminUsersList";
    }

    @GetMapping("/chinh-sua/nguoi-dung")
    public String getPageAddUsers(Model model) {
        Users users = new Users();
        model.addAttribute("users",users);

        List<RoleGroup> roleGroups = roleGroupService.findAll();
        model.addAttribute("roleGroups",roleGroups);

        Map<Integer,Boolean> check = new HashMap<>();
        for(int i=1;i<=100;i++){
            check.put(i,false);
        }
        for(RoleGroup i : users.getRoleGroups()){
            check.put(i.getId(),true);
        }
        model.addAttribute("check",check);
        return "adminUsersEdit";
    }

    @GetMapping("/chinh-sua/nguoi-dung/{id}")
    public String getPageEditUsers(Model model,@PathVariable int id){
        Users users = usersService.findOneById(id).get();
        model.addAttribute("users",users);

        List<RoleGroup> roleGroups = roleGroupService.findAll();
        model.addAttribute("roleGroups",roleGroups);

        Map<Integer,Boolean> check = new HashMap<>();
        for(int i=1;i<=100;i++){
            check.put(i,false);
        }
        for(RoleGroup i : users.getRoleGroups()){
            check.put(i.getId(),true);
        }
        model.addAttribute("check",check);
        return "adminUsersEdit";
    }

}
