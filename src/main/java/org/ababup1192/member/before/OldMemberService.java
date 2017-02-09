package org.ababup1192.member.before;

import org.ababup1192.common.Environment;

import java.util.List;

public interface OldMemberService {
    void save(List<OldMember> oldMembers);
    void truncate();
}
