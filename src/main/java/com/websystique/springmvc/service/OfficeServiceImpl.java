package com.websystique.springmvc.service;


import com.websystique.springmvc.dao.OfficeDao;
import com.websystique.springmvc.model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service("officeService")
@Transactional
public class OfficeServiceImpl implements OfficeService{

    @Autowired
    private OfficeDao officeDao;


    @Override
    public List<Office> findAllOffices() {
        return officeDao.findAllOffices();

    }

    @Override
    public Office findById(int id) {
        return officeDao.findById(id);
    }

    @Override
    public void saveOffice(Office office) {
        officeDao.save(office);
    }

//    @Override
//    public String saveOffice(Office office) {   //todo try catch
//       try {
//           officeDao.save(office);
//       } catch ()
//
//    }

    @Override
    public void updateOffice(Office office) {
        Office entity = officeDao.findById(office.getId());
        if(entity!=null){
            entity.setId(office.getId());
            entity.setTitle(office.getTitle());
            entity.setAddress(office.getAddress());
            entity.setPhone1(office.getPhone1());
            entity.setPhone2(office.getPhone2());
            entity.setPostalCode(office.getPostalCode());
            Date currentDate = new Date();
            Timestamp timestamp = new Timestamp(currentDate.getTime());
            entity.setUpdatedTS(timestamp);
        }
    }

    @Override
    public void deleteOfficeById(int id) {
       if (!officeDao.findById(id).getTitle().equals("MAIN")) {
            officeDao.deleteById(id);
       }
    }
}
