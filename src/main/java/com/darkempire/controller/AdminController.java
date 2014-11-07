package com.darkempire.controller;

import com.darkempire.model.Lab;
import com.darkempire.model.LabBundle;
import com.darkempire.services.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

/**
 * Created by Сергій on 03.11.2014.
 */
@Controller
public class AdminController {

    @Autowired
    private LabService labService;

    @RequestMapping(value = "/admin/lab_bundles")
    public String labBundles(WebRequest request, Model model){
        List<LabBundle> labBundleList = labService.getLabBundles();
        System.out.println(labBundleList.size());
        List<Lab> labs = (List)labBundleList.get(0).getLabsById();
        model.addAttribute("lab_bundle_list", labBundleList);

        return "/admin/lab_bundles";
    }
}
