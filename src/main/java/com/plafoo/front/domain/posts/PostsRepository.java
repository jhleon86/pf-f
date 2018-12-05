package com.plafoo.front.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/*DB 레이어 접근자 (Dao) JAP 에서는 Repository 라고 부름*/
public interface PostsRepository extends JpaRepository<Posts, Long>{
}