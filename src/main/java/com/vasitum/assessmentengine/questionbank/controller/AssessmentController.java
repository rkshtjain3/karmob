package com.vasitum.assessmentengine.questionbank.controller;

import com.vasitum.assessmentengine.questionbank.responseDto.AssessmentDto;
import com.vasitum.assessmentengine.questionbank.service.AssessmentService;
import com.vasitum.assessmentengine.util.BasePage;
import com.vasitum.assessmentengine.util.response.service.IResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssessmentController {
    @Autowired
    AssessmentService assessmentService;

    @Autowired
    IResponseService responseService;

    @GetMapping("v1/assessments")
    public ResponseEntity<?> getAssessments(@RequestParam(required = false, defaultValue = "0") int page,
                                            @RequestParam(required = false, defaultValue = "10") int size) {
        BasePage assessmentBasePage = assessmentService.getAssessment(page, size);
        return ResponseEntity.ok().body(assessmentBasePage);
    }

    @GetMapping("v1/assessments/{assessmentId}")
    public ResponseEntity<?> getAssessmentById(@PathVariable(name = "assessmentId") long assessmentId) {
        AssessmentDto  assessmentDto = assessmentService.findById(assessmentId);
        if(assessmentDto!=null){
            return ResponseEntity.ok().body(assessmentDto);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assessment with this Id not found");
        }
    }
}
