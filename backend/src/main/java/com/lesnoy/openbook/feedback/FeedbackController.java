package com.lesnoy.openbook.feedback;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping("/{id}")
    public ResponseEntity<Feedback> saveFeedback(
            @PathVariable("id") int id,
            @RequestBody Feedback feedback) {
        return new ResponseEntity<>(feedbackService.save(id, feedback), HttpStatus.CREATED);
    }

}
