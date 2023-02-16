package com.example.TestingAPI.service;

import com.example.TestingAPI.dao.RestAPIRepository;
import com.example.TestingAPI.vo.Bbs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RestAPIService {
    private final RestAPIRepository repository;

    public List<Bbs> getBbsList() {
        return repository.findAll();
    }

    public Bbs getBBS(Integer id) {
        Optional<Bbs> bbs = repository.findById(id);
        return bbs.isPresent() ? bbs.get() : new Bbs();
    }

    public void postBBS(Bbs bbs) {
        repository.save(bbs);
    }

    public List<Bbs> findByPage(Pageable pageable){
//        Long bbsCnt = repository.count();
        return repository.findAll(pageable).toList();

    }

    public Integer cntBBSList() {
        return (int) repository.count();
    }
}
