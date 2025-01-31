package com.exam.examserver.controller;
import com.exam.examserver.model.exam.Category;
import com.exam.examserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    //add Category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category category1 = this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }
    //get Category
    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable ("categoryId") Long categoryId){
        return  this.categoryService.getCategoryById(categoryId);
    }
    //get All Categories
    @GetMapping("/")
    public ResponseEntity<?> getAllCategories(){
        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }
    //update Category
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category){
        return this.categoryService.updateCategory(category);
    }
    //delete Category
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        this.categoryService.deleteCategory(categoryId);
    }
}
