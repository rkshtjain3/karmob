package com.vasitum.assessmentengine.questionbank.service.impl;

import com.vasitum.assessmentengine.questionbank.model.Assessment;
import com.vasitum.assessmentengine.questionbank.repository.AssessmentRepository;
import com.vasitum.assessmentengine.questionbank.responseDto.AssessmentDto;
import com.vasitum.assessmentengine.questionbank.responseDto.mapper.AssessmentMapper;
import com.vasitum.assessmentengine.questionbank.service.AssessmentService;
import com.vasitum.assessmentengine.util.BasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Override
    public BasePage getAssessment(int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "cTime");
            Page<Assessment> assessmentPage = assessmentRepository.findAll(pageable);
            List<Assessment> assessments = assessmentPage.getContent();
            List<AssessmentDto> assessmentDtos = AssessmentMapper.INSTANCE.assessmentsToAssessmentDtos(assessments);
            BasePage basePage = new BasePage();
            basePage.setTotalPages(assessmentPage.getTotalPages());
            basePage.setTotalElements(assessmentPage.getTotalElements());
            basePage.setSize(assessmentPage.getSize());
            basePage.setPage(assessmentPage.getNumber());
            basePage.setContent(assessmentDtos);
            return basePage;
        } catch (Exception e) {
            e.printStackTrace();
            return new BasePage();
        }
    }

    @Override
    public AssessmentDto findById(long id) {
        Optional<Assessment> optionalAssessment = assessmentRepository.findById(id);
        if (optionalAssessment.isPresent()) {
            return AssessmentMapper.INSTANCE.assessmentToAssessmentDto(optionalAssessment.get());
        }
        return null;
    }
}
