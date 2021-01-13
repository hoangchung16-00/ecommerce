package com.example.eCommerce.controllers.admin;

import com.example.eCommerce.forms.ProductForm;
import com.example.eCommerce.models.Category;
import com.example.eCommerce.models.Product;
import com.example.eCommerce.services.CategoryService;
import com.example.eCommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/list-product")
    public String getListProduct(final Model model){
        List<Product> products = productService.getListProduct();
        model.addAttribute("products",products);
        return "admin/list-product";
    }

    @GetMapping("/admin/add-product")
    public String getAddProduct(final Model model){
        model.addAttribute("productForm",new ProductForm());
        List<Category> categories = categoryService.getListCategory();
        model.addAttribute("categories",categories);
        return "admin/add-product";
    }

    @PostMapping("/admin/add-product")
    public String postAddProduct(@Valid @ModelAttribute("productForm") final ProductForm productForm, BindingResult bindingResult, @RequestParam("productImage") MultipartFile productImage,final Model model) throws IOException {
        if(bindingResult.hasErrors()){
            return "admin/add-product";
        }
        String fileName =productForm.getId().toString() + productImage.getOriginalFilename();
        if (!fileName.contains(".jpg") && !fileName.contains(".png")) {
            model.addAttribute("message", "Invalid image file");
            return "admin/add-product";
        }
        Path imagePath = Paths.get("src/main/resources/static/images/" + fileName);
        Files.write(imagePath, productImage.getBytes());
        productService.addProduct(productForm.getName(),productForm.getCategoryId(),productForm.getDescription(),productForm.getQuantity(),productForm.getPrice(),fileName);
        return "redirect:list-product";
    }
    @GetMapping("/admin/delete-product")
    public String getDeleteProduct(@RequestParam("productId") final Long id){
        productService.deleteProduct(id);
        return "redirect:list-product";
    }

    @GetMapping("/admin/edit-product")
    public String getEditProduct(final Model model,@RequestParam("productId") final Long id){
        if(id==null){
            return "redirect:list-product";
        }
        ProductForm productForm = productService.getProductFormById(id);
        model.addAttribute("productForm",productForm);
        List<Category> categories = categoryService.getListCategory();
        model.addAttribute("categories",categories);
        String imageName = productService.getProductImageById(id);
        model.addAttribute("imageName",imageName);
        return "admin/edit-product";
    }

    @PostMapping("/admin/edit-product")
    public String postEditProduct(@Valid @ModelAttribute("productform") final ProductForm productForm,BindingResult bindingResult,@RequestParam("productImage") MultipartFile productImage,final Model model) throws IOException {
        if(bindingResult.hasErrors()){
            return "admin/editp-product";
        }
        String newFileName = null;
        if(productImage!=null&&!productImage.isEmpty()){
            String oldFileName = productService.getProductImageById(productForm.getId());
            newFileName = productForm.getId().toString() + productImage.getOriginalFilename() ;
            Path oldImagePath = Paths.get("src/main/resources/static/images/" + oldFileName);
            Files.delete(oldImagePath);
            if (!newFileName.contains(".jpg") && !newFileName.contains(".png")) {
                model.addAttribute("message", "Invalid image file");
                return "admin/editProduct";
            }
            Path newImagePath = Paths.get("src/main/resources/static/images/" + newFileName);
            Files.write(newImagePath, productImage.getBytes());

        }
        productService.editProduct(productForm.getName(),productForm.getCategoryId(),productForm.getDescription(),productForm.getQuantity(),productForm.getPrice(),newFileName,productForm.getId());
        return "redirect:list-product";
    }


}
