package com.plafoo.front.domain.posts;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*DB 레이어 접근자 (Dao) JAP 에서는 Repository 라고 부름*/
public interface PostsRepository extends JpaRepository<Posts, Long>{
	
	/*실제로 위 코드는 SpringDataJpa에서 제공하는 기본 메소드만으로 해결할 수 있는데요. 
굳이 @Query를 쓴 이유는, SpringDataJpa에서 제공하지 않는 메소드는 위처럼 쿼리로 작성해도 되는것을 보여주기 위함입니다.*/
    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}