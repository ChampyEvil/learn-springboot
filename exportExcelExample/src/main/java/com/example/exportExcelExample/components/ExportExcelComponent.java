package com.example.exportExcelExample.components;

import com.example.exportExcelExample.services.ExportExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExportExcelComponent {

    @Autowired
    private ExportExcelService exportExcelService;

    @GetMapping("/exportExcel")
    public String exportExcel() {
        return "hello";
    }
}
