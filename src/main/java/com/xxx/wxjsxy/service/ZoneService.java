package com.xxx.wxjsxy.service;

import com.xxx.wxjsxy.dao.ZoneDao;
import com.xxx.wxjsxy.model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ZoneService")
public class ZoneService {

    @Autowired
    private ZoneDao zoneDao;

    public List<Zone> selectZones(){
        List<Zone> zones = zoneDao.selectZones();
        return zones;
    }
}
