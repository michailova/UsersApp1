package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Office;
import com.websystique.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository("officeDao")
public class OfficeDaoImpl extends AbstractDao<Integer, Office> implements OfficeDao{


    public List<Office> findAllOffices() {

        Criteria criteria = createEntityCriteria().addOrder(Order.asc("title"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Office> offices = (List<Office>) criteria.list();
        return offices;
        }

    @Override
    public Office findById(int id) {
        Office office = getByKey(id);
        if (office != null) {
            return office;
        }
        return null;
    }


    @Override
    public void save(Office office) {
        Date currentDate = new Date();
        Timestamp timestamp = new Timestamp(currentDate.getTime());
        office.setCreatedTS(timestamp);
        persist(office);
    }

    @Override
    public void update(Office office) {
        Date currentDate = new Date();
        Timestamp timestamp = new Timestamp(currentDate.getTime());
        office.setUpdatedTS(timestamp);
        persist(office);
    }


    @Override
    public void deleteById(int id) {
        Office office = getByKey(id);
        delete(office);
    }

    public List<Office> findAllOfficesByAddress(String address) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.like("address",address+"%"));

        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Office> offices = (List<Office>) criteria.list();
        return offices;
    }


}
