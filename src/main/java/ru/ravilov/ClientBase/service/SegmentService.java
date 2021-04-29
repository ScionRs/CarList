package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.Motorcycle;
import ru.ravilov.ClientBase.model.Segment;
import ru.ravilov.ClientBase.repository.MotoRepository;
import ru.ravilov.ClientBase.repository.SegmentRepository;

import java.util.List;

@Service
public class SegmentService {

    private SegmentRepository segmentRepository;
    @Autowired
    public SegmentService(SegmentRepository segmentRepository) {
        this.segmentRepository = segmentRepository;
    }

    public List<Segment> listAll(){
        return  segmentRepository.findAll();
    }

    public Segment save(Segment segment){
        return segmentRepository.save(segment);
    }

    public Segment get(Long id){
        return segmentRepository.findById(id).get();
    }

    public void delete(Long id){
        segmentRepository.deleteById(id);
    }
}
