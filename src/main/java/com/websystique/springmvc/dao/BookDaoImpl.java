package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Book;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


import java.util.List;

public class BookDaoImpl extends AbstractDao<Integer, Book> implements BookDao{

    @Override
    public List<Book> findAllBooks() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name")); //createEntityCriteria().addOrder it is sorting ASK or DESK
      //  criteria.add(Restrictions.and("name",name+"%")); todo 21:01 as in delete
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Book> books = (List<Book>) criteria.list();
        return books;
    }

    @Override
    public Book findById(int id) {
        Book book = getByKey(id);
        if (book != null) {
            return book;
        }
        return null;
    }


    @Override
    public void save(Book book) {
        persist(book);

    }

    @Override
    public void deleteById(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Book book = (Book) crit.uniqueResult();
        delete(book);
    }
    }

