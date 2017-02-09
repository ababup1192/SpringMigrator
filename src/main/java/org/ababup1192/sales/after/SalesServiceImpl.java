package org.ababup1192.sales.after;

import org.ababup1192.common.Environment;
import org.ababup1192.member.before.OldMember;
import org.ababup1192.member.before.OldMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {
    private final OldMemberRepository oldMemberRepository;
    private Environment environment;

    @Autowired
    public SalesServiceImpl(OldMemberRepository oldMemberRepository, Environment environment) {
        this.oldMemberRepository = oldMemberRepository;
        this.environment = environment;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void save(List<OldMember> oldMembers) {
        oldMembers.forEach(oldMember -> oldMember.setCreateTime(environment.getTimeMilliSeconds()));
        oldMemberRepository.save(oldMembers);
    }

    @Override
    public void truncate() {
        oldMemberRepository.truncate();
    }
}
