package com.example.village.dao.page;

import com.example.village.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PageRepositoryImpl implements PageRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Page> getAllInformation(){
        String sql="select * from village.main_page";
        return jdbcTemplate.query(sql,(rs,num)->new Page(rs.getInt("id"),rs.getInt("customer_count"),rs.getInt("sells"),
                rs.getFloat("bonus"),rs.getString("note")));
    }
}
