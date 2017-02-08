package org.ababup1192.member.query;

import org.ababup1192.member.after.NewMember;
import org.ababup1192.member.after.NewMemberRepository;
import org.ababup1192.member.before.OldMemberRepository;
import org.ababup1192.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class MemberMigrateServiceImpl implements MemberMigrateService {
    private final OldMemberRepository oldMemberRepository;
    private final NewMemberRepository newMemberRepository;

    @Inject
    public MemberMigrateServiceImpl(
            OldMemberRepository oldMemberRepository,
            NewMemberRepository newMemberRepository
    ) {
        this.oldMemberRepository = oldMemberRepository;
        this.newMemberRepository = newMemberRepository;
    }

    @Transactional
    @Override
    public void migrate() {
        newMemberRepository.truncate();

        oldMemberRepository.findAll().forEach((m) ->
                newMemberRepository.save(new NewMember(m.getName(),
                        m.getWeight().doubleValue(), DateUtil.toDate(m.getCreateTime())))
        );
    }
}
