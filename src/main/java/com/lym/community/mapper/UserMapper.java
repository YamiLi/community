package com.lym.community.mapper;


import com.lym.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId}," +
            "#{token},#{gmtCreate},#{gmtModified},#{avatarUrl} )")
    void insert(User user);

    @Select("SELECT id,name,account_id,token,gmt_create,gmt_modified from user where token = #{token}")
    User findByToken(String token);

    @Select("SELECT id,name,account_id,token,gmt_create,gmt_modified,bio,avatar_url from user where id = #{id}")
    User findById(Integer creator);
}
