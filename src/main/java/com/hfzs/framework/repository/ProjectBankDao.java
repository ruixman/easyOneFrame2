package com.hfzs.framework.repository;

import com.hfzs.framework.core.web.orm.MyJpaRepository;
import com.hfzs.framework.core.web.orm.MyJpaSpecificationExecutor;
import com.hfzs.framework.domain.ProjectBank;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Administrator on 2017/7/21.
 */
@org.springframework.stereotype.Repository("projectBankDao")
public interface ProjectBankDao extends MyJpaRepository<ProjectBank,String>{

    @Query("select pb from ProjectBank pb where pb.projectNo=:projectNo")
    ProjectBank findByProjectNo(@Param("projectNo")String projectNo);

    public ProjectBank findOne(String id);
}
