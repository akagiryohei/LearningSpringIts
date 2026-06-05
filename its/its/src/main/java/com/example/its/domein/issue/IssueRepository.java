package com.example.its.domein.issue;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface IssueRepository {

    @Select("select * from issues")
    List<IssueEntity> findAll();

    @Insert("insert into issues (summary, description) values (#{summary}, #{description})")
    void insert(@Param("summary") String summary, @Param("description") String description);

    @Select("select id, summary, description from issues where id = #{issueId}")
    IssueEntity findById(@Param("issueId") long id);
}
