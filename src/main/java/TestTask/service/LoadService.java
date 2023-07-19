package TestTask.service;

import TestTask.entity.Load;
import TestTask.repository.LoadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoadService {

    private final LoadRepository loadRepository;

    public Load addLoad(Load load){
        return loadRepository.save(load);
    }

    public List<Load> getLoadsByShipperId(String shipperId){
        return loadRepository.findByShipperId(shipperId);
    }

    public Load getById(Long id){
        return loadRepository.findById(id).orElse(null);
    }

    public Load updateLoad(Long id, Load updatedLoad){
        Load currentLoad = loadRepository.findById(id).orElse(null);

        if(currentLoad != null){
            currentLoad = updatedLoad;
            currentLoad.setId(id);
            return loadRepository.save(currentLoad);
        } else {
            return null;
        }
    }

    public void deleteLoad(Long id){
        loadRepository.deleteById(id);
    }

}
