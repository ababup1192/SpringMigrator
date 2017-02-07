package org.ababup1192.member.after;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NewMemberRepository extends PagingAndSortingRepository<NewMember, Integer> {
    // Delete code on production
    @Query(value = "TRUNCATE TABLE new_member;", nativeQuery = true)
    @Modifying
    @Transactional
    void truncate();

    // Delete code on production
    @Query(value = "DROP TABLE new_member;", nativeQuery = true)
    @Modifying
    @Transactional
    void drop();

    @Override
    List<NewMember> findAll();
}
