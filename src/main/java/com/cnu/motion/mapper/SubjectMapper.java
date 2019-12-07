package com.cnu.motion.mapper;


import com.cnu.motion.DTO.SubjectDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SubjectMapper {
    List<SubjectDTO> getSubjects();
    void postSubjects(SubjectDTO subject);
}
