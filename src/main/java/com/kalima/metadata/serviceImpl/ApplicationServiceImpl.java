package com.kalima.metadata.serviceImpl;


import com.kalima.metadata.entity.Application;
import com.kalima.metadata.repository.ApplicationRepository;
import com.kalima.metadata.services.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    final ApplicationRepository applicationRepository;

    @Override
    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Application getApplicationById(Long idApplication) {
        return applicationRepository.findApplicationById(idApplication);
    }

    @Override
    public Application updateApplication(Application application) {
        // TODO application must have an id, implement some security to check that
        if (applicationRepository.existsById(application.getId())) {
            return applicationRepository.save(application);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found with this id : " + application.getId());
        }
    }

    @Override
    public void deleteApplication(Long idApplication) {
        applicationRepository.deleteById(idApplication);
    }
    
}
