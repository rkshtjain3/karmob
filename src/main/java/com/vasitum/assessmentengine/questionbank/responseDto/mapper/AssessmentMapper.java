package com.vasitum.assessmentengine.questionbank.responseDto.mapper;


import com.vasitum.assessmentengine.questionbank.model.Assessment;
import com.vasitum.assessmentengine.questionbank.responseDto.AssessmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AssessmentMapper {
    AssessmentMapper INSTANCE = Mappers.getMapper(AssessmentMapper.class);
    @Mapping(source = "difficultyLevel.level", target = "difficultyLevel")
    AssessmentDto assessmentToAssessmentDto(Assessment assessment);
    List<AssessmentDto> assessmentsToAssessmentDtos(List<Assessment> assessments);
}
