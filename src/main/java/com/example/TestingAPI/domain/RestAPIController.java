package com.example.TestingAPI.domain;

import com.example.TestingAPI.service.RestAPIService;
import com.example.TestingAPI.vo.Bbs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RestAPIController {
    private final RestAPIService service;

    @GetMapping("/getBBSList")
    public List<Bbs> getBbsList(){
        return service.getBbsList();
    }

    @GetMapping("/cntBBSList")
    public Integer cntBBSList() {
        return service.cntBBSList();
    }

    @GetMapping("/getBBS/{id}")
    public Bbs getBBS(@PathVariable(value="id", required = true)int bbsId, HttpServletResponse response, Bbs bbs) throws IOException {
        bbs = service.getBBS(bbsId);
        return bbs;
    }

    @GetMapping("/getBBSPage")
    public List<Bbs> getBBSPages(@PageableDefault(sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
        return service.findByPage(pageable);
    }

    @PostMapping("/postBBS")
    public void postBBS(
            @RequestParam(required = false, defaultValue = "내용없음") String postText
            ,@RequestParam(required = false, defaultValue = "제목없음") String title
            ,@RequestParam(required = true) String regUser) {
        service.postBBS(
                Bbs.builder()
                        .postText(postText)
                        .title(title)
                        .regUser(regUser)
                        .build()
        );
    }
}
