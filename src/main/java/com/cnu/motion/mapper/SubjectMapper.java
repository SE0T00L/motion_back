package com.cnu.motion.mapper;


import com.cnu.motion.DTO.SubjectDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SubjectMapper {
    void postSubjects(SubjectDTO subject);
}
