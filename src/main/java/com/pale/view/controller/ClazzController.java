package com.pale.view.controller;

import com.pale.view.model.Clazz;
import com.pale.view.repository.ClazzRepository;
import com.pale.view.response.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClazzController {
    private final ClazzRepository clazzRepository;

    public ClazzController(ClazzRepository clazzRepository) {
        this.clazzRepository = clazzRepository;
    }

}
