package com.networking.demo.controller;


import com.networking.demo.model.unused_models.RegisterBody;
import com.networking.demo.service.LearnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://54.205.133.124")
@RestController
public class LearnerController {
    private final LearnerService learnerService;


    public LearnerController(LearnerService learnerService) {
        this.learnerService = learnerService;
    }

    private final int test_variable = 10;
    @GetMapping("/testVariable2")
    public int getTestVariable() {
        return test_variable;
    }

    @PostMapping("/SignUp")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void signUp(@RequestBody RegisterBody body) {
        learnerService.signUp(body.email(), body.password(), body.firstName(), body.lastName());
    }

//    @GetMapping("/learned")
//    public ResponseEntity<List<Learner>> getLearnersByFinishedTopic(@RequestParam String topic) {
//        List<Learner> learners = learnerService.getLearnersByFinishedTopic(topic);
//        if (learners.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(learners);
//    }
//
//    @GetMapping("/ongoing")
//    public ResponseEntity<List<Learner>> getLearnersByOngoingTopic(@RequestParam String topic) {
//        List<Learner> learners = learnerService.getLearnersByOngoingTopic(topic);
//        if (learners.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(learners);
//    }
}
