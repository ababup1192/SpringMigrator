package org.ababup1192;

import org.ababup1192.book.after.Book;
import org.ababup1192.book.after.BookService;
import org.ababup1192.book.after.Category;
import org.ababup1192.book.before.BookCategory;
import org.ababup1192.book.before.BookCategoryRepository;
import org.ababup1192.book.query.BookCategoryMigrateService;
import org.ababup1192.member.after.NewMember;
import org.ababup1192.member.after.NewMemberRepository;
import org.ababup1192.member.before.OldMember;
import org.ababup1192.member.before.OldMemberRepository;
import org.ababup1192.member.query.MemberMigrateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MemberMigrationTest {
    @Autowired
    private OldMemberRepository oldMemberRepository;
    @Autowired
    private NewMemberRepository newMemberRepository;
    @Autowired
    private MemberMigrateService memberMigrateService;

    private static final String name1 = "Mike";
    private static final String name2 = "Alice";
    private static final String name3 = "John";

    private static final Integer weight1 = 55;
    private static final Integer weight2 = 45;
    private static final Integer weight3 = 100;

    // Initial data
    private static final List<OldMember> members = Arrays.asList(
            new OldMember(name1, weight1),
            new OldMember(name2, weight2),
            new OldMember(name3, weight3)
    );

    @Before
    public void SetUp() {
        oldMemberRepository.truncate();

        oldMemberRepository.save(members);
        memberMigrateService.migrate();
    }

    // Comment out this annotation if you check migrateTest only!!
    // @After
    public void tearDown() {
        newMemberRepository.drop();
    }

    @Test
    public void migrateTest() {
        List<NewMember> members = newMemberRepository.findAll();

        assertThat(members, contains(
                new NewMember(1, name1, weight1.doubleValue()),
                new NewMember(2, name2, weight2.doubleValue()),
                new NewMember(3, name3, weight3.doubleValue())
        ));
    }
}
