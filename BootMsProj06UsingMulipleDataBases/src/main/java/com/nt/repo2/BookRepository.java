package com.nt.repo2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity2.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

}
