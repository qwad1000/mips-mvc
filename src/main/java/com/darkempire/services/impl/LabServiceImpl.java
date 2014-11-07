package com.darkempire.services.impl;

import com.darkempire.dao.LabBundleDAO;
import com.darkempire.model.LabBundle;
import com.darkempire.services.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Сергій on 03.11.2014.
 */
@Service
public class LabServiceImpl implements LabService {
    @Autowired
    private LabBundleDAO labBundleDAO;

    @Override
    @Transactional
    public List<LabBundle> getLabBundles() {
        return labBundleDAO.list();
    }

}
