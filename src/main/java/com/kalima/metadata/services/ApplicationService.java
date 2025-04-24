package com.kalima.metadata.services;

import com.kalima.metadata.entity.Application;


public interface ApplicationService {

    Application createApplication(Application application);

    Application getApplicationById(Long idApplication);

    Application updateApplication(Application application);

    void deleteApplication(Long idApplication);

}