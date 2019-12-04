package com.cnu.motion.mapper;

import com.cnu.motion.DTO.ExamDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ExamMapper {
    ExamDTO getDetailByExamId(ExamDTO id);
}
