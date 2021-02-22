package com.vasitum.assessmentengine.questionbank.service;

import com.vasitum.assessmentengine.questionbank.responseDto.AssessmentDto;
import com.vasitum.assessmentengine.util.BasePage;

public interface AssessmentService {
     BasePage getAssessment(int page, int size);
     AssessmentDto findById(long id);
}
