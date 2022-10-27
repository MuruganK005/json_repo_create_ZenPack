package com.ZenPack.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ZenPack.excel.ZenPackExcelExporter;
import com.ZenPack.exception.ZenPackException;
import com.ZenPack.repository.ZenPackExcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ZenPack.Dto.SpecificationDto;
import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.Specification.SearchRequest;
import com.ZenPack.model.ZenPack;
import com.ZenPack.repository.ZenPackRepository;
import com.ZenPack.service.Impl.ZenPackServiceImpl;
import com.ZenPack.service.Services.SpecificationService;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1")
public class ZenPackController {

    @Autowired
    private ZenPackServiceImpl service;

    @Autowired
    private ZenPackRepository zenPackRepository;

    @Autowired
    private SpecificationService specificationService;

    @Autowired
    private ZenPackExcelRepository excelRepository;


    @PostMapping("/save")
    public ResponseEntity<ZenPack> saveZenPack(@RequestBody ZenPack zenPack) {
        return service.saveZenPack(zenPack);
    }

    @PostMapping("/create")//new One
    public ResponseEntity<ZenPackDto> createZenPack(@RequestBody ZenPackDto zenPackDto) throws ZenPackException {
        /*if(zenPackDto == null || service.checkZenPackName(zenPackDto.getName())){
    		return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
    	}*/
        return service.createZenPack(zenPackDto);
    }
    @PostMapping("/check_zen_pack_name")//new one
    public boolean checkZenPackByName(@RequestBody ZenPackDto zenPackDto){
        return service.checkZenPackName(zenPackDto.getName());
    }
    @GetMapping(value = "get_all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ZenPackDto> getAllZenPack() throws JsonProcessingException {
        return service.getAllZenPack();
    }
    @DeleteMapping("/delete/{zenPackId}")
    public String deleteByZenPackId(@PathVariable Long zenPackId){
        return service.deleteByzenPackId(zenPackId);
    }
    @GetMapping("/getByZenPackId/{zenPackId}")
    public ZenPackDto getByZenPackId(@PathVariable Long zenPackId){
        return service.getByZenPackId(zenPackId);
    }

    @PostMapping("/search")
    public ResponseEntity<Page<ZenPack>> getBySpecification(@RequestBody SpecificationDto specificationDto){
        ResponseEntity<Page<ZenPack>> response = specificationService.getBySpecification(specificationDto);
        return new ResponseEntity<>(response.getBody(),response.getStatusCode());
    }
    
    @PostMapping("/searchZenPack")
    public Page<ZenPack> searchZenPack(@RequestBody SearchRequest request) {
        return service.searchZenPack(request);
    }

    @GetMapping("/export/excel")//new one
    public void exportToExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headervalue = "attachment; filename=ZenPack_info"+currentDateTime+".xlsx";

        response.setHeader(headerKey, headervalue);
        List<ZenPack> listStudent = excelRepository.findAll();
        ZenPackExcelExporter exp = new ZenPackExcelExporter(listStudent);
        exp.export(response);
    }

}
