package com.example.studentsManagement.api;

import com.example.studentsManagement.exception.InvalidUniversityClassException;
import com.example.studentsManagement.model.UniversityClass;
import com.example.studentsManagement.service.UniversityClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/class")
public class UniversityClassController {

    private UniversityClassService universityClassService;

    @Autowired
    public UniversityClassController(UniversityClassService universityClassService) {
        this.universityClassService = universityClassService;
    }

    @GetMapping
    public List<UniversityClass> getAllClasses(){
        return universityClassService.getAllClasses();
    }

    @PostMapping
    @RequestMapping("/add")
    public ResponseEntity<String> addClass(@RequestBody UniversityClass universityClass){
        try {
            UniversityClass savedUniversityClass = universityClassService.addClass(universityClass);
            return ResponseEntity.ok("Class Added. " + savedUniversityClass.toString());
        } catch (InvalidUniversityClassException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
