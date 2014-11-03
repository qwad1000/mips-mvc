package com.darkempire.services;

import com.darkempire.dao.StudentDAO;
import com.darkempire.dao.StudentsGroupDAO;
import com.darkempire.model.LabBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Сергій on 03.11.2014.
 */
@Service
public class LabServiceImpl implements LabService {
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    StudentsGroupDAO studentsGroupDAO;
//    @Autowired
//    LabDAO labDAO;


}
