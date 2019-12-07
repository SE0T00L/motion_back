package com.cnu.motion.Subject;

import com.cnu.motion.DTO.SubjectDTO;
import com.cnu.motion.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectMapper subjectMapper;

    public List<SubjectDTO> getSubjects() {
        return subjectMapper.getSubjectsByGrade();
    }

    @Transactional(rollbackFor = SQLException.class)
    public void postSubjects(SubjectDTO subject) throws Exception {
        try {
            subjectMapper.postSubjects(subject);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

}
