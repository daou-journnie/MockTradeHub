package org.example.mocktradehub.mapper;

import org.example.mocktradehub.model.Member;

public interface MemberMapper {
    Member getUserById(String id);
}
