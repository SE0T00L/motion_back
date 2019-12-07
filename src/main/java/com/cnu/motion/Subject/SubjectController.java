package com.cnu.motion.Subject;

import com.cnu.motion.DTO.SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectService subjectService;


    @GetMapping()
    public List<SubjectDTO> getSubjects() {
        return subjectService.getSubjects();
    }

    @PostMapping()
    public String postSubjects(@RequestBody SubjectDTO subject){
        try{
            subjectService.postSubjects(subject);
        }catch(Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }



}
