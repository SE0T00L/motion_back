package com.cnu.motion.Subject;

import com.cnu.motion.DTO.SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectService subjectService;


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
