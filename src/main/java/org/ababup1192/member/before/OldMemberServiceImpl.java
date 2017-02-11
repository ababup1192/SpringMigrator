package org.ababup1192.member.before;

import org.ababup1192.common.Environment;
import org.ababup1192.member.after.NewMember;
import org.ababup1192.member.after.NewMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OldMemberServiceImpl implements OldMemberService {
    private final OldMemberRepository oldMemberRepository;
    private Environment environment;

    @Autowired
    public OldMemberServiceImpl(OldMemberRepository oldMemberRepository, Environment environment) {
        this.oldMemberRepository = oldMemberRepository;
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
