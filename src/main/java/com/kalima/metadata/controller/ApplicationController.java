package com.kalima.metadata.controller;

import com.kalima.metadata.entity.Application;
import com.kalima.metadata.services.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/application")
@RequiredArgsConstructor
public class ApplicationController {

    final ApplicationService applicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Application createApplication(@RequestBody Application application) {
        return applicationService.createApplication(application);
    }

    @GetMapping(value = "/{idApplication}")
    @ResponseStatus(HttpStatus.OK)
    public Application getApplicationById(@PathVariable Long idApplication) {
        return applicationService.getApplicationById(idApplication);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Application updateApplication(@RequestBody Application application) {
        // application that coming must have an id
        return applicationService.updateApplication(application);
    }

    @DeleteMapping(value = "/{idApplication}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteApplication(@PathVariable Long idApplication) {
        applicationService.deleteApplication(idApplication);
    }

}
