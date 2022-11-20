package com.xxx.wxjsxy.dao;

import com.xxx.wxjsxy.iservice.IZoneService;
import com.xxx.wxjsxy.model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("ZoneDao")
public class ZoneDao implements IZoneService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Zone> selectZones() {
        String sql = "select * from zone";
        try {
            List<Zone> zones = jdbcTemplate.query(sql, new MyRowMapper());
            //如果数组中不存在任何元素，则返回 true。 然后为null查询不到数据
            if(zones.isEmpty() == true)
            {
                return null;
            }
            return zones;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    class MyRowMapper implements RowMapper<Zone>{
        public Zone mapRow(ResultSet rs, int rowNum) throws SQLException {
            Zone z = null;
            int id = Integer.parseInt(rs.getString(1));
            String name = rs.getString(2);
            String description = rs.getString(3);
            String zone = rs.getString(4);
            z = new Zone(id,name,description,zone);
            return z;
        }
    }
}
