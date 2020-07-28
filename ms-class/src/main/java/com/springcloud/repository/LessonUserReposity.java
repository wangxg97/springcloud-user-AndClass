package com.springcloud.repository;

import com.springcloud.domain.entity.LessonUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonUserReposity extends CrudRepository<LessonUser,Integer> {
    LessonUser findByLessonId(int id);
}
