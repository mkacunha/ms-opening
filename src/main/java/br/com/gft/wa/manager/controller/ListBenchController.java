package br.com.gft.wa.manager.controller;


import br.com.gft.wa.manager.service.bench.Bench;
import br.com.gft.wa.manager.service.bench.ListBench;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListBenchController {

    private final ListBench listBench;

    public ListBenchController(ListBench listBench) {
        this.listBench = listBench;
    }

    @GetMapping("/manager/bench")
    public List<Bench> get(@RequestParam(required = false, name = "filter") String filter) {
        return listBench.list(filter);
    }


}
