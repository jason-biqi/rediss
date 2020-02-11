package com.magic.redis.dao;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import com.magic.redis.entity.AboutCompany;

import java.util.List;
import java.util.Map;

@Repository
public interface AboutCompanyMapper extends Mapper<AboutCompany>  {

   Page<Map<String,String>> findTileAndCount(List list);

    AboutCompany findById(Integer id);

}
